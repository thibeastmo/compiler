grammar BasicJava;

program
    :   declaration*
    ;

declaration
    :   attributeDeclaration
    |   methodDeclaration
    ;

attributeDeclaration
    :   type ID '=' expression ';'
    ;

methodDeclaration
    :   'function' type ID '(' methodDeclarationParameterList? ')' '{' statement* '}'
    ;

type
    :   'int'
    |   'boolean'
    |   'string'
    |   'void'
    ;

methodDeclarationParameterList
    :   type ID ( ',' type ID )*
    ;

methodCall
    :   ID '(' argumentList? ')'
    ;

argumentList
    :   expression ( ',' expression )*
    ;

statement
    :   ID ';'
    |   'return' expression ';'
    |   methodCall ';'
    |   if_statement
    ;

if_statement
    :   'if' '(' expression ')' '{' statement* '}'
    ;

expression
    :   '(' expression ')'
    |   expression '+' expression
    |   expression '-' expression
    |   ID
    |   INT
    |   BOOL
    |   STRING
    |   methodCall
    ;

ID      : [a-zA-Z_.]+ ;
INT     : [0-9]+ ;
BOOL    : 'true' | 'false' ;
STRING  : '"' .*? '"' ;
WS      : [ \t\r\n]+ -> skip ;
