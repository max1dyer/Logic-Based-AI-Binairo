:- use_module(library(clpfd)).

% Rows is a list of list where [[1,1],[0,1]] would translate to a board of
% 1 1
% 0 1

% test with given puzzles
test(N, M) :- 
    puzzle(N, Rows),
    binairo(Rows, M, Solution),
    maplist(portray_clause, Solution).

puzzle(1, [
    [0, 0, _, _],
    [0, _, _, 1],
    [_, _, _, _],
    [_, 1, _, _]
]).

puzzle(2, [
    [_, 0, _, 0, _, _, _, _, _, 0, _, _],
    [_, _, _, 0, 0, _, _, _, 0, 0, _, _],
    [_, _, _, _, _, 1, _, _, _, _, _, _],
    [1, 1, _, 0, _, _, _, _, 0, 0, _, _],
    [_, 1, _, _, _, _, 1, _, _, _, _, _],
    [1, _, _, _, _, 0, _, _, _, _, 1, _],
    [1, _, 0, _, _, _, _, _, _, _, 1, 1],
    [_, _, 0, _, _, _, _, _, _, _, _, _],
    [_, _, _, _, _, 1, _, _, _, _, _, _],
    [_, 0, _, _, _, _, _, _, 0, _, 0, _],
    [_, _, _, _, _, 1, _, _, _, _, _, _],
    [_, _, _, _, 0, _, _, _, _, _, _, _]
]).

% solve a board(Rows) based on rules of binairo on a Dimension by Dimension grid
binairo(Rows, Dimension, Solution) :- 
    append(Rows, Vars), Vars ins 0..1,          % all variables are either 0 or 1
    length(Rows, Dimension),                    % number of rows is equal to the Dimension
    maplist(same_length(Dimension), Rows),      % ensure all lists are of length Dimension / number of columns is equal to the Dimension
    transpose(Rows, Cols),                      % creates list of lists to represent columns

    % constrain rows and columns to not allow three in a row of 1s or 0
    triplet_constraint(Rows, Cols),
    equality_constraint(Rows, Cols),
    uniqueness_constraint(Rows, Cols),

    Solution = Rows.

% check if List is length L
same_length(L, List) :-
    is_list(List),
    length(List, L).

% constrain the board so there are no triplets
triplet_constraint(Rows, Cols) :-
    maplist(no_triplets, Rows),
    maplist(no_triplets, Cols).

% ensure no three of a kind in a row
no_triplets([_, _]).                    % lists of length 2 cannot have triplets
no_triplets([A, B, C | Remainder]) :- 
    A + B + C #\= 0,                    % not 000
    A + B + C #\= 3,                    % not 111
    no_triplets([B, C | Remainder]).    % remove first element and check rest of list

% constrain board so all rows and columns have the same numbers of 1s and the same numbers of 0s
equality_constraint(Rows, Cols) :-
    maplist(limit_half, Rows),
    maplist(limit_half, Cols).

% ensure equal count of 0s and 1s
limit_half(List) :-
    count(0, List, Count0),
    count(1, List, Count1),
    Count0 #= Count1.

% count the number of 0s and the number of 1s
count(_, [], 0).
count(Var, [X|Remainder], Count) :- 
    X #= Var,
    count(Var, Remainder, OldCount),
    Count is OldCount + 1.
count(Var, [X|Remainder], Count) :- 
    X #\= Var,
    count(Var, Remainder, Count).

% constrain the board so all rows are unique and all columns are unique
uniqueness_constraint(Rows, Cols) :-
    unique_list_of_lists(Rows),
    unique_list_of_lists(Cols).

% ensure CurrentList is not equal to any other list in list of lists
unique_list_of_lists([_]).
unique_list_of_lists([CurrentList | Remainder]) :-
    maplist(lists_not_equal(CurrentList), Remainder),   % check CurrentList against the remaining lists
    unique_list_of_lists(Remainder).                    % recurse through the rest of the lists

% ensure elements of list are not equal to another list
lists_not_equal([], []) :- false.
lists_not_equal([A | As], [B | Bs]) :-
    A #= B,
    lists_not_equal(As, Bs).
lists_not_equal([A | _], [B | _]) :- A #\= B.