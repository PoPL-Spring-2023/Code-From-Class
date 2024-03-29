(ns clojure-from-class.repl)

;; We want to write this REPL without using eval
;; eval does 2 primary things:
;;  1. Evaluates the data structure/code and returns the result.
;;  2. May define global variables or functions. This results in side effects
;;     that go beyond the place they are used.
;;
;; We will call the storage of bindings to values the *environment*

;; In our eval, we will track the environment in a functional, immutable style
;; We want no side effects on the actual Clojure global environment

;; Instead, we will store a map containing the environment of symbols and
;; their bindings.

;; my-eval is going to need to return 2 things:
;; 1. The result of evaluating the expression
;; 2. The new environment with any changes to bindings

;; our return will be a "state" that looks like this:
{:environment {'x 5
               'length 27.2
               'numbers '(4 8 12)
               'square (fn [x] (* x x))
               'horse "Albert"}
 :return 43}

; We will implement:
; 1. creating my-eval and calling it in repl
; 2. integer literals
; 3. +
; 4. nested calls to +
; 5. def
; 6. defed symbols


(defn my-eval
  "Evaluates expression, changes environment, and returns resulting state
   with :return set to returned value.
    - state should be a map with a :environment key that stores all bindings,
      and a :return key that stores the result of evaluation
    - expression is the Clojure expression given to the REPL"
  [state expression]
  (if (not (seq? expression))
    ; THEN: Not a function call
    (if (symbol? expression)
      (assoc state :return (get (:environment state) expression)) ; fetch binding of symbol
      (assoc state :return expression)) ; return value of a literal

    ; ELSE: A function call
    (let [f (first expression)
          args (rest expression)]
      (cond
        (= f '+) (assoc state :return (apply + (map #(:return (my-eval state %))
                                                    args)))
        (= f 'def) {:environment (assoc (:environment state)
                                        (first args)
                                        (:return (my-eval state (second args))))
                    :return (first args)}
        :else (assoc state :return "Error: That function isn't defined.")))))

(defn repl
  "A Clojure REPL." 
  ;; If called with no args, make a new state and call self
  ([] (repl {:environment {}
              :return nil}))
  ([state]
   (print "H]=> ")
   (flush)
   (let [line (read-line)]
     (when (not (empty? line))
       (let [new-state (my-eval state (read-string line))]
         (println "Environment:" (:environment new-state))
         (println (:return new-state))
         (recur new-state)))))) ;; recursively pass new state to repl

(defn main
  [& args]
  (repl))

(comment
  (main)


  )