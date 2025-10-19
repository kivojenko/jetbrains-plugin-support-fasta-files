package com.kivojenko.plugin.fasta.actions;

import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ReverseSequenceIntention extends FastaIntention {
    @NotNull
    @Override
    public String getText() {
        return "Reverse sequence";
    }

    public ReverseSequenceIntention() {
        super(List.of(FastaTokenTypes.PROTEIN, FastaTokenTypes.DNA, FastaTokenTypes.RNA));
    }

    @Override
    public String handleSequence(String sequence) {
        return new StringBuilder(sequence).reverse().toString();
    }
}
