package com.kivojenko.plugin.fasta.language.formatter;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.impl.source.codeStyle.PostFormatProcessor;
import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import com.kivojenko.plugin.fasta.language.file.FastaFileType;
import com.kivojenko.plugin.fasta.language.formatter.settings.FastaCodeStyleSettings;
import com.kivojenko.plugin.fasta.language.psi.impl.FastaElementFactory;
import com.kivojenko.plugin.fasta.language.psi.impl.FastaSequenceImpl;
import org.jetbrains.annotations.NotNull;

public class FastaPostFormatProcessor implements PostFormatProcessor {
    private static final int MAX_LINE_LENGTH = 80;

    @Override
    public @NotNull TextRange processText(@NotNull PsiFile file, @NotNull TextRange range, @NotNull CodeStyleSettings settings) {
        if (file.getFileType() != FastaFileType.INSTANCE) {
            return TextRange.EMPTY_RANGE;
        }

        var customSettings = settings.getCustomSettings(FastaCodeStyleSettings.class);

        for (PsiElement element : file.getChildren()) {
            processElement(element, customSettings);
        }
        return range;
    }

    @Override
    public @NotNull PsiElement processElement(@NotNull PsiElement element, @NotNull CodeStyleSettings settings) {
        return processElement(element, settings.getCustomSettings(FastaCodeStyleSettings.class));
    }

    public @NotNull PsiElement processElement(@NotNull PsiElement element, @NotNull FastaCodeStyleSettings settings) {
        var type = element.getNode().getElementType();

        if (type == FastaTokenTypes.SEQUENCE && ((FastaSequenceImpl) element).getBody() != null) {
            var body = ((FastaSequenceImpl) element).getBody().getValue();

            var cleaned = body.getText().replaceAll("\\s+", "");
            var wrapped = wrapSequence(cleaned, MAX_LINE_LENGTH);

            body.replace(createNewLeafElement(element.getProject(), wrapped));
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

    private PsiElement createNewLeafElement(Project project, String text) {
        return FastaElementFactory.createValueElement(project, text);
    }
}