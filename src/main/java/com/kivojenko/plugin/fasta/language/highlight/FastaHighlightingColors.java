package com.kivojenko.plugin.fasta.language.highlight;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;

import java.awt.*;


public class FastaHighlightingColors {
    private static boolean isDarkTheme() {
        return EditorColorsManager.getInstance().isDarkEditor();
    }

    public static final TextAttributesKey START = TextAttributesKey.createTextAttributesKey(
            "FASTA_START",
            DefaultLanguageHighlighterColors.DOC_COMMENT
    );

    public static final TextAttributesKey DESCRIPTION = TextAttributesKey.createTextAttributesKey(
            "FASTA_HEADER",
            DefaultLanguageHighlighterColors.DOC_COMMENT_TAG_VALUE
    );

    public static TextAttributesKey getProteinHighlightingKey() {
        return TextAttributesKey.createTextAttributesKey(
                "FASTA_PROTEIN",
                isDarkTheme()
                        ? TextAttributesKey.createTextAttributesKey("FASTA_PROTEIN_DARK", new TextAttributes(null, Color.decode("#403727"), null, null, Font.PLAIN))
                        : TextAttributesKey.createTextAttributesKey("FASTA_PROTEIN_LIGHT", new TextAttributes(null, Color.decode("#fffcf7"), null, null, Font.PLAIN))

        );
    }

    public static TextAttributesKey getDNAHighlightingKey() {
        return TextAttributesKey.createTextAttributesKey(
                "FASTA_DNA",
                isDarkTheme()
                        ? TextAttributesKey.createTextAttributesKey("FASTA_DNA_DARK", new TextAttributes(null, Color.decode("#43374a"), null, null, Font.PLAIN))
                        : TextAttributesKey.createTextAttributesKey("FASTA_DNA_LIGHT", new TextAttributes(null, Color.decode("#faf2ff"), null, null, Font.PLAIN))

        );
    }

    public static TextAttributesKey getRNAHighlightingKey() {
        return TextAttributesKey.createTextAttributesKey(
                "FASTA_RNA",
                isDarkTheme()
                        ? TextAttributesKey.createTextAttributesKey("FASTA_RNA_DARK", new TextAttributes(null, Color.decode("#253328"), null, null, Font.PLAIN))
                        : TextAttributesKey.createTextAttributesKey("FASTA_RNA_LIGHT", new TextAttributes(null, Color.decode("#f5fff7"), null, null, Font.PLAIN))

        );
    }


}
