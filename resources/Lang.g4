grammar Lang;

@header {
package me.miak.parser;
}

parse
 : block EOF
 ;

block
 : stat*
 ;

stat
 : assignment
 | macro
 | funDefinition
 | declaration
 | declarationWithAssignment
 | ifStat
 | outStat
 | whileStat
 | forStat
 | BREAK SCOL
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

funDefinition: TYPE ID ASSIGN OPAR funArgs? CPAR ARROW (statBlock | expr SCOL);

funArgs
 : TYPE ID
 | TYPE ID (COMMA TYPE ID)*
 ;

iterable : ID | range;

outStat: comm=(DEBUG | PRINT) expr SCOL;

macro: HASH ID;

assignment
 : ID ASSIGN expr SCOL
 ;

declaration
 : TYPE ID SCOL
 ;

declarationWithAssignment
 : TYPE ID ASSIGN expr SCOL
 ;

ifStat
 : IF conditionBlock (ELIF conditionBlock)* (ELSE statBlock)?
 ;

conditionBlock
 : expr statBlock
 ;

statBlock
 : OBRACE block CBRACE
 | stat
 ;

whileStat
 : WHILE expr statBlock
 ;

forStat
 : FOR OPAR TYPE ID IN iterable CPAR statBlock
 ;

expr
 :<assoc=right> expr POW expr           #powExpr
 | MINUS expr                           #unaryMinusExpr
 | NOT expr                             #notExpr
 | expr op=(MULT | DIV | MOD) expr      #multiplicationExpr
 | expr op=(PLUS | MINUS) expr          #additiveExpr
 | expr op=(LTEQ | GTEQ | LT | GT) expr #relationalExpr
 | expr op=(EQ | NEQ) expr              #equalityExpr
 | expr AND expr                        #andExpr
 | expr OR expr                         #orExpr
 | OPAR expr CPAR                       #parExpr
 | expr OSQR index CSQR                 #indexedExpr
 | atom                                 #atomExpr
 ;

index
 : expr     #indexSingle
 | range    #indexRange
 ;

range : expr THROUGH expr;

atom
 : (INT | FLOAT)                #numberAtom
 | (TRUE | FALSE)               #booleanAtom
 | ID                           #idAtom
 | STRING                       #stringAtom
 | NIL                          #nilAtom
 ;

TYPE: ('int' | 'float' | 'string'| 'bool');
OR : 'or';
AND : 'and';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
POW : '^';
NOT : 'not';
HASH: '#';


//EOL : '\r' '\n' | '\n' | '\r';
THROUGH: '::';
COL : ':';
SCOL : ';';
ASSIGN : '=';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';
OSQR : '[';
CSQR : ']';
DQUOTE : '"';
ARROW : '->';
COMMA :',';

FOR : 'for';
IN : 'in';
BREAK : 'break';
IF : 'if';
ELIF : 'elif';
ELSE : 'else';
WHILE : 'while';

TRUE : 'true';
FALSE : 'false';
NIL : 'nil';
PRINT : 'print';
DEBUG : 'debug';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]*
 | '.' [0-9]+
 ;

STRING
 : DQUOTE ( ~["\r\n] | '""')* DQUOTE
 ;

COMMENT
 : '//' ~[\r\n]* -> skip
 ;

SPACE
 : [ \t\r\n] -> skip
 ;

OTHER
 : .
 ;