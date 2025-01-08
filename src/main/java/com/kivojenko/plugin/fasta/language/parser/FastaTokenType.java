package com.kivojenko.plugin.fasta.language.parser;

import com.intellij.psi.tree.IElementType;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FastaTokenType extends IElementType {

    public FastaTokenType(@NotNull @NonNls String debugName) {
        super(debugName, FastaLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "FastaTokenType." + super.toString();
    }

}