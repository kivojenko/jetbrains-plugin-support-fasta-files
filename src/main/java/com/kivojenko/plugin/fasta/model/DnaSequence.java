package com.kivojenko.plugin.fasta.model;

import lombok.SneakyThrows;

import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.DNA;


public class DnaSequence extends NucleicAcidSequence {
    @SneakyThrows
    public DnaSequence(String sequence) {
        super(sequence, DNA);
        bioJavaSequence = new org.biojava.nbio.core.sequence.DNASequence(sequence);
    }

    public String getCompoundLabel() {
        return useLongName ? "base pairs" : "bp";
    }
}
