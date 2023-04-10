-- NOTE: This is just a copy/paste of the ghci repl session from class.
-- This isn't actually a normal Haskell file, and you can't load it.

Prelude> 5 + 2
7
Prelude> 4.3 * 3.1
13.33
Prelude> 65 / 7
9.285714285714286
Prelude> (+) 5 2
7
Prelude> (+) 5 2 1

<interactive>:5:1: error:
    • Non type-variable argument in the constraint: Num (t1 -> t2)
      (Use FlexibleContexts to permit this)
    • When checking the inferred type
        it :: forall t1 t2. (Num t1, Num (t1 -> t2)) => t2
Prelude> div 65 7
9
Prelude> 65 div 7

<interactive>:7:1: error:
    • Non type-variable argument
        in the constraint: Num ((a -> a -> a) -> t1 -> t2)
      (Use FlexibleContexts to permit this)
    • When checking the inferred type
        it :: forall a t1 t2.
              (Integral a, Num t1, Num ((a -> a -> a) -> t1 -> t2)) =>
              t2
Prelude> 65 `div` 7
9
Prelude> 7 * (52 - 31)
147
Prelude> 7 * 52 - 31
333
Prelude> 7 - 52 * 31
-1605
Prelude> -45 * 31
-1395
Prelude> succ 4
5
Prelude> max 42 23
42
Prelude> 5 == 6
False
Prelude> 23.1 >= 4.2
True
Prelude> "hat" == "hat"
True
Prelude> "hat" == 7

<interactive>:18:10: error:
    • No instance for (Num [Char]) arising from the literal ‘7’
    • In the second argument of ‘(==)’, namely ‘7’
      In the expression: "hat" == 7
      In an equation for ‘it’: it = "hat" == 7
Prelude> "abc"
"abc"
Prelude> 'a'
'a'
Prelude> ['a', 'b', 'c']
"abc"
Prelude> :t 'a'
'a' :: Char
Prelude> :t "abc"
"abc" :: [Char]
Prelude> :t 4
4 :: Num p => p
Prelude> :t 4.32
4.32 :: Fractional p => p
Prelude> :t True
True :: Bool
Prelude> [1,2,3,4]
[1,2,3,4]
Prelude> [1,2,'a','b'] -- lists must be homogenous

<interactive>:28:2: error:
    • No instance for (Num Char) arising from the literal ‘1’
    • In the expression: 1
      In the expression: [1, 2, 'a', 'b']
      In an equation for ‘it’: it = [1, 2, 'a', ....]
Prelude> [1,2,3.5,4.5]
[1.0,2.0,3.5,4.5]
Prelude> :t [1,2,3.5,4.5]
[1,2,3.5,4.5] :: Fractional a => [a]
Prelude> head [1,2,3,4]
1
Prelude> tail [1,2,3,4]
[2,3,4]
Prelude> [1,2,3,4] ++ [5,6,7]
[1,2,3,4,5,6,7]
Prelude> 0 : [1,2,3]
[0,1,2,3]
Prelude> [1,2,3] : 0

<interactive>:35:1: error:
    • Non type-variable argument in the constraint: Num [[a]]
      (Use FlexibleContexts to permit this)
    • When checking the inferred type
        it :: forall a. (Num a, Num [[a]]) => [[a]]
Prelude> "hi" ++ "there"
"hithere"
Prelude> [1,2,3,4] ++ 5

<interactive>:37:1: error:
    • Non type-variable argument in the constraint: Num [a]
      (Use FlexibleContexts to permit this)
    • When checking the inferred type
        it :: forall a. (Num a, Num [a]) => [a]
Prelude> [1,2,3,4] ++ [5]
[1,2,3,4,5]
Prelude> [6,3,9,1,2] !! 2
9
Prelude> 'a' : " good book"
"a good book"
Prelude> "haskell" !! 3
'k'
Prelude> length [1,2,3]
3
Prelude> null []
True
Prelude> null [1,2,3]
False
Prelude> reverse "haskell"
"lleksah"
Prelude> 'asd'

<interactive>:46:1: error:
    • Syntax error on 'asd'
      Perhaps you intended to use TemplateHaskell or TemplateHaskellQuotes
    • In the Template Haskell quotation 'asd'
Prelude> ''

<interactive>:47:1: error:
    Parser error on `''`
    Character literals may not be empty
Prelude> 'a' == "a"

<interactive>:48:8: error:
    • Couldn't match expected type ‘Char’ with actual type ‘[Char]’
    • In the second argument of ‘(==)’, namely ‘"a"’
      In the expression: 'a' == "a"
      In an equation for ‘it’: it = 'a' == "a"
Prelude> :t 'a'
'a' :: Char
Prelude> :t "a"
"a" :: [Char]
Prelude> 'a' == head "a"
True
Prelude> foldl (+) [1,2,3,4,5,6]

<interactive>:52:1: error:
    • Non type-variable argument in the constraint: Num [a]
      (Use FlexibleContexts to permit this)
    • When checking the inferred type
        it :: forall (t :: * -> *) a.
              (Foldable t, Num a, Num [a]) =>
              t [a] -> [a]
Prelude> lfoldl (+) [1,2,3,4,5,6]

<interactive>:53:1: error:
    • Variable not in scope: lfoldl :: (a0 -> a0 -> a0) -> [a1] -> t
    • Perhaps you meant one of these:
        ‘foldl’ (imported from Prelude), ‘foldr’ (imported from Prelude),
        ‘foldl1’ (imported from Prelude)
Prelude> foldr (+) [1,2,3,4,5,6]

<interactive>:54:1: error:
    • Non type-variable argument in the constraint: Num [a]
      (Use FlexibleContexts to permit this)
    • When checking the inferred type
        it :: forall (t :: * -> *) a.
              (Foldable t, Num a, Num [a]) =>
              t [a] -> [a]
Prelude> foldr (+) 0 [1,2,3,4,5,6]
21
Prelude> foldl (+) 0 [1,2,3,4,5,6]
21
Prelude> foldl (*) 1 [1,2,3,4,5,6]
720
Prelude> take 5 [1,2,3,4,5,6,7,8,9]
[1,2,3,4,5]
Prelude> elem 2 [1,2,3]
True
Prelude> elem 4 [1,2,3]
False
Prelude> 2 `elem` [1,2,3]
True
Prelude> 2 `elem` 2

<interactive>:62:10: error:
    • No instance for (Num [Integer]) arising from the literal ‘2’
    • In the second argument of ‘elem’, namely ‘2’
      In the expression: 2 `elem` 2
      In an equation for ‘it’: it = 2 `elem` 2
Prelude> 'a' `elem` "howdy"
False
Prelude> 'a' `elem` "howady"
True
Prelude> [0..10]
[0,1,2,3,4,5,6,7,8,9,10]
Prelude> [1,3..30]
[1,3,5,7,9,11,13,15,17,19,21,23,25,27,29]
Prelude> [10,9..1]
[10,9,8,7,6,5,4,3,2,1]
Prelude> ['a'..'t']
"abcdefghijklmnopqrst"
Prelude> ['G'..'g']
"GHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefg"
Prelude> 