grammar Lang;

@header {
package me.miak.parser;
import java.util.HashMap;
}

@members {
/** Map variable name to Integer object holding value */
HashMap<Integer, Integer> memory = new HashMap();
}

prog :   (line? (EOL | EOE))*;
                
line
    :  expr
    |  declaration
    |  assignment
    |  whileLoop
    ;

expr returns [int value]
    : e=parenthesizedExpr {$value = $e.value;}
    | f=boolExpr {$value = $f.value;}
    | g=arithmeticExpr {$value = $g.value;}
    ;

declaration : TYPE ID (EQ expr)?;

assignment : ID EQ expr;

parenthesizedExpr returns [int value]
    : '(' e=expr ')' {$value = $e.value;}
    ;

whileLoop : 'while' '(' boolExpr ')' '{' prog '}';

boolExpr returns [int value]
     : e=arithmeticExpr {$value = $e.value;}
     ( EQQ e=arithmeticExpr {$value = $value == $e.value ? 1 : 0;}
     | NEQ e=arithmeticExpr {$value = $value != $e.value ? 1 : 0;}
     )
     ;

arithmeticExpr returns [int value]
    :   e=multExpr {$value = $e.value;}
       (   '+' e=multExpr {$value += $e.value;}
       |   '-' e=multExpr {$value -= $e.value;}
       )*
    ;

multExpr returns [int value]
    :   e=atom {$value = $e.value;} ('*' e=atom {$value *= $e.value;})*
    ;

atom returns [int value]
    :   INT {$value = Integer.parseInt($INT.text);}
    |   ID
    |   e=parenthesizedExpr {$value = $e.value;}
    ;

TYPE : 'int' | 'float' | 'string';
INT :   DIGIT+ ;
ID  :   LETTER+ (DIGIT | LETTER)* ;
EOL :   '\r'? '\n' ;
WS  :   (' '|'\t') -> skip;
EOE : ';';
TRUE: 'true';
FALSE: 'false';

EQ : '=';
EQQ : '==';
NEQ : '!=';

fragment
LETTER: ('a'..'z'|'A'..'Z'|'_');

fragment
DIGIT : '0'..'9';


LineComment : '//' ~[\r\n]* -> skip;