% Facts:
% 1. Three people live in 3 houses with 3 colors and 3 pets.
% 2. The person in the red house has a giraffe.
% 3. The first house is blue.
% 4. The house with the elephant is directly to the left of the green house.
% 5. Someone owns an emu.
%%%%% h1 - h2 - h3

einstein_jr(Solution) :-
    Solution = [house(h1, _, _),
                house(h2, _, _),
                house(h3, _, _)],
    member(house(_, red, giraffe), Solution),
    member(house(h1, blue, _), Solution),
    member(house(Elephant, _, elephant), Solution),
    member(house(Green, green, _), Solution),
    left_of(Elephant, Green),
    member(house(_, _, emu), Solution).

left_of(h1, h2).
left_of(h2, h3).


