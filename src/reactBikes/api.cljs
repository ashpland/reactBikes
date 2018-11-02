(ns reactBikes.api
  (:require [reactBikes.state :as state]
            [clojure.string :as str]))

(def testJSON "{\"name\":\"0001 10th & Cambie\",\"coordinates\":\"49.262487, -123.114397\",\"total_slots\":52,\"free_slots\":32,\"avl_bikes\":20,\"operative\":true,\"style\":\"\"}")

(def output (js->clj (.parse js/JSON testJSON)))

(defn splitID
  [nameString]
  (if (string? nameString)
    (let [components (str/split nameString #" " 2)]
      {:id (keyword (components 0)) :stationName (components 1)})))

(defn splitCoordinates
  [coordinatesString]
  (if (string? coordinatesString)
    (let [components (str/split coordinatesString #", " 2)]
      {:coordinates {:lat (js/parseFloat (components 0))
                     :lon (js/parseFloat (components 1))}})))

(defn parseStation
  [rawStation]
  (merge (splitID (get rawStation "name"))
         (splitCoordinates (get rawStation "coordinates"))
         {:availableDocks (get rawStation "free_slots")
          :availableBikes (get rawStation "avl_bikes")}))

(def newStation (parseStation output))

(defn convertJSON
  []
  (swap! state/stations assoc (newStation :id) newStation)
  [:div])
