package com.kivojenko.plugin.fasta.language;

import com.intellij.lang.Language;

public class FastaLanguage extends Language {
    public static final FastaLanguage INSTANCE = new FastaLanguage();

    private FastaLanguage() {
        super("FASTA");
    }
}
