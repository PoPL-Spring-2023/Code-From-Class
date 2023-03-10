(ns clojure-from-class.march10)

" ---- TO DO ----
Work on term projects! Programming examples due 4/10
 
Reading:  CB&T: Finish Ch. 4 (Lazy Seqs to end)
    A Vampire Data Analysis Program for the FWPD is optional

HW 5 released (later) today, due Monday a week after spring break ends
     So, if you don't want to work on it over break, don't!
"

;; let's write a function that finds all prime numbers
;; less than some upper bound

;; first, a prime? function:

(defn prime?
  "Returns true if x is prime, false otherwise"
  [x]
  (if (<= x 1)
    false ;; this is returned if condition is true
    (empty?
     (filter (fn [divisor] (zero? (mod x divisor)))
             (range 2 x)))))

(prime? 72)
;; => false

(prime? 101)
;; => true

(defn primes
  "Returns a list of all primes < upper-bound"
  [upper-bound]
  (filter prime? (range upper-bound)))

(primes 20)
;; => (2 3 5 7 11 13 17 19)


;;;;;;;;;;
;; Recursion:
;; A function that calls itself
;; Need: - Base case: default, or stop case that stops recursion
;;       - Recursive call: call to the function itself. Changes parameter slightly to move toward base case

(defn my-count
  "Count the number of elements in a list"
  [lst]
  (if (empty? lst)
    0 ;; base case
    (inc (my-count (rest lst))))) ;; recursive case

(my-count '(4 5 6 7 8 9 10))
;; => 7

(my-count (range 35))
;; => 35

(my-count (range 100000))
;; => Execution error (StackOverflowError) at clojure-from-class.march10/my-count (REPL:53).
;;    null

(defn fib
  "Gives the nth Fibonacci number"
  [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (fib (dec n))
             (fib (- n 2)))))

(fib 5)
;; => 5

(map fib (range 20))
;; => (0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181)

(fib 50)

;;; making 2^50 recursive calls


;; write our own reduce function

(defn my-reduce
  "Mimics behavior of reduce
   This will be a multi-arity function - can take 2 or 3 params"
  ([function coll]
   (my-reduce function (first coll) (rest coll)))
  ([function start-val coll]
   
   )
  )



