(ns clojure-from-class.april5-7-10)


;;;; What is a symbol?
; Just a data type like everything else!
; Something special happens when you evaluate one
; When you evaluate a symbol, Clojure simply looks up the most
; recent binding for it, and returns that instead

;; keyword
:horse

;; symbol
'horse

(type 'horse)
;; => clojure.lang.Symbol

(def horse "Albert")
;; => #'clojure-from-class.repl/horse

horse
;; => "Albert"

'horse
;; => horse

(list 'horse 'penguin 'elephant)
;; => (horse penguin elephant)

(let [horse "Nancy"]
  horse)
;; => "Nancy"

(type horse)
;; => java.lang.String


;;;;;;;;;
;; Higher-order functions
;; second type: function that returns a function

(defn sq
  [x]
  (* x x))

(defn cb
  [x]
  (* x x x))

(defn powerer
  "Takes an exponent and returns a function that raises its argument
   to that exponent."
  [exponent]
  ;; since body is anon fn, it is what is returned.
  (fn [argument]
    (apply * (repeat exponent argument))))

(def cube (powerer 3))

(cube 5)
;; => 125

(def to-the-tenth (powerer 10))

(to-the-tenth 2)
;; => 1024

((powerer 5) 3)
;; => 243

;;; the anon fn that gets returned is called a *closure*
;;; closure - a function with an environment, which gives each free
;;; variable a value at the time the function is created
;;; The free variable in this example is exponent


(defn concat-string-with
  "Returns a function that takes a string and concats
   it onto start-string."
  [start-string]
  (fn [s]
    (str start-string s)))

(def say-hello (concat-string-with "hello "))

(say-hello "Susan")
;; => "hello Susan"

(say-hello "Billy")
;; => "hello Billy"

(def t-minus (concat-string-with "T-minus "))

(t-minus 10)
;; => "T-minus 10"


(map t-minus (range 10 -1 -1))
;; => ("T-minus 10"
;;     "T-minus 9"
;;     "T-minus 8"
;;     "T-minus 7"
;;     "T-minus 6"
;;     "T-minus 5"
;;     "T-minus 4"
;;     "T-minus 3"
;;     "T-minus 2"
;;     "T-minus 1"
;;     "T-minus 0")


(defn too-late
  [& args]
  args)

(too-late 5)
;; => (5)


(too-late 1 2 3 4 5)
;; => (1 2 3 4 5)

(too-late "hi" 5 "there" :aa true)
;; => ("hi" 5 "there" :aa true)
