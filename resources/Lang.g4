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
 | funDefinition
 | declaration
 | declarationWithAssignment
 | ifStat
 | outStat
 | whileStat
 | forStat
 | funCall SCOL
 | returnStat
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

returnStat: RETURN expr SCOL;

funDefinition: type ID ASSIGN funDefinitionArgs? ARROW (statBlock | expr SCOL);

funDefinitionArgs
 : ID
 | OPAR ID (COMMA ID)* CPAR
 | OPAR CPAR
 ;

funCall : ID OPAR funArgs? CPAR;

funArgs
 : expr
 | expr (COMMA expr)*
 ;

outStat: comm=(DEBUG | PRINT) expr SCOL;

assignment
 : ID ASSIGN expr SCOL
 ;

declaration
 : type ID SCOL
 ;

declarationWithAssignment
 : type ID ASSIGN expr SCOL
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
 : FOR ID IN iterable statBlock
 ;

iterable : ID | range;

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
 | funCall                              #funExpr
 | atom                                 #atomExpr
 ;

index
 : expr     #indexSingle
 | range    #indexRange
 ;

range : expr THROUGH expr (THROUGH expr)?;

atom
 : (INT | FLOAT)                #numberAtom
 | (TRUE | FALSE)               #booleanAtom
 | ID                           #idAtom
 | STRING                       #stringAtom
 | NULL                         #nullAtom
 ;

type: CONST | VAR;

CONST : 'const';
VAR : 'let';
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
RETURN : 'ret';

FOR : 'for';
IN : 'in';
IF : 'if';
ELIF : 'elif';
ELSE : 'else';
WHILE : 'while';

TRUE : 'true';
FALSE : 'false';
NULL : 'null';
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