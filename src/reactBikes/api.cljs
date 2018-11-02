(ns reactBikes.api)

(def testJSON "{\"name\":\"0001 10th & Cambie\",\"coordinates\":\"49.262487, -123.114397\",\"total_slots\":52,\"free_slots\":32,\"avl_bikes\":20,\"operative\":true,\"style\":\"\"}")

(defn convertJSON
  []
  [:div.test (get (js->clj (.parse js/JSON testJSON)) "name")])
