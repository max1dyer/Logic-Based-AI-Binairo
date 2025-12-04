% predictive recursive descent parser of expr grammar

% parse the tokens into the expression
parse(Tokens, R) :- expr(Tokens, R, _, []).

% expr parses the tokens, builds the expression string, 
% marks precidence, marks the remaining tokens that need to be parsed
% in 4 cases: head is "or", "and", "not", or a letter
% case 1: head is "or"
expr([or|Tail], Expr, 1, Remaining) :- expr(Tail, LeftExpr, LeftPrec, Remaining1),
                                       expr(Remaining1, RightExpr, RightPrec, Remaining),
                                       (LeftPrec < 1 -> string_concat("( ", LeftExpr, Str1), string_concat(Str1, " )", LeftStr) ; LeftStr = LeftExpr),
                                       (RightPrec =< 1 -> string_concat("( ", RightExpr, Str2), string_concat(Str2, " )", RightStr) ; RightStr = RightExpr),
                                       string_concat(LeftStr, " or ", Str3),
                                       string_concat(Str3, RightStr, Expr).
% case 2: head is "and"
expr([and|Tail], Expr, 2, Remaining) :- expr(Tail, LeftExpr, LeftPrec, Remaining1),
                                        expr(Remaining1, RightExpr, RightPrec, Remaining),
                                        (LeftPrec < 2 -> string_concat("( ", LeftExpr, Str1), string_concat(Str1, " )", LeftStr) ; LeftStr = LeftExpr),
                                        (RightPrec =< 2 -> string_concat("( ", RightExpr, Str2), string_concat(Str2, " )", RightStr) ; RightStr = RightExpr),
                                        string_concat(LeftStr, " and ", Str3),
                                        string_concat(Str3, RightStr, Expr).
% case 3: head is "not"
expr([not|Tail], Expr, 3, Remaining) :- expr(Tail, InnerExpr, InnerPrec, Remaining),
                                        (InnerPrec < 3 -> string_concat("( ", InnerExpr, Str1), string_concat(Str1, " )", InnerStr) ; InnerStr = InnerExpr),
                                        string_concat("not ", InnerStr, Expr).
% case 4: head is identifier
expr([Id|Remaining], Id, 4, Remaining) :- atom(Id),
                                          atom_length(Id, 1),
                                          char_type(Id, lower).
