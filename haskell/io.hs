
--- Can't change any state in Haskell
--- - Every function will return the same outputs for the same inputs.
--- - This includes changing the state of output devices (printing)
---    and getting state from input devices such as the keyboard.

-- To do output, we need to define a main function and call it

main1 = putStrLn "Hello World!"

-- Compile:
-- ghc --make io.hs

-- Interpret:
-- runhaskell io.hs

-- or, can load the file in ghci, and run the main function


-- :t putStrLn
-- putStrLn :: String -> IO ()

-- This says that putStrLn takes a String and returns an *IO action*
-- with the result type ()
-- An IO action does something side-effecty with IO
-- IO actions are like a box, that, when you unpack it, does some sort of IO

-- printing has no return value, which is why this IO action's item is an empty tuple

--- 3 ways to make an IO action take effect in Haskell:
-- 1. Give an IO action the name "main" and run the program.
-- 2. Run the IO action or a function that performs the IO action in GHCI
-- 3. Put the IO action inside a _do block_ that is eventually passed
--    to main or a function called in GHCI.

----- do syntax -----
-- to perform more than 1 IO action, we need to use the do keyword.
-- syntax: do, followed by one more more lines of IO operations
--  the last operation must return an IO action

main2 = do
    putStrLn "Give me your name!"
    name <- getLine
    putStrLn $ "HELLO " ++ name

    
square x = x * x

main3 = do
    putStrLn "This is 5 squared!"
    putStrLn $ show $ square 5

-- input

-- getLine gets a line from standard input
-- Note: getLine isn't required to return the same value when run twice!
--  -- Impure function!
--  -- this is why it returns an IO action:

-- :t getLine
-- getLine :: IO String

-- this IO action contains a value of type String
-- "<-" takes the result out of an IO action and binds the result to a given variable name
-- <- can only be used within another IO action, such as a do block

-- The thing bound with <- can be passed as an argument to a regular function:

colorJudge color
    | color == "yellow" = "yellow is the best color!!!"
    | otherwise = color ++ " is ok, but not as good as  yellow."

main4 = do
    putStrLn "Tell me your favorite color:"
    color <- getLine
    putStrLn $ colorJudge color

-- Write a function that adds a user input number to the first 6 primes

main5 = do
    putStrLn "Enter a number please:"
    numStr <- getLine
    -- Use a let statement to bind variables to values:
    let addToInput x = x + (read numStr)
        mapped = map addToInput [2, 3, 5, 7, 11, 13]
    putStrLn $ "Adding " ++ numStr ++ " to the first 6 primes gives " ++ (show mapped)


-- write a function that gets an integer from the user

getInt :: IO Integer
getInt = do
    line <- getLine
    return (read line :: Integer)

main6 = do
    putStr "Enter an integer: "
    i <- getInt
    putStrLn $ (show i) ++ " squared is " ++ (show $ i * i)

-- return:
-- takes a value and turns it into an IO action type of that value
-- Since an IO action can get its value using <-, this works:

main7 = do
    a <- return "This"
    b <- return " is silly"
    putStrLn $ a ++ b


-- getListOfStrings - gets a list of strings from the user, stopping at RET

getListOfStrings :: IO [String]
getListOfStrings = do
    line <- getLine
    if null line
        then return []
        else do
            listOfStrings <- getListOfStrings
            return (line : listOfStrings)

main = do
    putStrLn "Enter some strings:"
    strings <- getListOfStrings
    print strings
