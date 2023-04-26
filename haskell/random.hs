import System.Random

-- Write a function that takes a StdGen and returns 3 random integers

threeInts :: StdGen -> (Int, Int, Int)
threeInts gen = (int1, int2, int3)
    where (int1, gen1) = random gen :: (Int, StdGen)
          (int2, gen2) = random gen1 :: (Int, StdGen)
          (int3, gen3) = random gen2 :: (Int, StdGen)

-- randoms - gives an infinite sequence of random numbers

allTheRandoms = randoms (mkStdGen 5) :: [Int]

-- Write a function that generates random Ints until one has at least ten 7's in it

ten7s int = 10 <= length [c | c <- show int, c == '7']

firstRandomIntGTten7s gen = head $ filter ten7s $ randoms gen

-- randomR - gives us a random value from a particular range

randomSample list gen = list !! (fst $ randomR (0, pred $ length list) gen)

-- What if we want a different seed to be automatically set each time we
-- run our program?

-- getStdGen is an impure function that gives a different StdGen each time

-- this returns a monad StdGen, that we need to unpack to use it.
-- This must be used in a do block to have effect

main1 = do
    gen <- getStdGen
    print $ take 5 $ (randomRs (1, 6) gen :: [Float])


-- this isn't good -- it uses the same generator
main2 = do
    gen <- getStdGen
    print $ take 5 $ (randomRs (1, 6) gen :: [Int])
    gen2 <- getStdGen
    print $ take 5 $ (randomRs (1, 6) gen2 :: [Int])

-- this works!
main = do
    gen <- getStdGen
    print $ take 5 $ (randomRs (1, 6) gen :: [Int])
    gen2 <- newStdGen
    print $ take 5 $ (randomRs (1, 6) gen2 :: [Int])
    gen3 <- getStdGen
    print $ take 5 $ (randomRs (1, 6) gen3 :: [Int])