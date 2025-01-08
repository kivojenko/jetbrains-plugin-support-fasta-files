package com.kivojenko.plugin.fasta.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import com.kivojenko.plugin.fasta.language.psi.FastaBody;
import com.kivojenko.plugin.fasta.language.psi.FastaHeader;

public class FastaPsiImplUtil extends GeneratedParserUtilBase {

    public static String getStart(FastaHeader element) {
        return getStringValue(element, FastaTokenTypes.START);
    }

    public static String getDescription(FastaHeader element) {
        return getStringValue(element, FastaTokenTypes.DESCRIPTION);
    }

    public static String getValue(FastaBody element) {
        return getStringValue(element, FastaTokenTypes.VALUE);
    }

    private static String getStringValue(PsiElement element, IElementType name) {
        ASTNode keyNode = element.getNode().findChildByType(name);
        if (keyNode != null) {
            return keyNode.getText().replaceAll("\\\\ ", " ");
        }
        return null;
    }
}
