(defproject movie-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: adding movie poster"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  ;; CLJ AND CLJS source code path
  :source-paths ["src/clj" "src/cljs" "src/brepl"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                [org.clojure/clojurescript "0.0-2069"]
                [compojure "1.1.6"]
                [domina "1.0.3"]
                [hiccups "0.2.0"]
                [org.clojars.magomimmo/shoreleave-remote-ring "0.3.1-SNAPSHOT"]
                [org.clojars.magomimmo/shoreleave-remote "0.3.1-SNAPSHOT"]]

  ;; lein-cljsbuild plugin to build a CLJS project
  :plugins [[lein-cljsbuild "1.0.0"]
            [lein-ring "0.8.8"]]

  :ring {:handler movie-cljs.core/handler}
  ;; cljsbuild options configuration
  :cljsbuild {:builds
              {:dev
               {;; clojurescript source code path
                :source-paths ["src/cljs"]

                ;; Google Closure Compiler options
                :compiler {;; the name of emitted JS script file
                           :output-to "resources/public/js/movie_dbg.js"

                           ;; minimum optimization
                           :optimizations :whitespace

                           ;; prettyfying emitted JS
                           :pretty-print true}}
               :prod
               {;; clojurescript source code path
                :source-paths ["src/cljs"]

                ;; Google Closure Compiler options
                :compiler {;; the name of emitted JS script file
                           :output-to "resources/public/js/movie.js"

                           ;; advanced optimization
                           :optimizations :advanced

                           ;; no need prettyfication
                           :pretty-print false}}
               :pre-prod
               {;; clojurescript source code path
                :source-paths ["src/cljs"]
                :compiler {;; different output name
                           :output-to "resources/public/js/movie_pre.js"

                           ;; simple optmization
                           :optimizations :simple

                           ;; no need prettyfication
                           :pretty-print false}}}})