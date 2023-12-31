grammar BasicJava;

classDeclaration
    :   'public' 'class' ID '{'
            (memberDeclaration | constructorDeclaration)*
        '}'
    ;

memberDeclaration
    :   attributeDeclaration
    |   methodDeclaration
    ;

constructorDeclaration
    :   'public' ID '(' parameterList? ')' '{'
            statement*
        '}'
    ;

attributeDeclaration
    :   'private' 'final' type ID ';' ;

methodDeclaration
    :   'public' type ID '(' parameterList? ')' '{'
            statement*
        '}'
    ;

type
    :   'int'
    |   'boolean'
    |   'String'
    |   'void'
    ;

parameterList
    :   type ID ( ',' type ID )* ;

statement
    :   ID ';' 
    |   'return' expression ';'    // Added for return statements
    |   'System.out.println' '(' expression ')' ';' // Added for println statements
    ;

expression
    :   '(' expression ')'
    |   expression '+' expression
    |   ID
    |   INT
    |   BOOL   // Added for boolean literals
    |   STRING // Added for string literals
    ;

ID      : [a-zA-Z]+ ;
INT     : [0-9]+ ;
BOOL    : 'true' | 'false' ;
STRING  : '"' .*? '"' ;
WS      : [ \t\r\n]+ -> skip ;
