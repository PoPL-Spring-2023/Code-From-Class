
%% swipl
%% this is the command to start the Prolog interpreter

%% [intro].
%% this is the command to load the file

%% Simple knowledge base that tells how old people are:
age(helmuth, 36).
age(biden, 80).
age(eliza, 5).
age(princeWilliam, 40).
age(mary, 87).

birthplace(helmuth, usa).
birthplace(biden, usa).
birthplace(eliza, B) :- birthplace(helmuth, B).
birthplace(princeWilliam, england).
birthplace(jose, usa).

eligibleForPresident(X) :-
    birthplace(X, usa),
    age(X, Years),
    Years >= 35.


%% New example: female ancestry:

mother(anita, claire).
mother(claire, janice).
mother(janice, laura).
mother(janice, zoe).
mother(janice, kendra).
mother(janice, francine).
mother(zoe, gertrude).
mother(francine, heather).

%% How can we define an ancestor relation.

ancestor(X, Y) :- mother(X, Y).
ancestor(X, Y) :- mother(X, Z), ancestor(Z, Y).
% ancestor(X, Y) :- mother(W, Y), ancestor(X, W). %% this would be fine as well

% ancestor(X, Y) :- ancestor(X, Z), mother(Z, Y). %%% Infinite recursion

%% Define a sister relation

sister(X, Y) :- mother(M, X), mother(M, Y), \+(X = Y).

feetToInches(Feet, Inches) :- Inches is Feet * 12.
