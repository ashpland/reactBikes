(ns reactBikes.station
  (:require [reactBikes.state :as state])
  (:require [reactBikes.location :refer [distance]]))

(defn kms
  [meters]
  (/ (Math/round (/ meters 10)) 100))

(defn station
  [{:keys [id stationName availableBikes availableDocks distance]}]
  [:div.station
   {:key (str id)}
   [:p stationName]
   [:ul
    [:li (str "Bikes: " availableBikes)]
    [:li (str "Docks: " availableDocks)]
    [:li (str "Distance: " (kms distance) " km")]]])

(defn allStations
  []
    [:div#allStations 
     (map 
       #(station %) 
       (sort-by :distance (vals @state/stations)))])
