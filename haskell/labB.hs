
--- Before the lab:

sum' [] = 0
sum' (x:xs) = x + sum' xs

--- The following three are all equivalent:

filter' _ [] = []
filter' f (x:xs)
    | f x       = x : filter' f xs
    | otherwise = filter' f xs

filter'' f lst
    | lst == [] = []
    | f x       = x : filter'' f xs
    | otherwise = filter'' f xs
    where x = head lst
          xs = tail lst

filterUgly _ [] = []
filterUgly f (x:xs) = if f x
                    then x : filterUgly xs
                    else filterUgly xs


--- Lab questions:

safeDiv :: Int -> Int -> Int
safeDiv _ 0 = maxBound :: Int
safeDiv x y = div x y


listAfter5 [] = []
listAfter5 (5:t) = t
listAfter5 (_:t) = listAfter5 t

listUntil5 [] = []
listUntil5 (5:t) = []
listUntil5 (x:t) = x:(listUntil5 t)


collatz x
    | even x = div x 2
    | otherwise = succ (3 * x)


-- x hours y minutes z seconds

convertTime seconds
    | h == 0 && m == 0 = (show s) ++ " seconds"
    | h == 0           = (show m) ++ " minutes " ++ (show s) ++ " seconds"
    | otherwise        = (show h) ++ " hours " ++ (show m) ++ " minutes " ++ (show s) ++ " seconds"
    where minutes = seconds `div` 60
          h = minutes `div` 60
          m = minutes `mod` 60
          s = seconds `mod` 60

-- This way is fancy and recursive, but doesn't help that much
convertTime' seconds
    | h == 0 && m == 0 = (show s) ++ " seconds"
    | h == 0           = (show m) ++ " minutes " ++ convertTime' s
    | otherwise        = (show h) ++ " hours " ++ convertTime' (m * 60 + s)
    where minutes = seconds `div` 60
          h = minutes `div` 60
          m = minutes `mod` 60
          s = seconds `mod` 60