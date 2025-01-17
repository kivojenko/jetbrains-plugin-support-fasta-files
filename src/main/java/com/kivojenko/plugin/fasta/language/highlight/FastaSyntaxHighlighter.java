package com.kivojenko.plugin.fasta.language.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import com.kivojenko.plugin.fasta.language.lexer.FastaLexer;
import org.jetbrains.annotations.NotNull;

public class FastaSyntaxHighlighter extends SyntaxHighlighterBase {
    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new FastaLexer(); // Custom lexer for FASTA
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(FastaTokenTypes.DESCRIPTION)) {
            return new TextAttributesKey[]{FastaHighlightingColors.DESCRIPTION};
        } else if (tokenType.equals(FastaTokenTypes.PROTEIN)) {
            return new TextAttributesKey[]{FastaHighlightingColors.PROTEIN};
        } else if (tokenType.equals(FastaTokenTypes.DNA)) {
            return new TextAttributesKey[]{FastaHighlightingColors.DNA};
        } else if (tokenType.equals(FastaTokenTypes.RNA)) {
            return new TextAttributesKey[]{FastaHighlightingColors.RNA};
        } else if (tokenType.equals(FastaTokenTypes.START)) {
            return new TextAttributesKey[]{FastaHighlightingColors.START};
        }
        return TextAttributesKey.EMPTY_ARRAY;
    }
}
