package com.kivojenko.plugin.fasta.model;

import lombok.SneakyThrows;

import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.RNA;


public class RnaSequence extends NucleicAcidSequence {
    @SneakyThrows
    public RnaSequence(String sequence) {
        super(sequence, RNA);
        bioJavaSequence = new org.biojava.nbio.core.sequence.RNASequence(sequence);
    }

    public String getCompoundLabel() {
        return useLongName ? "nucleotides" : "nt";
    }
}
