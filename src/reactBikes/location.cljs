(ns reactBikes.location
  (:require [reactBikes.state :as state]))

(defn distance 
  [pointA pointB]
  (Math/sqrt (+ (Math/pow (- (:lon pointB) (:lon pointA)) 2) 
                (Math/pow (- (:lat pointB) (:lat pointA)) 2))))






(defn testLocation
  []
  (distance {:lat 49.57 :lon -123.114397} (vals @state/location)))

(defn testLocation1 [] 1)

(defn testLocationContainer
  []
  [:div (str (testLocation) "hey")])
