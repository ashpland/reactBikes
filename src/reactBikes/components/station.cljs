(ns reactBikes.components.station)

(defn station
  [stationData]
  [:div.station
   {:key (str (stationData :id))}
   [:p (stationData :stationName)]])

(defn displayAll
  [stations]
  (map #(station %) stations))
