(ns reactBikes.state
  (:require [reagent.core :as r]))

(def stations (r/atom {:0001 {:id :0001
                              :stationName "First Station"
                              :coordinates {:lat 0.0 :lon 0.0}
                              :availableDocks 3
                              :availableBikes 7}
                       :0002 {:id :0002
                              :stationName "Second Station"
                              :coordinates {:lat 0.0 :lon 0.0}
                              :availableDocks 15
                              :availableBikes 1}
                       :0003 {:id :0003
                              :stationName "Third Station"
                              :coordinates {:lat 0.0 :lon 0.0}
                              :availableDocks 9
                              :availableBikes 11}}))

; {"name":"0001 10th & Cambie","coordinates":"49.262487, -123.114397","total_slots":52,"free_slots":32,"avl_bikes":20,"operative":true,"style":""}
