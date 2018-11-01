(ns reactBikes.core
  (:require [reagent.core :as r]))

(defn app
  []
  [:div.container "Hello reactBikes World"])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))
