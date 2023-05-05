%% Equality is based on unification

%% Lists in Prolog are similar to Haskell -- can get head and tail using
%% pattern matching

myLength([], 0).
myLength([H|T], Y) :- myLength(T, X), Y is X + 1.


%% Terminal copy/paste below

?- a = a.
true.

?- a = b.
false.

?- X = a.
X = a.

?- a = X.
X = a.

?- foo(a, b) = foo(X, Y).
X = a,
Y = b.

?- foo(a, B), foo(A, b).
ERROR: Unknown procedure: foo/2 (DWIM could not correct goal)
?- foo(a, B) = foo(A, b).
B = b,
A = a.

?- foo(a, b) = woozle(A, B).
false.

?- A = B, B = zanzibar.
A = B, B = zanzibar.

?- A = B, B = zanzibar, A = clinton.
false.

?- (X, truck, van) = (car, Y, Z).
X = car,
Y = truck,
Z = van.

?- (X, truck, Y) = (car, Y, Z).
X = car,
Y = Z, Z = truck.

?- (X, Z, Y) = (car, Y, truck).
X = car,
Z = Y, Y = truck.

?- L = [a,b,c]
|    .
L = [a, b, c].

?- L = [a | [b,c]]
|    .
L = [a, b, c].

?- L = [a,b | [c]].
L = [a, b, c].

?- [a,b,c,d] = [H | T].
H = a,
T = [b, c, d].

?- [a,b,5,7] = [H | T].
H = a,
T = [b, 5, 7].

?- [a,b,5,7] = [R | Elephant].
R = a,
Elephant = [b, 5, 7].

?- length([a,b,c]).
ERROR: Unknown procedure: length/1
ERROR:     However, there are definitions for:
ERROR:         length/2
false.

?- length([a,b,c], X).
X = 3.

?- [a] = [H|T].
H = a,
T = [].

?- [lists].
Warning: /Users/thelmuth/Documents/cs220-popl/code-from-class/prolog/lists.pl:7:
Warning:    Singleton variables: [H]
true.

?- myLength([a,b,c], X).
X = 3.