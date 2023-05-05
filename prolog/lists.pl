
myMember(X, [X | _]).
myMember(X, [_ | T]) :- myMember(X, T).

myAppend([], A, A).
myAppend([H|T], A, [H|L]) :- myAppend(T, A, L).

%% [a,b,c] ++ [d,e,f]
%% L = [b,c] ++ [d,e,f] -- what does H need to be?

% Find the middle element of an odd-length list
middleElement(List, Middle) :- append(Start, [Middle | End], List),
                               length(Start, Len),
                               length(End, Len).

% [a,b,c,d,e]

%% lastElement - should find the last element in a list
lastElement(List, Element) :- append(_, [Element], List).

allButLast(List, AllBut) :- append(AllBut, [_], List).

% ?- [a,b,c] = [Cat | Dog].
% Cat = a,
% Dog = [b, c].

% ?- member(b, [a,b,c,d]).
% true ;
% false.

% ?- member(b, [a,b,c,b]).
% true ;
% true.

% ?- member(b, [a,b,c,b,w]).
% true ;
% true ;
% false.

% ?- member(e, [a,b,c,b,w]).
% false.

% ?- member(X, [a,b,c,d]).
% X = a ;
% X = b ;
% X = c ;
% X = d.

% ?- member(b, List).
% List = [b|_] ;
% List = [_, b|_] ;
% List = [_, _, b|_] ;
% List = [_, _, _, b|_] ;
% List = [_, _, _, _, b|_] ;
% List = [_, _, _, _, _, b|_] ;
% List = [_, _, _, _, _, _, b|_] ;
% List = [_, _, _, _, _, _, _, b|_] ;
% List = [_, _, _, _, _, _, _, _, b|...] ;
% List = [_, _, _, _, _, _, _, _, _|...] ;
% List = [_, _, _, _, _, _, _, _, _|...] ;
% List = [_, _, _, _, _, _, _, _, _|...] ;
% List = [_, _, _, _, _, _, _, _, _|...] ;
% List = [_, _, _, _, _, _, _, _, _|...] .

% ?- [lists].
% true.

% ?- myMember(cat, [cat, dog, chicken]).
% true.

% ?- [lists].
% true.

% ?- myMember(cat, [cat, dog, chicken]).
% true.

% ?- myMember(dog, [cat, dog, chicken]).
% false.

% ?- [lists].
% true.

% ?- myMember(dog, [cat, dog, chicken]).
% true ;
% false.

% ?- member(dog, [cat, dog, chicken]).
% true ;
% false.

% ?- myMember(X, [cat, dog, chicken]).
% X = cat ;
% X = dog ;
% X = chicken ;
% false.

% ?- myMember(Hamilton, [cat, dog, chicken]).
% Hamilton = cat ;
% Hamilton = dog ;
% Hamilton = chicken ;
% false.

% ?- [lists].
% Warning: /Users/thelmuth/Documents/cs220-popl/code-from-class/prolog/lists.pl:3:
% Warning:    Singleton variables: [H]
% true.

% ?- myMember(cat, [cat, dog, chicken, cat]).
% true ;
% true ;
% false.

% ?- append([a,b], [c,d], [a,b,c,d]).
% true.

% ?- append([a,b], [c,d], List).
% List = [a, b, c, d].

% ?- append(W, [c,d], [a,b,c,d]).
% W = [a, b] ;
% false.

% ?- append([a,b], Z, [a,b,c,d]).
% Z = [c, d].

% ?- append(A, B, [a,b,c,d]).
% A = [],
% B = [a, b, c, d] ;
% A = [a],
% B = [b, c, d] ;
% A = [a, b],
% B = [c, d] ;
% A = [a, b, c],
% B = [d] ;
% A = [a, b, c, d],
% B = [] ;
% false.

% ?- [lists].
% true.

% ?- myAppend([a,b], [c,d], Cat).
% Cat = [a, b, c, d].

% ?- myAppend([a,b], [], Cat).
% Cat = [a, b].

% ?- myAppend(X, Y, [a,b,c,d]).
% X = [],
% Y = [a, b, c, d] ;
% X = [a],
% Y = [b, c, d] ;
% X = [a, b],
% Y = [c, d] ;
% X = [a, b, c],
% Y = [d] ;
% X = [a, b, c, d],
% Y = [] ;
% false.

% ?- [lists].
% true.

% ?- middleElement([a,b,c,d,e], X).
% X = c ;
% false.

% ?- middleElement(List, t).
% List = [t] ;
% List = [_, t, _] ;
% List = [_, _, t, _, _] ;
% List = [_, _, _, t, _, _, _] ;
% List = [_, _, _, _, t, _, _, _, _] ;
% List = [_, _, _, _, _, t, _, _, _|...] ;
% List = [_, _, _, _, _, _, t, _, _|...] ;
% List = [_, _, _, _, _, _, _, t, _|...] .

% ?- [lists].
% Warning: /Users/thelmuth/Documents/cs220-popl/code-from-class/prolog/lists.pl:16:
% Warning:    Singleton variables: [Begin]
% true.

% ?- [lists].
% true.

% ?- lastElement([a,b,c,d], X).
% X = d ;
% false.

% ?- [lists].
% true.

% ?- lastElement([a,b,c,d], X).
% X = [d] ;
% false.

% ?- [lists].
% true.

% ?- allButLast([a,b,c,d], X).
% X = [a, b, c] ;
% false.

% ?- [lists].
% true.

% ?- allButLast([a,b,c,d], X).
% X = [] ;
% X = [a] ;
% X = [a, b] ;
% X = [a, b, c] ;
% X = [a, b, c, d] ;
% false.

% ?- allButLast([a,b,c,[d]], X).
% X = [] 
% ERROR: Type error: `character_code' expected, found `-1' (an integer)
% ERROR: In:
% ERROR:   [11] char_code(_1810,-1)
% ERROR:   [10] '$in_reply'(-1,'?h') at /usr/local/Cellar/swi-prolog/9.0.4/libexec/lib/swipl/boot/init.pl:1037
% ?- [lists].
% true.

% ?- allButLast([a,b,c,[d]], X).
% X = [a, b, c] ;
% false.

% ?- X is 5 + 6.
% X = 11.

% ?- 11 is 5 + X.
% ERROR: Arguments are not sufficiently instantiated
% ERROR: In:
% ERROR:   [10] 11 is 5+_8492
% ERROR:    [9] toplevel_call(user:user: ...) at /usr/local/Cellar/swi-prolog/9.0.4/libexec/lib/swipl/boot/toplevel.pl:1173
% ?- X = 6, Y is 5 + X.
% X = 6,
% Y = 11.