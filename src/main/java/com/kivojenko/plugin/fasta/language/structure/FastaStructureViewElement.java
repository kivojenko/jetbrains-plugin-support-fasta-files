package com.kivojenko.plugin.fasta.language.structure;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.kivojenko.plugin.fasta.language.file.FastaFile;
import com.kivojenko.plugin.fasta.language.psi.FastaSequence;
import com.kivojenko.plugin.fasta.language.psi.impl.FastaSequenceImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FastaStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

    private final NavigatablePsiElement myElement;

    public FastaStructureViewElement(NavigatablePsiElement element) {
        this.myElement = element;
    }

    @Override
    public Object getValue() {
        return myElement;
    }

    @Override
    public void navigate(boolean requestFocus) {
        myElement.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return myElement.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return myElement.canNavigateToSource();
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        return myElement.getPresentation() != null && myElement.getPresentation().getPresentableText() != null ? myElement.getPresentation().getPresentableText() : "";
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        ItemPresentation presentation = myElement.getPresentation();
        return presentation != null ? presentation : new PresentationData();
    }

    @Override
    public TreeElement @NotNull [] getChildren() {
        if (myElement instanceof FastaFile) {
            var properties = PsiTreeUtil.getChildrenOfTypeAsList(myElement, FastaSequence.class);
            var treeElements = new ArrayList<>(properties.size());
            for (var property : properties) {
                treeElements.add(new FastaStructureViewElement((FastaSequenceImpl) property));
            }
            return treeElements.toArray(new TreeElement[0]);
        }
        return EMPTY_ARRAY;
    }

}