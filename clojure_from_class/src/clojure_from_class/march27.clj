(ns clojure-from-class.march27)

;; RECALL: Recursion
(defn my-count
  "Count the number of elements in a list"
  [lst]
  (if (empty? lst)
    0
    (inc (my-count (rest lst)))))

(defn first-positive-in-list
  "Takes a list of numbers, and returns the first positive number
   in that list.
   If list contains no positive numbers, return nil."
  [numbers]
  (cond
    (empty? numbers) nil
    (< (first numbers) 1) (first-positive-in-list (rest numbers))
    :else (first numbers)))

(first-positive-in-list '(-3 -7 -1 -8 0 -3 16 -32))
;; => 16

(first-positive-in-list '(-5 -2))
;; => nil

(first-positive-in-list (range -100000 5))
;; => Execution error (StackOverflowError) at clojure-from-class.march27/first-positive-in-list (REPL:18).
;;    null

(first-positive-in-list (range -10 5))
;; => 1





(first '())
;; => nil

(< nil 1)
;; => Execution error (NullPointerException) at clojure-from-class.march27/eval8173 (REPL:28).
;;    null












;; RECALL: reduce
;; what does this do:
(reduce #(+ %1 (count %2))
        0
        '("Francisco" "and" "Charlene" "ate" "pizza."))
;; => 29

;(reduce f '(1 2 3 4 5)) => (f (f (f (f 1 2) 3) 4) 5)

;(reduce f 0 '(1 2 3 4 5)) => (f (f (f (f (f 0 1) 2) 3) 4) 5)

(reduce str 0 '())
;; => 0

(reduce str '())
;; => ""

(reduce #(+ %1 %2) '(1 2))
;; => 3

;; => Execution error (ArityException) at clojure-from-class.march27/eval8206 (REPL:73).
;;    Wrong number of args (0) passed to: clojure-from-class.march27/eval8206/fn--8207


;; write our own reduce function

(defn my-reduce
  "Mimics behavior of reduce
   This will be a multi-arity function - can take 2 or 3 params"
  ([function coll]
   (my-reduce function (first coll) (rest coll)))
  ([function start-val coll]
   (if (empty? coll)
     start-val
     (my-reduce function
                (function start-val (first coll))
                (rest coll)))))

(my-reduce #(+ %1 (count %2))
           0
           '("Francisco" "and" "Charlene" "ate" "pizza."))
;; => 29

(my-reduce + (range 10))
;; => 45

(my-reduce list '() '(3 4 5 6 7))
;; => (((((() 3) 4) 5) 6) 7)


;; Tail recursion
;; recur - allows us to recursively call a function without
;; creating many calls on the call stack at once.
;;
;; With recur, you CAN'T do anything with the result of
;; the recursive call -- it must just be returned itself.


(defn tail-first-positive-in-list
  "Takes a list of numbers, and returns the first positive number
   in that list.
   If list contains no positive numbers, return nil."
  [numbers]
  (cond
    (empty? numbers) nil
    (< (first numbers) 1) (recur (rest numbers))
    :else (first numbers)))

(tail-first-positive-in-list '(-3 -5 7 -2 1))
;; => 7

(tail-first-positive-in-list (range -100000 5))
;; => 1

;; loop
;; loop sets the recursion point for recur and declares
;; parameters with their initial values
;; NOTE: This is not a for/while/etc. loop. It is recursion

(defn my-tail-count
  "Count the number of elements in a list"
  [in-lst]
  (loop [lst in-lst ;; lst is the list so far
         c 0]       ;; c is the count of the number of elements we've seen
    (if (empty? lst)
      c
      (recur (rest lst)
             (inc c)))))

(my-tail-count '(4 5 6 7))
;; => 4

;; => 4

(my-tail-count (range 1000000))
;; => 1000000
