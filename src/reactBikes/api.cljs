(ns reactBikes.api
  (:require [reactBikes.state :as state]
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
      {:coordinates {:lat (js/parseFloat (components 0))
                     :lon (js/parseFloat (components 1))}})))

(defn parseStation
  [{:keys [name coordinates free_slots avl_bikes]}]
  (merge (splitID name)
         (splitCoordinates coordinates)
         {:availableDocks free_slots
          :availableBikes avl_bikes}))

(defn updateStation
  [s]
  (swap! state/stations assoc (:id s) s))

(defn updateStations
  [newStations]
  (doseq [s newStations] (updateStation (parseStation s))))

(defn getFromNetwork
  []
  (async/go
    (let [response (async/<! (http/get "/stations.json"))]
      (updateStations (:result (:body response))))))
