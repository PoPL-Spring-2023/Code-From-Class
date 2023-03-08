(ns clojure-from-class.march8)

(def todo
  "
Midterm Exams Wed, Thurs, Fri
if you have an exam scheduled today and want to reschedule 
   for a Thurs or Fri slot, I'd appreciate it!

Work on term projects! Programming examples due 4/10

Reading:  None

HW 5 will be released Fri., due Fri after spring break
")

(def nums (range 4 12))


;;; Let's pick up where we left off, using map

;; someone remind us what the map function does
(map count
       '("this" "list" "of" "strings"))

;; let's write a function that tests whether a list of words
;; is sorted by length

(defn sorted-by-length?
  [words]
  (apply < (map count words)))

;; If you have a list of maps, you can get the values associated
;; with a key in each map using the map function:
(def people '({:name "Kelly" :age 22}
              {:name "Allen" :age 19}
              {:name "Steve" :age 50}))

(map #(get % :name) people)
;; => ("Kelly" "Allen" "Steve")
  
;; this is the same:
(map :name people)
;; => ("Kelly" "Allen" "Steve")
;; why does this work??
;; you'll see this commonly in Clojure code

(:name {:name "Ryan", :age 20})

;;;;;;;;
;; Let's look at a new higher-order function: filter
;; filter takes a predicate (a function that returns true
;; or false), and a collection, and returns a sequence of
;; the items in the collection that make the predicate return true

nums
;; => (4 5 6 7 8 9 10 11)

(filter even? nums)
;; => (4 6 8 10)

(even? 7) ;; built-in function
;; => false

;; what will this do?
(filter (fn [x] (> x 8)) nums)
;; => (9 10 11)

;; How would we take a list of words and return those
;; whose length is > 5?
(filter (fn [x] (> (count x) 5))
        '("only" "the" "longest" "words" "will" "survive"))
;; => ("longest" "survive")

;; same thing, but with #() syntax:
(filter #(> (count %) 5)
        '("only" "the" "longest" "words" "will" "survive"))
;; => ("longest" "survive")

;; questions?
;; usually you use #(...) for very short anon fns, and (fn []...)
;; for longer or multi-line anon fns

;;;;;;
;; reduce: another higher-order function
;; reduce interposes fn calls between elements of a list

(reduce + nums)
;; => 60

nums
;; => (4 5 6 7 8 9 10 11)

;; this is equivalent to:
(+ ... (+ (+ (+ (+ 4 5) 6) 7) 8) ... 11)

;; apply:
(apply + nums) ;; you'd just use this
;; => 60

;; this is equivalent to:
(+ 4 5 6 7 8 9 10 11)

;; can provide an optional "left" argument:
(reduce + 100 nums)
;; => 160

;; this is equivalent to:
(+ ... (+ (+ (+ (+ (+ 100 4) 5) 6) 7) 8) ... 11)

;; more examples:
(reduce (fn [x y]
          (str x ", " y))
        nums)
;; => "4, 5, 6, 7, 8, 9, 10, 11"

;; equivalent to:
(str (str (str 4 ", " 5) ", " 6) ", " 7) ;; etc.
;; => "4, 5, 6, 7"

;; can't do this with apply, but turns out there's another
;; useful clojure function that does this without reduce:
(interpose ", " nums)
;; => (4 ", " 5 ", " 6 ", " 7 ", " 8 ", " 9 ", " 10 ", " 11)

;; that's not quite what we want, but we can apply str to it:
(apply str (interpose ", " nums))
;; => "4, 5, 6, 7, 8, 9, 10, 11"

;; => "clojure.lang.LazySeq@afb2046f" ;; more on this later
(str '(4 ", " 5 ", " 6))
;; => "(4 \", \" 5 \", \" 6)"

;; interpose puts its first argument between every pair of
;; elements in its second argument

(interpose 7 '(1 2 3 4))
;; => (1 7 2 7 3 7 4)

; what will this do?
(reduce conj '() nums)
;; => (11 10 9 8 7 6 5 4)

;; equivalent to
(conj (conj (conj '() 4) 5) 6) ;; etc.
;; => (6 5 4)


;; first, what does conj do?
(conj '(1 2 3) 5)
;; => (5 1 2 3)

;; of course, Clojure has a reverse function:
(reverse nums)
;; => (11 10 9 8 7 6 5 4)

;; what will this do?
(reduce list nums)
;; => (((((((4 5) 6) 7) 8) 9) 10) 11)

;; remember, equivalent to:
(list (list (list 4 5) 6) 7) ; etc.

(reduce list 10000 nums)
;; => ((((((((10000 4) 5) 6) 7) 8) 9) 10) 11)

(reduce list '(1000 1001 1002) nums)
;; => (((((((((1000 1001 1002) 4) 5) 6) 7) 8) 9) 10) 11)

; Let's say that we have a list, and want to know
; how often each element appears in the list, by
; creating a map of element/count pairs

(def letters '(:a :b :c :a :a :b :a :b :a :a :a :a :b :d :c :a :a :b))

;; how can we use reduce here?

(defn inc-count
  "Given a map of counts and a key, increments the count associated
   with key if it is already in the map, or adds the key with a
   count of 1 if it is not."
  [count-map key]
  ;; we could use an if statement! but this is simpler:
  ;; what is the third arg to get?
  (assoc count-map
         key
         (inc (get count-map key 0))))

;; BTW, Clojure's error messages are HORRIBLE

(inc-count {:a 4 :b 2} :t)
;; => {:a 4, :b 2, :t 1}


(inc-count {:a 4 :b 2} :a)
;; => {:a 5, :b 2}



(:t {:a 4 :b 2})
;; => nil

(inc (:t {:a 4 :b 2}))
;; => Execution error (NullPointerException) at clojure-from-class.march8/eval7991 (REPL:189).
;;    null


(reduce inc-count {} letters)
;; => {:a 10, :b 5, :c 2, :d 1}

;; reductions does reduce, but instead of just giving
;; you the end result, gives a list of every partial
;; result along the way:

(reductions conj '() nums)
;; => (() (4) (5 4) (6 5 4) (7 6 5 4) (8 7 6 5 4) (9 8 7 6 5 4) (10 9 8 7 6 5 4) (11 10 9 8 7 6 5 4))

(reductions + nums)
;; => (4 9 15 22 30 39 49 60)


(reductions inc-count {} letters)
;; => ({}
;;     {:a 1}
;;     {:a 1, :b 1}
;;     {:a 1, :b 1, :c 1}
;;     {:a 2, :b 1, :c 1}
;;     {:a 3, :b 1, :c 1}
;;     {:a 3, :b 2, :c 1}
;;     {:a 4, :b 2, :c 1}
;;     {:a 4, :b 3, :c 1}
;;     {:a 5, :b 3, :c 1}
;;     {:a 6, :b 3, :c 1}
;;     {:a 7, :b 3, :c 1}
;;     {:a 8, :b 3, :c 1}
;;     {:a 8, :b 4, :c 1}
;;     {:a 8, :b 4, :c 1, :d 1}
;;     {:a 8, :b 4, :c 2, :d 1}
;;     {:a 9, :b 4, :c 2, :d 1}
;;     {:a 10, :b 4, :c 2, :d 1}
;;     {:a 10, :b 5, :c 2, :d 1})

;; it's complicated but efficient

;; BTW, it turns out there's another way to do this:
(frequencies letters)
;; => {:a 10, :b 5, :c 2, :d 1}

;; clojure includes a lot of useful built-in functions!
;; you should use the Clojure Cheatsheet to find them:
;; https://clojure.org/api/cheatsheet


;; let's write a function that finds all prime numbers
;; less than some upper bound

;; first, a prime? function

(defn prime?
  "Returns true if x is prime, false otherwise"
  [x]
  (empty?
   (filter (fn [divisor] (zero? (mod x divisor)))
           (range 2 x))))

;; % is only used as the parameter to a #( ... ) anon function

(range 2 6)
;; => (2 3 4 5)

(prime? 60)
;; => false

(prime? 7)
;; => true

(prime? 2999)
;; => true


;; we're out of time! please fill out exit questions!

;; See you for exams!

;; (that was the quietest class of my life)


;; If you have an exam today and can't reschedule, that's fine!




(comment
  
  nums

  (sorted-by-length? '("short" "longer" "longest"))
  ;; => true

  (sorted-by-length? '("elephant" "cat" "puppy"))
  ;; => false


  )