package com.kivojenko.plugin.fasta.language.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.kivojenko.plugin.fasta.language.FastaUtil.HEADER_START;

final class FastaFoldingBuilder extends FoldingBuilderEx implements DumbAware {
    @NotNull
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        collectFoldableRegions(root, descriptors);
        return descriptors.toArray(FoldingDescriptor[]::new);
    }

    private void collectFoldableRegions(PsiElement element, List<FoldingDescriptor> descriptors) {
        for (PsiElement child : element.getChildren()) {
            if (isFoldableToken(child)) {
                descriptors.add(new FoldingDescriptor(
                        child.getNode(),
                        child.getTextRange()
                ));
            }
            collectFoldableRegions(child, descriptors);
        }
    }

    private boolean isFoldableToken(PsiElement element) {
        return element.getNode().getElementType().equals(FastaTokenTypes.HEADER);
    }

    @Override
    public @NotNull String getPlaceholderText(@NotNull ASTNode node) {
        return node.getPsi().getText().replace(HEADER_START, "").trim();
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return true;
    }

}