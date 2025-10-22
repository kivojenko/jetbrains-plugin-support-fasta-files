package com.kivojenko.plugin.fasta.model;

import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry;
import lombok.SneakyThrows;
import org.biojava.nbio.core.sequence.template.Compound;

import java.util.ArrayList;

import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.PROTEIN;
import static com.kivojenko.plugin.fasta.language.FastaUtil.PROTEIN_AMBIGUOUS;

public class ProteinSequence extends Sequence {
    @SneakyThrows
    public ProteinSequence(String sequence) {
        super(sequence, PROTEIN);
        bioJavaSequence = new org.biojava.nbio.core.sequence.ProteinSequence(sequence);
    }

    public void calculateProportions() {
        ambiguous = sequence.chars().filter(ch -> PROTEIN_AMBIGUOUS.contains((char) ch)).count();
    }

    public void calculateWeight() {
        bioJavaSequence.forEach((Compound c) -> weightDaltons += c.getMolecularWeight() != null ? c.getMolecularWeight() : 0.0);
        weightDaltons -= (bioJavaSequence.getLength() - 1) * 18.01524;
    }

    public ArrayList<TextCodeVisionEntry> getEntries() {
        var entries = super.getEntries();

        if (weightDaltons > 0) {
            var weightLabel = "Molecular weight: " + getMolecularWeightLabel();
            var weightEntry = entry(".weight", weightLabel);
            entries.add(weightEntry);
        }

        return entries;
    }

    private String getMolecularWeightLabel() {
        if (weightDaltons < 1_000) return String.format("%.2f Da", weightDaltons);
        else if (weightDaltons < 1_000_000) return String.format("%.2f kDa", weightDaltons / 1_000);
        else if (weightDaltons < 1_000_000_000) return String.format("%.2f MDa", weightDaltons / 1_000_000);
        else return String.format("%.2f GDa", weightDaltons / 1_000_000_000);
    }

    public String getCompoundLabel() {
        return useLongName ? "amino acids" : "aa";
    }
}
