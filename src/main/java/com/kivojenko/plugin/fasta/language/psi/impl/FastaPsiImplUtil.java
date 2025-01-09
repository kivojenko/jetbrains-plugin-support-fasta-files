package com.kivojenko.plugin.fasta.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.kivojenko.plugin.fasta.language.psi.FastaSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FastaPsiImplUtil extends GeneratedParserUtilBase {


    public static String getStringValue(PsiElement element, IElementType name) {
        ASTNode keyNode = element.getNode().findChildByType(name);
        if (keyNode != null) {
            return keyNode.getText().replaceAll("\\\\ ", " ");
        }
        return null;
    }

    public static ItemPresentation getPresentation(final FastaSequence element) {
        return new ItemPresentation() {
            @Override
            public @NotNull String getPresentableText() {
                return element.getHeader().getDescription().getText().strip();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }

}
