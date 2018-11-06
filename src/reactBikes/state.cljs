(ns reactBikes.state
  (:require [reagent.core :as r]))

(def stations (r/atom {}))

(def location (r/atom {:lat 49.262487 :lon -123.114397}))

; {"name":"0001 10th & Cambie","coordinates":"49.262487, -123.114397","total_slots":52,"free_slots":32,"avl_bikes":20,"operative":true,"style":""}
