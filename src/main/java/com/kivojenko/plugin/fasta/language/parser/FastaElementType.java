package com.kivojenko.plugin.fasta.language.parser;

import com.intellij.psi.tree.IElementType;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FastaElementType extends IElementType {

    public FastaElementType(@NotNull @NonNls String debugName) {
        super(debugName, FastaLanguage.INSTANCE);
    }

}