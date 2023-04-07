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


