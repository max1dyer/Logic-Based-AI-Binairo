:- use_module(library(clpfd)).

% solve a board(Rows) based on rules of binairo on a Dimension by Dimension grid
% Rows is a list of list where [[1,1],[0,1]] would translate to a board of
% 1 1
% 0 1

binairo(Rows, Dimension) :- 
    length(Rows, Dimension),                % number of rows is equal to the Dimension
    maplist(same_length(Dimension), Rows),  % ensure all lists are of length Dimension / number of columns is equal to the Dimension
    transpose(Rows, Cols),                  % creates list of lists to represent columns

    % constrain rows and columns to not allow three in a row of 1s or 0
    triplet_constraint(Rows, Cols),
    equality_constraint(Rows, Cols),
    uniqueness_constraint(Rows, Cols).

% check if List is length L
same_length(L, List) :-
    is_list(List),
    length(List, L).

% constrain the board so there are no triplets
triplet_constraint(Rows, Cols) :-
    maplist(no_triplets, Rows),
    maplist(no_triplets, Cols).
no_triplets([_, _]).                    % base case -- lists of length 2 cannot have triplets
no_triplets([A, B, C | Remainder]) :- 
    \+ triplet_equal(A, B, C),          % check first three elements are not equal
    no_triplets([B, C | Remainder]).    % remove first element and check rest of list
triplet_equal(A, A, A).

% constrain board so all rows and columns have the same numbers of 1s and the same numbers of 0s
equality_constraint(Rows, Cols) :-
    maplist(equal_one_zero, Rows),
    maplist(equal_one_zero, Cols).
equal_one_zero(List) :-
    count_entries(List, Count0, Count1),
    Count0 =:= Count1.
count_entries([], 0, 0).
count_entries([0|Remainder], Count0, Count1) :-
    count_entries(Remainder, New0, Count1),
    Count0 is New0 + 1.
count_entries([1|Remainder], Count0, Count1) :-
    count_entries(Remainder, Count0, New1),
    Count1 is New1 + 1.

% constrain the board so all rows are unique and all columns are unique
uniqueness_constraint(Rows, Cols) :-
    unique(Rows),
    unique(Cols).
unique([]).
unique([List1 | Remainder]) :-
    \+ member(List1, Remainder),        % check if no other list matches List1
    unique(Remainder).                  % recurse through the rest of the lists