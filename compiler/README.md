

# Wat te doen om te testen?
### Debug in 1 command:
`npm run gen-compile-debug`

### Generate en compile in 1 command:
`npm run gen-compile`

### Stappenplan debuggen (Zie 'Debug in 1 command' voor efficiënter te debuggen)
1. `npm run antlr` --> Om te bevestigen dat de jar werkt
2. `npm run antlr-gen` --> Creëren van Lexer & parser bestanden
3. `npm run java-gen` --> Compilen van java bestanden
4. `npm run grun` --> Om te bevestigen dat TestRig werkt
5. `npm run grun-gui` --> Om antlr te debuggen
