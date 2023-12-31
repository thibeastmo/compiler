grammar BasicJava;

memberDeclaration
    :   attributeDeclaration
    |   methodDeclaration
    ;

attributeDeclaration
    :   type ID '=' expression ';' ;

methodDeclaration
    :   'function' type ID '(' parameterList? ')' '{'
            statement*
        '}'
    ;

type
    :   'int'
    |   'boolean'
    |   'string'
    |   'void'
    ;

parameterList
    :   type ID ( ',' type ID )* ;

statement
    :   ID ';' 
    |   'return' expression ';'
    ;

expression
    :   '(' expression ')'
    |   expression '+' expression
    |   ID
    |   INT
    |   BOOL
    |   STRING
    ;

ID      : [a-zA-Z]+ ;
INT     : [0-9]+ ;
BOOL    : 'true' | 'false' ;
STRING  : '"' .*? '"' ;
WS      : [ \t\r\n]+ -> skip ;
