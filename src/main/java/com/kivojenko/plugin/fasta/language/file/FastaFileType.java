package com.kivojenko.plugin.fasta.language.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.kivojenko.plugin.fasta.FastaIcons;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FastaFileType extends LanguageFileType {
    public static final FastaFileType INSTANCE = new FastaFileType();
    public static final IFileElementType FILE = new IFileElementType(FastaLanguage.INSTANCE);


    private FastaFileType() {
        super(FastaLanguage.INSTANCE);
    }

    @Override
    @NotNull
    public String getName() {
        return "FASTA File";
    }

    @NotNull
    public PsiFile createPsiFile(@NotNull FileViewProvider viewProvider) {
        return new FastaFile(viewProvider);
    }


    @Override
    @NotNull
    public String getDescription() {
        return "FASTA file format for representing nucleotide sequences or peptide sequences";
    }

    @Override
    @NotNull
    public String getDefaultExtension() {
        return "fasta";
    }

    @Override
    @Nullable
    public Icon getIcon() {
        return FastaIcons.FILE;
    }
}


