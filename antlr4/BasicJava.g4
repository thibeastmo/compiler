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

type:   builtInType
    |   ID
    ;

builtInType
    :   'int'
    |   'double'
    |   'String'
    |   'void'
    ;

parameterList
    :   type ID ( ',' type ID )* ;

statement
    :   ID ';' ;

ID  :   [a-zA-Z]+ ;
WS  :   [ \t\r\n]+ -> skip ;