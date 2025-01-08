package com.kivojenko.plugin.fasta.language.highlight;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;

public class FastaHighlightingColors {
    public static final TextAttributesKey START = TextAttributesKey.createTextAttributesKey(
            "FASTA_HEADER",
            DefaultLanguageHighlighterColors.DOC_COMMENT
    );

    public static final TextAttributesKey DESCRIPTION = TextAttributesKey.createTextAttributesKey(
            "FASTA_HEADER",
            DefaultLanguageHighlighterColors.STRING
    );

    public static final TextAttributesKey VALUE = TextAttributesKey.createTextAttributesKey(
            "FASTA_SEQUENCE",
            DefaultLanguageHighlighterColors.LINE_COMMENT
    );

    public static final TextAttributesKey INVALID_SEQUENCE = TextAttributesKey.createTextAttributesKey(
            "FASTA_INVALID_SEQUENCE",
            DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE
    );
}
