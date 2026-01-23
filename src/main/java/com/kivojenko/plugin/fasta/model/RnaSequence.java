package com.kivojenko.plugin.fasta.model;

import lombok.SneakyThrows;
import org.biojava.nbio.core.sequence.template.AbstractSequence;

import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.RNA;

public class RnaSequence extends NucleicAcidSequence {
  public RnaSequence(String sequence) {
    super(sequence, RNA);
  }

  @SneakyThrows
  @Override
  protected AbstractSequence<?> generateBioJavaSequence() {
    return new org.biojava.nbio.core.sequence.RNASequence(sequence);
  }

  public String getCompoundLabel() {
    return useLongName ? "nucleotides" : "nt";
  }
}
