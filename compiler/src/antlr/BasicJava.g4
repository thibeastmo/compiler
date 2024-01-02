grammar BasicJava;

@header {
package antlr;
}

prog
    :   (declarating | statement)+ EOF    # Program
    ;

declarating
    :   variableDeclaration
    |   methodDeclaration
    ;

variableDeclaration
    :   type? ID '=' (expression | methodCall | condition) ';'  # Declaration
    ;

methodDeclaration
    :   'function' type ID '(' methodDeclarationParameterList? ')' '{' statement* '}'
    ;

type
    :   'int'
    |   'boolean'
    |   'text'
    |   'void'
    ;

methodDeclarationParameterList
    :   type ID ( ',' type ID )*
    ;

methodCall
    :   ID '(' argumentList? ')'
    ;

argumentList
    :   (expression | condition) ( ',' ( expression | condition))*
    ;

statement
    :   'return' (expression | condition) ';'
    |   if_statement
    |   while_statement
    |   declarating
    ;


if_statement
    :   'if' '(' condition ')' '{' statement* '}' ('else' '{' statement* '}')?
    ;

while_statement
    :   'while' '(' condition ')' '{' statement* '}'
    ;


condition
    :   expression '<' expression
    |   expression '>' expression
    |   expression '==' expression
    |   expression '<=' expression
    |   expression '>=' expression
    |   expression '!=' expression
    |   ID
    ;

expression
    :   expression '-' expression   # Subtraction
    |   expression '+' expression   # Addition
    |   INT                         # Number
    |   BOOL                        # Bool
    |   TEXT                        # Text
    |   ID                          # Variable
    ;


ID      : [a-zA-Z_.]+ ;
INT     : [0-9]+ ;
BOOL    : 'true' | 'false' ;
TEXT    : '"' .*? '"' ;
WS      : [ \t\r\n]+ -> skip ;
