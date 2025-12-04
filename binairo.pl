:- use_module(library(clpfd)).

% solve a board(Rows) based on rules of binairo on a Dimension by Dimension grid
% Rows is a list of list where [[1,1],[0,1]] would translate to a board of
% 1 1
% 0 1
binairo(Rows, Dimension) :- 
    length(Rows, Dimension),
    maplist(same_length(Dimension), Rows),  % ensure all lists are of length Dimension
    transpose(Rows, Cols),                  % creates list of lists to represent columns
    maplist(same_length(Dimension), Cols),

    % constrain rows and columns to not allow three in a row of 1s or 0s
    maplist(constrain_three(Row), Rows),
    maplist(constrain_three(Col), Cols).

% check if List is length L
same_length(L, List) :- is_list(List),
                        length(List, L).

% to do - ensure no row/column has three 1s or 0s in a line
constrain_three(List) :- % TO DO