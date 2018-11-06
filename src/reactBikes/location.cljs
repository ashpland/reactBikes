(ns reactBikes.location
  (:require [reactBikes.state :as state]))

; Equirectangular approximation of distance
; https://www.movable-type.co.uk/scripts/latlong.html#equirectangular
; φ = lat radians
; λ = lon radians

; var x = (λ2-λ1) * Math.cos((φ1+φ2)/2);
; var y = (φ2-φ1);
; var d = Math.sqrt(x*x + y*y) * R;

(def radius 6371e3)

(defn rad [deg] (* deg (/ Math/PI 180)))

(defn pointInRadians
  [degreesPoint]
  {:φ (rad (:lat degreesPoint))
   :λ (rad (:lon degreesPoint))})

(defn splitPoints
  [point1 point2]
  (let [rad1 (pointInRadians point1) rad2 (pointInRadians point2)]
    {:φ1 (:φ rad1)
     :λ1 (:λ rad1)
     :φ2 (:φ rad2)
     :λ2 (:λ rad2)}))

(defn equirectangularDistance
  [{:keys [φ1 λ1 φ2 λ2]}]
  (let [x (* (- λ2 λ1) (Math/cos (/ (+ φ1 φ2) 2)))
        y (- φ2 φ1)]
    (* (Math/sqrt (+ (* x x) (* y y))) radius)))

(defn distance
  [point1 point2]
  (equirectangularDistance (splitPoints point1 point2)))
