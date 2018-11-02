(ns reactBikes.core
  (:require [reagent.core :as r]
            [reactBikes.components.station :refer [allStations]]))

(defn header [] [:header [:h1 "ReactBikes"]])

(defn footer [] [:div "Footer"])

(defn app
  []
  [:div.container
   [header]
   [allStations]
   [footer]])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))
