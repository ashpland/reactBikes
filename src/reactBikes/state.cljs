(ns reactBikes.state
  (:require [reagent.core :as r]))

(def stations (r/atom {:station-1 {:id :station-1
                                   :stationName "First Station"}
                       :station-2 {:id :station-2
                                   :stationName "Second Station"}
                       :station-3 {:id :station-3
                                   :stationName "Third Station"}}))
