

# Wat te doen om te testen?
### Debug in 1 command
`npm run gen-compile-debug`

### Generate en compile in 1 command
`npm run gen-compile`

### Stappenplan debuggen (Zie 'Debug in 1 command' voor efficiënter te debuggen)
1. `npm run antlr`      --> Om te bevestigen dat de jar werkt
2. `npm run antlr-gen`  --> Creëren van Lexer & parser bestanden
3. `npm run java-gen`   --> Compilen van java bestanden
4. `npm run grun`       --> Om te bevestigen dat TestRig werkt
5. `npm run grun-gui`   --> Om antlr te debuggen

### Stappenplan uitvoeren van testbestand
1. Maak een nieuwe configuration aan in Intellij
2. Selecteer 'Application'
3. Selecteer app.BasicJavaApp als start class
4. Kijk na of de working directory de compiler directory is
5. Geef de configuration een naam
6. Selecteer de jdk: openjdk-21 werkt

Optioneel:
7. Het is mogelijk om een parameter mee te geven met daarin de locatie van het test bestand. (Een default test bestand zal geselecteerd worden indien je geen parameter mee geeft) --> Bij 'program arguments' moet je dan 'File prompt' selecteren


## Opgelet!
- Een methode/functie moet gedeclareerd worden vooraleer het opgeroepen kan worden