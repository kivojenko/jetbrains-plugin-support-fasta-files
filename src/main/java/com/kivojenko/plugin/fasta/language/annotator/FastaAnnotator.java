package com.kivojenko.plugin.fasta.language.annotator;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.kivojenko.plugin.fasta.language.FastaUtil;
import org.jetbrains.annotations.NotNull;

import static com.kivojenko.plugin.fasta.language.FastaUtil.FILE_EXTENSION;

final class FastaAnnotator implements Annotator, DumbAware {

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof PsiLiteralExpression literalExpression)) {
            return;
        }

        String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
        if (value == null || !value.endsWith(FILE_EXTENSION)) {
            return;
        }

        var sequences = FastaUtil.findSequences(element.getProject(), value);
        if (sequences.isEmpty()) {
            return;
        }

        var sequenceList = sequences.stream().map(s -> s.getHeader().getDescription().getText()).toList();
        var description = String.join("\n", sequenceList);
        holder.newAnnotation(HighlightSeverity.INFORMATION, description)
                .range(element.getTextRange())
                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                .create();
    }
}