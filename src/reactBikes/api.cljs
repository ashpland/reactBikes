(ns reactBikes.api
  (:require [reactBikes.state :as state]
            [reactBikes.location :refer [distance]]
            [clojure.string :as str]
            [cljs-http.client :as http]
            [clojure.core.async :as async]))

(defn splitID
  [nameString]
  (if (string? nameString)
    (let [components (str/split nameString #" " 2)]
      {:id (keyword (components 0)) :stationName (components 1)})))

(defn splitCoordinates
  [coordinatesString]
  (if (string? coordinatesString)
    (let [components (str/split coordinatesString #"," 2)]
      {:lat (js/parseFloat (components 0))
       :lon (js/parseFloat (components 1))})))

(defn getDistance
  [coordinatesString location]
  {:distance (distance 
               (splitCoordinates coordinatesString) location)})

(defn parseStation
  [{:keys [name coordinates free_slots avl_bikes]} location]
  (merge (splitID name)
         (getDistance coordinates location)
         {:availableDocks free_slots
          :availableBikes avl_bikes}))

(defn updateStation
  [s]
  (swap! state/stations assoc (:id s) s))

(defn updateStations
  [newStations]
  (let [l @state/location]
    (doseq [s newStations] (updateStation (parseStation s l)))))

(defn getFromNetwork
  []
  (async/go
    (let [response (async/<! (http/get "/stations.json"))]
      (updateStations (:result (:body response))))))
