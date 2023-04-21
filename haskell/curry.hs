
-- multThenAdd :: (Num a) => a -> a -> a -> a
multThenAdd :: (Num a) => a -> (a -> (a -> a))
multThenAdd x y z = (x * y) + z

-- Haskell uses _currying_ on all functions with more than 1 argument
-- currying - process in evaluating a function where a function with more
--            than one argument is broken into multiple function applications,
--            each with only 1 argument

multBy5ThenAdd y z = multThenAdd 5 y z

-- equivalent to:

multBy5ThenAdd' :: Num a => a -> a -> a
multBy5ThenAdd' = multThenAdd 5

--- partial application: provide only some of the arguments to a function
--- and get back in return a function of the rest of the arguments

divide100 x = div 100 x
-- equivalent to
divide100' = div 100

add5 x = x + 5
-- equivalent to
add5' = (+ 5)

equalsA x = x == 'A'
-- ==
equalsA' = (== 'A')

divideBy14 x = div x 14

divideBy14' = (`div` 14)

-----------

-- Anonymous functions

-- (\x -> x + 3)
---- equivalent to
-- (+ 3)

-- map (+ 3) [1..10]

longWords words = filter (\w -> length w > 5) words

-- more than 1 parameter: (\x y -> x + y)

--- want to: find all even numbers between 1 and 10, square them, and find their sum

-- sum (map (^ 2) (filter even [1..10]))

--- Function application operator - $
-- passes the result of one expression on the right to the one on the left

sum $ map (^ 2) $ filter even [1..10]

-- :t ($)
-- ($) :: (a -> b) -> a -> b

succ $ 5 + 4