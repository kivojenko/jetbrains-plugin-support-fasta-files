package com.kivojenko.plugin.fasta.language.lexer;

import com.intellij.lexer.FlexAdapter;
import com.kivojenko.plugin.fasta.lexer._FastaLexer;

public class FastaLexer extends FlexAdapter {
    public FastaLexer() {
        super(new _FastaLexer(null)); // Use a generated lexer if needed
    }
}