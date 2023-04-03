(ns clojure-from-class.april3)

;; read-string - takes a string, returns the corresponding
;; data structure

(read-string "(+ 2 3)")
;; => (+ 2 3)


(type (read-string "(+ 2 3)"))
;; => clojure.lang.PersistentList

(conj (read-string "(+ 2 3)") 7)
;; => (7 + 2 3)
 
;;; symbols:
'+
;; => +

'hello
;; => hello

;;; keyword
:hello
;; => :hello

(read-string "[3 4 5]")
;; => [3 4 5]

(read-string "(quote (2 3 4))")
;; => '(2 3 4)

(read-string "'(2 3 4)")
;; => '(2 3 4)

(read-string "(2 3 4)")
;; => (2 3 4)

;;; This is a reader macro -- turns (quote ...) into '

(read-string "#(+ % %)")
;; => (fn* [p1__8525#] (+ p1__8525# p1__8525#))

(read-string "#(+ %1 %2)")
;; => (fn* [p1__8528# p2__8529#] (+ p1__8528# p2__8529#))

(read-string "(+ 1 2) ; this is a comment")
;; => (+ 1 2)

(read-string "variable")
;; => variable
;;;;; this is a symble that was returned

;; eval:

(eval 5)
;; => 5

(eval [5 (+ 2 3) 9])
;; => [5 5 9]

(let [x 45]
  (eval x))
;; => 45

(+ 2 3)
;; => 5

'(+ 2 3)
;; => (+ 2 3)

(eval '(+ 2 3))
;; => 5

(conj '(2 3) '+)
;; => (+ 2 3)

(eval (conj '(2 3) '+))
;; => 5

;;; Write our own REPL

(comment
  (read-line)
  )
;; => "hi there"

(defn repl
  "A Clojure REPL."
  []
  (print "H]=> ")
  (flush)
  (let [line (read-line)]
    (when (not (empty? line)) ;; terminate when user enters blank line
      (println (eval (read-string line))) ; eval and print
      (recur))))

(defn main
  [& args]
  (repl))

(comment
  (main)
  )