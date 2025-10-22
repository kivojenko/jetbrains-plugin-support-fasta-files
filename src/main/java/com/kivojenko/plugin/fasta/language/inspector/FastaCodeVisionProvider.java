package com.kivojenko.plugin.fasta.language.inspector;

import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind;
import com.intellij.codeInsight.codeVision.CodeVisionEntry;
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering;
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveElementVisitor;
import com.intellij.psi.tree.IElementType;
import com.kivojenko.plugin.fasta.model.SequenceFactory;
import kotlin.Pair;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.*;

public class FastaCodeVisionProvider implements DaemonBoundCodeVisionProvider {
    private static final List<IElementType> SUPPORTED_TYPES = List.of(DNA, RNA, PROTEIN);

    @Override
    public @NotNull String getId() {
        return "fasta.vision";
    }

    @Override
    public @NotNull String getName() {
        return "FASTA Statistics";
    }

    @Override
    public @NotNull CodeVisionAnchorKind getDefaultAnchor() {
        return CodeVisionAnchorKind.Top;
    }

    @Override
    public @NotNull List<CodeVisionRelativeOrdering> getRelativeOrderings() {
        return List.of();
    }

    @Override
    public @NotNull List<Pair<TextRange, CodeVisionEntry>> computeForEditor(
            @NotNull Editor editor,
            @NotNull PsiFile file
    ) {
        List<Pair<TextRange, CodeVisionEntry>> result = new ArrayList<>();

        file.accept(new PsiRecursiveElementVisitor() {
            @SneakyThrows
            @Override
            public void visitElement(@NotNull PsiElement element) {
                super.visitElement(element);

                var node = element.getNode();
                if (node == null) return;

                var type = node.getElementType();
                if (!SUPPORTED_TYPES.contains(type)) return;

                var text = element.getText().trim();
                if (text.isEmpty()) return;

                var sequence = SequenceFactory.create(type, text);
                TextRange range = element.getTextRange();

                var entries = sequence.getEntries();
                for (var entry : entries) {
                    result.add(new Pair<>(range, entry));
                }
            }
        });
        return result;
    }
}