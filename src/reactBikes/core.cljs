(ns reactBikes.core
  (:require [reagent.core :as r]
            [reactBikes.components.header :refer [header]]
            [reactBikes.components.station :as station]
            [reactBikes.state :as state]))

(defn newFoot
  []
  [:div "Hey"])

(defn app
  []
  [:div.container
   [header]
   (station/displayAll (vals @state/stations))
   [newFoot]])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))
