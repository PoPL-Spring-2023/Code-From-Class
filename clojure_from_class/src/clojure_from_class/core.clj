(ns clojure-from-class.core
  (:require clojure.repl))






(comment

  (+ 2 3)
  ;; => 5
  
  (* 1 2 3 4 5)
  ;; => 120
  
  (+ (* 2 3) (- 9 4))
  ;; => 11
  
  ; the same as:
  (+ 6 5)
  ;; => 11
  
  ;;;;;;;;;;; 2/24/23
  
  ; arithmetic and numbers
  
  (* 4)
  ;; => 4
  
  (/ 4)
  ;; => 1/4
  
  (/ 6 27)
  ;; => 2/9
  
  (+ 3 7.31)
  ;; => 10.309999999999999
  
  ;; + can take ints, or floats, or ratios -- ad-hoc polymorphism
  
;;   (+ "hi" "there")
  ;; => Execution error (ClassCastException) at clojure-from-class.core/eval5544 (REPL:41).
  ;;    java.lang.String cannot be cast to java.lang.Number
  
  (+ 1 2 (* 9 3) 8 (/ 34 11))
  ;; => 452/11
  
  (+ 4)
  ;; => 4
  
  (- 4)
  ;; => -4
  
  (float 4)
  ;; => 4.0
  
  2999 ; int
  4.521 ; float
  5/27 ; ratio
  
  (type 5/27)
  ;; => clojure.lang.Ratio
  
  (type 5)
  ;; => java.lang.Long
  
  32478923473284732789432978
  ;; => 32478923473284732789432978N
  
  (type 32478923473284732789432978)
  ;; => clojure.lang.BigInt
  
  ; Comparisons
  (< 1 4)
  ;; => true
  
  (= 3 9)
  ;; => false
  
  (< 2 4 6 8 10)
  ;; => true
  
  ;; booleans
  true
  ;; => true
  
  false
  ;; => false
  
  nil
  ;; => nil
  
  ;; nil is not a boolean. nil represents "nothing"
  ;; nil evaluates to false in conditionals -- only thing besides false
  
  ;; keywords
  ;; like symbols in Ruby
  ;; always evaluate to themselves
  :kiwis
  ;; => :kiwis
  
  :avocados
  ;; => :avocados
  
  ;; strings
  ;; strings always use double quotes; can go on multiple lines
  "hello
world"
  ;; => "hello\nworld"
  
  ;; str converts all arguements to strings and concatenates them
  (str "Hello" "World")
  ;; => "HelloWorld"
  
  (str "hi" (+ 2 3))
  ;; => "hi5"
  
  (str "+" 2 3)
  ;; => "clojure.core$_PLUS_ @7a99dd9623"
  
  (str str)
  ;; => "clojure.core$str@709cf9f1"
  
  ;; printing
  (println "cat")
  ;; => nil
  
  (println "Why" "do" "you" "have" 5 "cats?")
  ;; => nil
  

  ;; Clojure: perspective: better to use a small number of common
  ;; data structures with many functions for each than to
  ;; define many classes with different methods
  
  ;; sequences: lists and vectors
  ;; lists
  ;; look a lot like a function call!
  
  '(1 2 3)
  ;; => (1 2 3)
  
  '(+ 2 3)
  ;; => (+ 2 3)
  
  '(1 (+ 2 3) 4)
  ;; => (1 (+ 2 3) 4)
  
  (nth '(1 (+ 2 3) 4) 1)
  ;; => (+ 2 3)
  
  ;; ' is shorthand for macro quote
  (quote (1 2 3))
  ;; => (1 2 3)
  
  (list 1 (+ 2 3) 4) ;; list evaluates arguments before making list
  ;; => (1 5 4)
  
  ;; vectors: faster for indexed access, slower in other ways
  ;;  are arrays under the hood
  
  [1 2 3]
  ;; => [1 2 3]
  
  (vector 1 2 3)
  ;; => [1 2 3]
  
  ;; we can mix datatypes in lists and vectors
  ;; ex: parametric polymorphism
  '(5 :cat "hi" [4 5 6] 3/5)
  ;; => (5 :cat "hi" [4 5 6] 3/5)
  
  ; Sequence functions:
  (first '(:a :b :c :d :e))
  ;; => :a
  
  (first [1 2 3])
  ;; => 1
  
  (rest '(:a :b :c :d :e))
  ;; => (:b :c :d :e)
  
  (count '(:a :b :c :d :e))
  ;; => 5
  
  (nth '(:a :b :c :d :e) 3)
  ;; => :d
  
  ;;; All parametric polymorphic
  
  (conj '(10 11 12) 4)
  ;; => (4 10 11 12)
  
  (conj [10 11 12] 4)
  ;; => [10 11 12 4]
  
  (concat '(1 2 3) '(:a :b :c))
  ;; => (1 2 3 :a :b :c)
  
  (concat [1 2 3] [:a :b :c])
  ;; => (1 2 3 :a :b :c)
  
  (vec (concat [1 2 3] [:a :b :c]))
  ;; => [1 2 3 :a :b :c]
  
  (concat [1 2 3] '(1 2 3))
  ;; => (1 2 3 1 2 3)
  

  ;; let: allows you to assign values to symbols within a lexical
  ;; context.
  ;; You should use let all the time
  ;; let only returns the last thing that happens in them
  (let [nums '(7 2 3 3 1)
        the-first (first nums)]
    (rest nums)
    (* the-first the-first))
  ;; => 49
  
  nums
  ;; => Syntax error compiling at (/Users/thelmuth/Documents/cs220-popl/code-from-class/clojure_from_class/src/clojure_from_class/core.clj:0:0).
  ;;    Unable to resolve symbol: nums in this context
  
  'dog ;; symbol
  ;; => dog
  
  :dog ;; keyword
  ;; => :dog
  
  (let [nums '(7 2 3 3 1)
        the-first (first nums)]
    (vector 5
            (let [answer (* the-first 100)]
              (+ answer 1000))))
 ;; => [5 1700]
  
  (let [nums '(7 2 3 3 1)
        another [:hi :there]
        third (conj nums 100)]
    (println nums)
    (println (conj nums 100))
    (println nums)
    (println another)
    (rest nums))
  ;; => (7 2 3 3 1)
  
  ;; create a global binding:
  ;; should ONLY be used to create global constants
  ;; should NEVER be used inside any other code
  (def more-nums '(1 2 3 4 5))

  more-nums
  ;; => (1 2 3 4 5)
  
  (let [nums (rest more-nums)]
    nums)
  ;; => (2 3 4 5)
  

  ;; defn
  ;; defines a function
  (defn square
    "Squares the input x; this is a docstring"
    [x] ;; the parameter list
    (* x x)) ;; the body
  
  (square 5)
  ;; => 25
  
  (square 3.6)
  ;; => 12.96
  
  (square (/ 2 3))
  ;; => 4/9
  
  (square "hi there")
  ;; => Execution error (ClassCastException) at clojure-from-class.core/square (REPL:265).
  ;;    java.lang.String cannot be cast to java.lang.Number
  
  (defn print-strings-and-concat
    "Like with let, defn can do multiple steps and then
     return the last thing evaluated. Only the last thing
     is returned."
    [string1 string2]
    (println string1)
    (println string2)
    (str string1 string2))

  (print-strings-and-concat "hello" "world")
  ;; => "helloworld"
  
  ; if: takes 3 arguments
  ; if the first is true, it returns the second arg
  ; if false, returns the third
  (if (< 1 4)
    (str 1 " is the smallest")
    (str 4 " is the smallest"))
  ;; => "1 is the smallest"
  
  (defn sphere-volume
    "Calculates the volume of a sphere"
    [radius]
    (if (<= radius 0)
      "You can't find the volume of a sphere with a negative radius"
      (let [r-cubed (* radius radius radius)
            volume (* 4/3 Math/PI r-cubed)]
        volume)))
  
  (sphere-volume 5)
  ;; => 523.5987755982987

  (sphere-volume -4)
  ;; => "You can't find the volume of a sphere with a negative radius"

   (defn sphere-volume-with-negative
     "Calculates the volume of a sphere"
     [radius] 
     (let [real-radius (if (<= radius 0)
                         (- radius)
                         radius)
           r-cubed (* real-radius real-radius real-radius)
           volume (* 4/3 Math/PI r-cubed)]
       volume))
  
  (sphere-volume-with-negative -4)
  ;; => 268.08257310632894

  (clojure.repl/doc sphere-volume-with-negative)


  )
