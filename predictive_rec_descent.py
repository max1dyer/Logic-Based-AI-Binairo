# predicitve recursive descent parser of expr grammar

# parse a list of prefix bool tokens into infix form
def parse(tokens):
    try:
        start, prec, consumed = parse_expr(tokens, 0)
        # if all tokens weren't consumed, the string is invalid
        if consumed != len(tokens):
            print()
            return()
        print(start.strip())
    except ValueError:
        print()

# parse expr recursively
def parse_expr(tokens, i):
    # if index is greater or equal to length of expr, expr is invalid
    if i >= len(tokens):
        raise ValueError
    
    token = tokens[i]
    # split into 5 cases: "or", "and", "not", id, and invalid
    # case 1: token is operator "or"
    if token == 'or':
        left_expr, left_prec, i1 = parse_expr(tokens, i + 1)
        right_expr, right_prec, i2 = parse_expr(tokens, i1)
        
        # add parenthesis, avoid redundant by checking precidence
        if left_prec < 1:
            left_expr = "( " + left_expr + " )"
        if right_prec <= 1:
            right_expr = "( " + right_expr + " )"
        
        # make the infix expression using computed left and right expressions
        expr = left_expr + " or " + right_expr
        return expr, 1, i2
    # case 2: token is operator "and"
    elif token == 'and':
        left_expr, left_prec, i1 = parse_expr(tokens, i + 1)
        right_expr, right_prec, i2 = parse_expr(tokens, i1)
        
        # add parenthesis, avoid redundant by checking precidence
        if left_prec < 2:
            left_expr = "( " + left_expr + " )"
        if right_prec <= 2:
            right_expr = "( " + right_expr + " )"
        
        # make the infix expression using computed left and right expressions
        expr = left_expr + " and " + right_expr
        return expr, 2, i2
    # case 3: token is operator "not"
    elif token == 'not':
        inner_expr, inner_prec, i1 = parse_expr(tokens, i + 1)
        
        # add parenthesis if needed:
        if inner_prec < 3:
            inner_expr = "( " + inner_expr + " )"
        
        # make the infix expression using computed inner expession
        expr = "not " + inner_expr
        return expr, 3, i1
    # case 4: token is identifier
    elif token.isalpha() and len(token) == 1:
        return token, 4, i + 1
    # case 5: invalid token
    else:
        raise ValueError


parse(['and','and','a','or','b','c','d'])
parse(['and','a','and','b','c'])
parse(['and','and','a','or','b','c'])
parse(['or','a','or','b','c'])
parse(['not','or','a','b'])
parse(['or','or','a', 'b','and','c','d'])
parse(['not','not','a'])
parse(['or','and','a', 'b','and','c','d'])
parse(['and','or','a', 'b','and','c','d'])
parse(['and','and','a', 'b','and','c','d'])
