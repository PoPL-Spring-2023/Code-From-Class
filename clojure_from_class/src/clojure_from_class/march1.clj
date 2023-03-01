(ns clojure-from-class.march1)

; cond: takes multiple condition/what to do pairs: 
(defn how-big
  "Tells how big a number is"
  [num]
  (cond
    (<= num 0) "num is negative"
    (< num 10) "Single digit"
    (< num 100) "Double digit"
    :else (str num " IS A BIG NUMBER!!!")))

;; ALL values in Clojure are truthy except for nil and false


;; defn is just shorthand for (def name (fn ...))
;; (fn ...) is an anonymous function
(def cube
  (fn [x]
    (* x x x)))




(comment

  (if (< 1 4)
    (str 1 " is the smallest")
    (str 4 " is the smallest"))

  ; when: just does the "then" part of if, if condition is
  ; false, returns nil
  (when true
    (println "yay"))
  ;; => nil

  (when false
    (println "boo"))
  ;; => nil

  (how-big 5)
  ;; => "Single digit"

  (how-big 245)
  ;; => "245 IS A BIG NUMBER!!!"

  (cube 6)
  ;; => 216

  (let [local-cube (fn [x] (* x x x))]
    (local-cube 3))
  ;; => 27

  (local-cube 3)
  ;; => Syntax error compiling at (/Users/thelmuth/Documents/cs220-popl/code-from-class/clojure_from_class/src/clojure_from_class/march1.clj:54:3).
  ;;    Unable to resolve symbol: local-cube in this context

  ;; maps: like Hashes in Ruby
  {} ;; empty map
  ;; => {}

  {:apples 4
   :bananas 12
   :carrots 3}
  ;; => {:apples 4, :bananas 12, :carrots 3}

  (def room-colors {:dining-room :taupe
                    :kitchen :mauve
                    :living-room :mint
                    :bedroom :lavendar})

  room-colors
  ;; => {:dining-room :taupe, :kitchen :mauve, :living-room :mint, :bedroom :lavendar}

  ;; add a key-value pair using assoc
  ;; returns a new map
  (assoc room-colors :bathroom :cerulean)
  ;; => {:dining-room :taupe, :kitchen :mauve, :living-room :mint, :bedroom :lavendar, :bathroom :cerulean}

  room-colors
  ;; => {:dining-room :taupe, :kitchen :mauve, :living-room :mint, :bedroom :lavendar}

  ; get - retrieves a value
  (get room-colors :kitchen)
  ;; => :mauve

  (get room-colors :den)
  ;; => nil

  ;; returns default value if key is not present
  (get room-colors :den :blue)
  ;; => :blue

  (def new-room-colors (assoc room-colors :bathroom :cerulean))

  new-room-colors
  ;; => {:dining-room :taupe, :kitchen :mauve, :living-room :mint, :bedroom :lavendar, :bathroom :cerulean}

  (keys room-colors)
  ;; => (:dining-room :kitchen :living-room :bedroom)

  (vals room-colors)
  ;; => (:taupe :mauve :mint :lavendar)

  ;; we can use maps or keywords as functions
  (room-colors :kitchen) ;; same as (get room-colors :kitchen)
  ;; => :mauve

  (:kitchen room-colors) ;; same thing
  ;; => :mauve


  ;; Higher-order functions
  ;; Functions that take functions as arguments OR
  ;; return functions
  ;; REALLY important in Clojure

  (def numbers (range 4 12))

  (range 4 12)
  ;; => (4 5 6 7 8 9 10 11)

  (range 10)
  ;; => (0 1 2 3 4 5 6 7 8 9)

  numbers
  ;; => (4 5 6 7 8 9 10 11)

  ;;; Apply
  ;;; apply a function to a sequence as its arguments
  (+ numbers)
  ;; => Execution error (ClassCastException) at java.lang.Class/cast (Class.java:3369).
  ;;    Cannot cast clojure.lang.LongRange to java.lang.Number

  (apply + numbers)
  ;; => 60

  (+ 4 5 6 7 8 9 10 11)
  ;; => 60

  (str numbers)
  ;; => "(4 5 6 7 8 9 10 11)"

  (apply str numbers)
  ;; => "4567891011"

  ;; max takes any number of args and returns the largest of them
  (max numbers)
  ;; => (4 5 6 7 8 9 10 11)

  (apply max numbers)
  ;; => 11

  (max "asd" "bbb")
  ;; => Execution error (ClassCastException) at clojure-from-class.march1/eval7805 (REPL:154).
  ;;    java.lang.String cannot be cast to java.lang.Number


  ;;; map - applies a function to every element of a list and returns a new list
  (inc 5)
  ;; => 6

  (map inc numbers)
  ;; => (5 6 7 8 9 10 11 12)

  (apply inc numbers)
  ;; => Execution error (ArityException) at clojure-from-class.march1/eval7811 (REPL:166).
  ;;    Wrong number of args (8) passed to: clojure.core/inc

  (cube 6)

  (map cube numbers)
  ;; => (64 125 216 343 512 729 1000 1331)

  ; can use anonymous functions
  (map (fn [x] (* x 5))
       numbers)
  ;; => (20 25 30 35 40 45 50 55)

  ;; here's a shorthand for anonymous functions in clojure:
  ;; % is the parameter to this anon fn
  (map #(* % 5)
       numbers)
  ;; => (20 25 30 35 40 45 50 55)


  (map #(* %1 %2)
       numbers
       '(9 0 3 1 100 1000 3 -1))
  ;; => (36 0 18 7 800 9000 30 -11)

  (map #(* %1 %2)
       numbers
       (range 100))
  ;; => (0 5 12 21 32 45 60 77)

  (map count
       '("this" "list" "of" "strings"))
  ;; => (4 4 2 7)

  (count '("this" "list" "of" "strings"))
  ;; => 4









  )
