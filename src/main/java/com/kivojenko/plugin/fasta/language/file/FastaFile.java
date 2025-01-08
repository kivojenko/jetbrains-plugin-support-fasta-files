package com.kivojenko.plugin.fasta.language.file;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.NotNull;

public class FastaFile extends PsiFileBase {


    public FastaFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, FastaLanguage.INSTANCE);
    }

    @Override
    @NotNull
    public String toString() {
        return "FASTA File";
    }

    @Override
    public @NotNull FileType getFileType() {
        return FastaFileType.INSTANCE;
    }

}
