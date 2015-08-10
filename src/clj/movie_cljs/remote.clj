(ns movie-cljs.remotes
  (:require [shoreleave.middleware.rpc :refer [defremote]]))

(defremote calculate [quantity price tax discount]
  (-> (* quantity price)
      (* (+ 1 (/ tax 100)))
      (- discount)))