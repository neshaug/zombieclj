(ns zombieclj.web
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [resources]]
            [org.httpkit.server :refer [run-server]]))

(defn index [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello zombies via compojure!"})

(defroutes app
  (resources "/")
  (GET "/" [] index))

(defn -main [& args]
  (run-server app {:port 8666})
  (println "Started server"))
