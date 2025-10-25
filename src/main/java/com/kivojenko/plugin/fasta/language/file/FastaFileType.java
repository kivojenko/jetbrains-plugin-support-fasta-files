package com.kivojenko.plugin.fasta.language.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.kivojenko.plugin.fasta.FastaIcons;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FastaFileType extends LanguageFileType {
    public static final FastaFileType INSTANCE = new FastaFileType();
    private FastaFileType() {
        super(FastaLanguage.INSTANCE);
    }

    @Override
    @NotNull
    public String getName() {
        return "FASTA File";
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


