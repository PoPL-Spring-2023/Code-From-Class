(ns clojure-from-class.lab5)

; A perfect number is a number whose factors (numbers it is divisible by) add up
; to the number itself. 6 is the first perfect number, since its factors are
; 1, 2, and 3, and 1+2+3=6. Write a function that tells whether a number is perfect
; or not. Use it to find all perfect numbers less than 1000 (there are only 3 of them!).

(defn factors
  "Finds all factors of n, returns them as a list."
  [n]
  (filter #(zero? (mod n %))
          (range 1 n)))

(defn perfect?
  "Returns whether n is a perfect number or not."
  [n]
  (= (apply + (factors n))
     n))

(comment
  (filter perfect? (range 1 1000))
  ;; => (6 28 496)
  )


; The factorial of an integer n is 1 if n <= 1, or n * factorial (n - 1)'
; otherwise. Write a recursive factorial function. Make sure (factorial 100) works!

(defn factorial
  [n]
  (loop [n n
         answer 1]
    (if (<= n 1)
      answer
      (recur (dec n)
             (*' answer n)))))

(comment
  (map factorial (range 1 10))
  ;; => (1 2 6 24 120 720 5040 40320 362880)

  (factorial 100)
  ;; => 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000N
  )

; Write a factorial function that doesn't use recursion. Hint: use list processing
; functions, and think about what factorial does.

(defn factorial-no-recursion
  [n]
  (apply *' (range 1 (inc n))))

(comment
  (map factorial-no-recursion (range 1 10))
  ;; => (1 2 6 24 120 720 5040 40320 362880)

  (factorial-no-recursion 100)
  ;; => 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000N

  (= (factorial-no-recursion 72)
     (factorial 72))
  ;; => true

  )

; Implement your own version of the filter function using recursion. It's fine
; if it has stack overflow errors for really long lists at first, but then try
; to make it tail recursive!

(defn my-filter
  [predicate coll]
  (loop [coll coll
         result '()]
    (cond
      (empty? coll) (reverse result)
      (predicate (first coll)) (recur (rest coll)
                                      (conj result (first coll)))
      :else (recur (rest coll)
                   result))))

(comment
  (my-filter even? (range 20))
  ;; => (0 2 4 6 8 10 12 14 16 18)

  (my-filter #(= \a (first %))
             '("an" "elephant" "ate" "nine" "apples"))
  ;; => ("an" "ate" "apples")
  )

; Use reduce and > to write a function that finds the max element of a list
; (without using the max function).

(defn max-element
  [coll]
  (reduce #(if (> %1 %2)
             %1
             %2)
          coll))

(comment
  (max-element '(37 92 76 12 84 97 31 16 32))
  ;; => 97

  )
