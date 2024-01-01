grammar BasicJava;

@header {
package antlr;
}

prog
    :   (declarating | expression)+ EOF    # Program
    ;

declarating
    :   variableDeclaration
    |   methodDeclaration
    ;

variableDeclaration
    :   type ID '=' expression ';'  # Declaration
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

while_statement
    :   'while' '(' expression ')' '{' statement* '}'
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
TEXT  : '"' .*? '"' ;
WS      : [ \t\r\n]+ -> skip ;
