(ns reactBikes.core
  (:require [reagent.core :as r]
            [reactBikes.api :refer [getFromNetwork]]
            [reactBikes.location :refer [testLocationContainer]]
            [reactBikes.station :refer [allStations]]))

(defn header [] [:header [:h1 "ReactBikes"]])
(defn footer [] [:div "Footer"])

(defn app
  []
  (getFromNetwork)
  [:div.container
   [header]
   [testLocationContainer]
   [allStations]
   [footer]])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))
