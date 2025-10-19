package com.kivojenko.plugin.fasta.actions;

import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.RNASequence;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GetReverseComplementIntention extends FastaIntention {
    @NotNull
    @Override
    public String getText() {
        return "Get reverse complement";
    }

    public GetReverseComplementIntention() {
        super(List.of(FastaTokenTypes.DNA, FastaTokenTypes.RNA));
    }

    @Override
    public String handleSequence(String sequence) {
        String clean = sequence.trim().toUpperCase().replaceAll("[^ACGTNU]", "");
        if (clean.isEmpty()) return "";

        boolean isRna = clean.contains("U");
        try {
            if (isRna) {
                RNASequence rna = new RNASequence(clean);
                return rna.getReverseComplement().getSequenceAsString();
            } else {
                DNASequence dna = new DNASequence(clean);
                return dna.getReverseComplement().getSequenceAsString();
            }
        } catch (Exception e) {
            throw new RuntimeException("Reverse complement failed", e);
        }
    }
}
