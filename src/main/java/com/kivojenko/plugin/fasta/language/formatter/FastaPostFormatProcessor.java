package com.kivojenko.plugin.fasta.language.formatter;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.impl.source.codeStyle.PostFormatProcessor;
import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import com.kivojenko.plugin.fasta.language.psi.impl.FastaElementFactory;
import com.kivojenko.plugin.fasta.language.psi.impl.FastaSequenceImpl;
import org.jetbrains.annotations.NotNull;

public class FastaPostFormatProcessor implements PostFormatProcessor {
    private static final int MAX_LINE_LENGTH = 80;

    @Override
    public @NotNull TextRange processText(@NotNull PsiFile file, @NotNull TextRange range, @NotNull CodeStyleSettings settings) {
        PsiElement[] elements = file.getChildren();
        for (PsiElement element : elements) {
            processElement(element, settings);
        }
        return range;
    }

    @Override
    public @NotNull PsiElement processElement(@NotNull PsiElement element, @NotNull CodeStyleSettings settings) {
        if (element.getNode().getElementType() == FastaTokenTypes.SEQUENCE) {
            element = ((FastaSequenceImpl) element).getBody().getValue();

            String cleanedSequence = element.getText().replaceAll("\\s+", "");
            String wrappedSequence = wrapSequence(cleanedSequence, MAX_LINE_LENGTH);
            updatePsiElementText(element, wrappedSequence);
        }
        return element;
    }


    private String wrapSequence(String sequence, int lineLength) {
        StringBuilder wrapped = new StringBuilder();
        for (int i = 0; i < sequence.length(); i += lineLength) {
            int end = Math.min(i + lineLength, sequence.length());
            wrapped.append(sequence, i, end).append("\n");
        }
        return wrapped.toString();
    }

    private void updatePsiElementText(PsiElement element, String newText) {
        element.replace(createNewLeafElement(element, newText));
    }

    private PsiElement createNewLeafElement(PsiElement element, String text) {
        return FastaElementFactory.createValueElement(element.getProject(), text);
    }
}