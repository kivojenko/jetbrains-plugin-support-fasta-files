package com.kivojenko.plugin.fasta.actions;

import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.transcription.TranscriptionEngine;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TranslateToProteinIntention extends FastaIntention {

    private static final TranscriptionEngine STD = new TranscriptionEngine.Builder().build();

    @NotNull
    @Override
    public String getText() {
        return "Translate DNA to Protein";
    }


    public TranslateToProteinIntention() {
        super(List.of(FastaTokenTypes.DNA, FastaTokenTypes.RNA));
    }


    @Override
    public String handleSequence(String sequence) {
        return translateStandard(sequence.toUpperCase().replace("U", "T"));
    }

    public static String translateStandard(String dna) {
        return translate(dna, 0, true, STD);
    }


    public static String translate(String dna, int frame, boolean trimAtStop, TranscriptionEngine engine) {
        String clean = dna.replaceAll("[^ACGTN]", "");
        if (frame < 0 || frame > 2) throw new IllegalArgumentException("frame must be 0,1,2");
        if (clean.length() - frame < 3) return "";
        try {
            DNASequence dnaSeq = new DNASequence(clean.substring(frame));
            ProteinSequence prot = dnaSeq.getRNASequence(engine).getProteinSequence(engine);
            String aa = prot.getSequenceAsString();
            return trimAtStop ? aa.replaceFirst("\\*$", "") : aa;
        } catch (Exception e) {
            throw new RuntimeException("Translation failed", e);
        }
    }

}
