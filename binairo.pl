:- use_module(library(clpfd)).

% test with given puzzles
test(N, M) :- 
    puzzle(N, Rows),
    binairo(Rows, M).

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

% output solved binairo board, Dimension must be greater than 2 and even
binairo(Rows, Dimension) :-
    binairo_solver(Rows, Dimension),
    maplist(portray_clause, Rows).

% solve a board(Rows) based on rules of binairo on a Dimension by Dimension grid
binairo_solver(Rows, Dimension) :- 
    append(Rows, Vars), Vars ins 0..1,          % all variables are either 0 or 1
    length(Rows, Dimension),                    % number of rows is equal to the Dimension
    maplist(same_length(Dimension), Rows),      % ensure all lists are of length Dimension / number of columns is equal to the Dimension
    transpose(Rows, Cols),                      % creates list of lists to represent columns

    % constrain rows and columns
    triplet_constraint(Rows, Cols),
    equality_constraint(Rows, Cols),
    uniqueness_constraint(Rows, Cols),

    labeling([ffc, bisect], Vars).

% check if List is length L
same_length(L, List) :- length(List, L).

% constrain the board so there are no triplets
triplet_constraint(Rows, Cols) :-
    maplist(no_triplets, Rows),
    maplist(no_triplets, Cols).

% ensure no three of a kind in a row
no_triplets([_, _]) :- !.                    % lists of length 2 cannot have triplets
no_triplets([A, B, C | Remainder]) :- 
    A + B + C #\= 0,                    % not 000
    A + B + C #\= 3,                    % not 111
    no_triplets([B, C | Remainder]).    % remove first element and check rest of list

% constrain board so all rows and columns have equal numbers of 1s and 0s
equality_constraint(Rows, Cols) :-
    maplist(limit_half, Rows),
    maplist(limit_half, Cols).

% ensure equal count of 0s and 1s
limit_half(List) :-
    sum(List, #=, Ones),
    length(List, L),
    Ones #= L // 2.

% constrain the board so all rows are unique and all columns are unique
uniqueness_constraint(Rows, Cols) :-
    unique_list_of_lists(Rows),
    unique_list_of_lists(Cols).

% checks if two lists differ by at least one number
unique_list_of_lists([_]).
unique_list_of_lists([List | Remainder]) :-
    maplist(lists_not_equal(List), Remainder),          % check List against the remaining lists
    unique_list_of_lists(Remainder).                    % recurse through the rest of the lists

% check if elements of lists are equal
lists_not_equal([], []) :- false.
lists_not_equal([A | As], [A | Bs]) :- lists_not_equal(As, Bs).
lists_not_equal([A | _], [B | _]) :- A #\= B.