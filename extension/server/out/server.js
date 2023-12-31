"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
const node_1 = require("vscode-languageserver/node");
const vscode_languageserver_textdocument_1 = require("vscode-languageserver-textdocument");
// Create a connection for the server, using Node's IPC as a transport.
// Also include all preview / proposed LSP features.
const connection = (0, node_1.createConnection)(node_1.ProposedFeatures.all);
// Create a simple text document manager.
const documents = new node_1.TextDocuments(vscode_languageserver_textdocument_1.TextDocument);
let hasConfigurationCapability = false;
let hasWorkspaceFolderCapability = false;
let hasDiagnosticRelatedInformationCapability = false;
connection.onInitialize((params) => {
    const capabilities = params.capabilities;
    // Does the client support the `workspace/configuration` request?
    // If not, we fall back using global settings.
    hasConfigurationCapability = !!(capabilities.workspace && !!capabilities.workspace.configuration);
    hasWorkspaceFolderCapability = !!(capabilities.workspace && !!capabilities.workspace.workspaceFolders);
    hasDiagnosticRelatedInformationCapability = !!(capabilities.textDocument &&
        capabilities.textDocument.publishDiagnostics &&
        capabilities.textDocument.publishDiagnostics.relatedInformation);
    const result = {
        capabilities: {
            textDocumentSync: node_1.TextDocumentSyncKind.Incremental,
            // Tell the client that this server supports code completion.
            completionProvider: {
                resolveProvider: true
            }
        }
    };
    if (hasWorkspaceFolderCapability) {
        result.capabilities.workspace = {
            workspaceFolders: {
                supported: true
            }
        };
    }
    return result;
});
connection.onInitialized(() => {
    if (hasConfigurationCapability) {
        // Register for all configuration changes.
        connection.client.register(node_1.DidChangeConfigurationNotification.type, undefined);
    }
    if (hasWorkspaceFolderCapability) {
        connection.workspace.onDidChangeWorkspaceFolders(_event => {
            connection.console.log('Workspace folder change event received.');
        });
    }
});
// The global settings, used when the `workspace/configuration` request is not supported by the client.
// Please note that this is not the case when using this server with the client provided in this example
// but could happen with other clients.
const defaultSettings = { maxNumberOfProblems: 1000 };
let globalSettings = defaultSettings;
// Cache the settings of all open documents
const documentSettings = new Map();
connection.onDidChangeConfiguration(change => {
    if (hasConfigurationCapability) {
        // Reset all cached document settings
        documentSettings.clear();
    }
    else {
        globalSettings = ((change.settings.languageServerExample || defaultSettings));
    }
    // Revalidate all open text documents
    documents.all().forEach(validateTextDocument);
});
function getDocumentSettings(resource) {
    if (!hasConfigurationCapability) {
        return Promise.resolve(globalSettings);
    }
    let result = documentSettings.get(resource);
    if (!result) {
        result = connection.workspace.getConfiguration({
            scopeUri: resource,
            section: 'languageServerExample'
        });
        documentSettings.set(resource, result);
    }
    return result;
}
// Only keep settings for open documents
documents.onDidClose(e => {
    documentSettings.delete(e.document.uri);
});
// The content of a text document has changed. This event is emitted
// when the text document first opened or when its content has changed.
documents.onDidChangeContent(change => {
    validateTextDocument(change.document);
});
async function validateTextDocument(textDocument) {
    // In this simple example we get the settings for every validate run.
    const settings = await getDocumentSettings(textDocument.uri);
    // The validator creates diagnostics for all uppercase words length 2 and more
    const text = textDocument.getText();
    // Remove newlines and leading spaces
    const textWithoutNewlines = text.replace(/\r\n\s*/g, '\n');
    const patternCheckData = [
        { regex: /\b[A-Z]{2,}\b/g, level: node_1.DiagnosticSeverity.Warning, message: '# is all uppercase!' }, // all capitals pattern
        { regex: /^(\r\n)*(.*[^;\s{}])$/gm, level: node_1.DiagnosticSeverity.Error, message: 'Line must end with ; for: #' }, // all lines must end with ;
    ];
    const patterns = {
        patternChecks: patternCheckData,
    };
    const diagnostics = [];
    for (let arrayIndex = 0; patternCheckData.length > arrayIndex; arrayIndex++) {
        let m;
        let problems = 0;
        // Reset the lastIndex property of the regular expression
        patternCheckData[arrayIndex].regex.lastIndex = 0;
        while ((m = patternCheckData[arrayIndex].regex.exec(text)) && problems < settings.maxNumberOfProblems) {
            problems++;
            const newLine = '\n';
            const lastIndexOf = text.lastIndexOf(newLine, m.index);
            const lineNumber = text.substr(0, m.index).split(newLine).length;
            const characterPosition = Math.max(0, m.index - (lastIndexOf < 0 ? 0 : lastIndexOf + (newLine.length * 2)));
            const diagnostic = {
                severity: patternCheckData[arrayIndex].level,
                range: {
                    start: { line: lineNumber - 1, character: characterPosition },
                    end: { line: lineNumber - 1, character: characterPosition + m[0].length },
                },
                message: patternCheckData[arrayIndex].message.replace('#', `"${m[0]}"`),
                source: 'ex',
            };
            diagnostics.push(diagnostic);
        }
    }
    // Send the computed diagnostics to VSCode.
    connection.sendDiagnostics({ uri: textDocument.uri, diagnostics });
}
connection.onDidChangeWatchedFiles(_change => {
    // Monitored files have change in VSCode
    connection.console.log('We received a file change event');
});
// This handler provides the initial list of the completion items.
connection.onCompletion((_textDocumentPosition) => {
    // The pass parameter contains the position of the text document in
    // which code complete got requested. For the example we ignore this
    // info and always provide the same completion items.
    return [
        {
            label: 'TypeScript',
            kind: node_1.CompletionItemKind.Text,
            detail: 'Just text that is used a lot',
            data: 1
        },
        {
            label: 'JavaScript',
            kind: node_1.CompletionItemKind.Text,
            detail: 'Just text that is used a lot.',
            data: 2
        },
        {
            label: 'public',
            kind: node_1.CompletionItemKind.Keyword,
            detail: 'A literal that is commonly used.',
            data: 3
        },
        {
            label: 'double',
            kind: node_1.CompletionItemKind.TypeParameter,
            detail: 'Can be used to save numbers with decimals.',
            data: 4
        },
        {
            label: 'int',
            kind: node_1.CompletionItemKind.TypeParameter,
            detail: 'Can be used to save number without decimals.',
            data: 5
        },
        {
            label: 'een',
            kind: node_1.CompletionItemKind.TypeParameter,
            detail: 'Cannot be used for anything.',
            data: 6
        }
    ];
});
// Get the variable name by using Object.keys and finding the key with the matching value
const getKindName = (kind) => {
    const kindName = Object.keys(node_1.CompletionItemKind).find((key) => node_1.CompletionItemKind[key] === kind);
    return kindName || 'Unknown';
};
// This handler resolves additional information for the item selected in
// the completion list.
connection.onCompletionResolve((item) => {
    item.detail = item.label + ' is a ' + getKindName(item.kind);
    item.documentation = item.label + ' details:\n' + item.detail;
    return item;
});
// Make the text document manager listen on the connection
// for open, change and close text document events
documents.listen(connection);
// Listen on the connection
connection.listen();
//# sourceMappingURL=server.js.map