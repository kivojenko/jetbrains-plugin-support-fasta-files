package com.kivojenko.plugin.fasta.model;

import lombok.SneakyThrows;
import org.biojava.nbio.core.sequence.template.AbstractSequence;

import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.DNA;

public class DnaSequence extends NucleicAcidSequence {
  public DnaSequence(String sequence) {
    super(sequence, DNA);
  }

  @SneakyThrows
  @Override
  protected AbstractSequence<?> generateBioJavaSequence() {
    return new org.biojava.nbio.core.sequence.DNASequence(sequence);
  }

  public String getCompoundLabel() {
    return useLongName ? "base pairs" : "bp";
  }
}
