(ns movie-cljs.core
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

;; defroutes macro defines a function that chains individual route
;; functions together. The request map is passed to each function in
;; turn, until a non-nil response is returned.
(defroutes app-routes
  ; to serve document root address
  (GET "/" [] "<a href='/index.html'><h2>Link to Movie API</h2></a>")
  ; to serve static pages saved in resources/public directory
  (route/resources "/")
  ; if page is not found
  (route/not-found "Page not found"))

;; site function creates a handler suitable for a standard website,
;; adding a bunch of standard ring middleware to app-route:
(def handler
  (handler/site app-routes))