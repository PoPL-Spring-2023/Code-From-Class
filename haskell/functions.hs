
-- Define a constant - a function with zero arguments
list = [1, 3, 8, 12]

one = head list

square :: Num a => a -> a
square x = x * x

-- square :: Num a => a -> a
-- this says: takes an a and returns an a, as long as a is some type of Num


cube x = x * x * x

-- explicit type declaration:
concat3times :: String -> String
concat3times s = s ++ s ++ s

--- concat3times :: String -> String
--- read this as: concat3times takes a String as its argument and returns a String

-- squares only odd integers
squareOdd x = if odd x
                then x * x
                else x

-- factorial
fact :: Integer -> Integer
fact 0 = 1
fact x = x * fact (x - 1)
