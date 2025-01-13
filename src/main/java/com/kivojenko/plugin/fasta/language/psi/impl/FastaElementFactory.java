package com.kivojenko.plugin.fasta.language.psi.impl;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import com.kivojenko.plugin.fasta.language.FastaUtil;
import com.kivojenko.plugin.fasta.language.file.FastaFile;

public class FastaElementFactory extends FastaTokenTypes.Factory {
    public static PsiElement createValueElement(Project project, String text) {
        text = FastaUtil.HEADER_START + "example_description \n" + text;
        var factory = PsiFileFactory.getInstance(project);
        var fastaFile = (FastaFile) factory.createFileFromText("dummy.fasta", FastaLanguage.INSTANCE, text);
        var sequence = (FastaSequenceImpl) fastaFile.getFirstChild().getNode().getPsi();
        return sequence.getBody().getValue();
    }
}
