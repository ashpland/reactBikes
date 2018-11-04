(ns reactBikes.station
  (:require [reactBikes.state :as state]))

(defn station
  [{:keys [id stationName availableBikes availableDocks]}]
  [:div.station
   {:key (str id)}
   [:p stationName]
   [:ul
    [:li (str "Bikes: " availableBikes)]
    [:li (str "Docks: " availableDocks)]]])

(defn allStations
  []
  [:div#allStations (map #(station %) (sort-by :id (vals @state/stations)))])
