(ns reactBikes.api
  (:require [reactBikes.state :as state]))

(def testJSON "{\"name\":\"0001 10th & Cambie\",\"coordinates\":\"49.262487, -123.114397\",\"total_slots\":52,\"free_slots\":32,\"avl_bikes\":20,\"operative\":true,\"style\":\"\"}")

(def output (js->clj (.parse js/JSON testJSON)))

(defn convertJSON
  []
  (swap! state/stations assoc
         :0002 {:id :0002
                :stationName "Thsdfioj Station"
                :coordinates {:lat 0.0 :lon 0.0}
                :availableDocks (get output "free_slots")
                :availableBikes (get output "avl_bikes")})
  [:div])
