grammar BasicJava;

classDeclaration
    :   'public' 'class' ID '{'
            memberDeclaration*
        '}' ;

memberDeclaration
    :   attributeDeclaration
    |   methodDeclaration
    ;

attributeDeclaration
    :   'private' 'final' type ID ';' ;

methodDeclaration
    :   'public' type ID '(' parameterList? ')' '{'
            statement*
        '}' ;

type:   builtInType
    |   ID
    ;

builtInType
    :   'int'
    |   'double'
    |   'een'
    |   'void'
    ;

parameterList
    :   type ID ( ',' type ID )* ;

statement
    :   ID ';' ;

ID  :   [a-zA-Z]+ ;
WS  :   [ \t\r\n]+ -> skip ;
