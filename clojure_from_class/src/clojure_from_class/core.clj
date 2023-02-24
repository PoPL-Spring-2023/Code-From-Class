(ns clojure-from-class.core)






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
  ;; => "clojure.core$_PLUS_@7a99dd9623"
  
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


  





  )