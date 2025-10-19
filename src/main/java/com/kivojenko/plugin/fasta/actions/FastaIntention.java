package com.kivojenko.plugin.fasta.actions;

import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.kivojenko.plugin.fasta.language.psi.impl.FastaElementFactory;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Set;

public abstract class FastaIntention extends PsiElementBaseIntentionAction implements IntentionAction {
    private final Set<IElementType> availableTypes;

    @NotNull
    @Override
    public String getFamilyName() {
        return "FASTA intentions";
    }

    protected FastaIntention(Collection<IElementType> availableTypes) {
        this.availableTypes = Set.copyOf(availableTypes);
    }

    public abstract String handleSequence(String sequence);

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, @NotNull PsiElement element) {
        if (!(element instanceof LeafPsiElement leaf)) return false;
        return availableTypes.contains(leaf.getElementType());
    }

    @Override
    public void invoke(@NotNull Project project, Editor editor, @NotNull PsiElement element) {
        String sequence = element.getText().replaceAll("\\s+", "");
        String newSequence = handleSequence(sequence);

        WriteCommandAction.runWriteCommandAction(project, () -> {
            PsiElement newElement = FastaElementFactory.createValueElement(project, newSequence);
            element.replace(newElement);
        });
    }

}
