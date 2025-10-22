package com.kivojenko.plugin.fasta.model;

import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry;
import com.intellij.psi.tree.IElementType;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.biojava.nbio.core.sequence.template.AbstractSequence;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public abstract class Sequence {
    protected final String sequence;
    protected final IElementType type;
    protected AbstractSequence<?> bioJavaSequence;

    protected long ambiguous = 0;
    protected double weightDaltons = 0;
    protected boolean useLongName = false;

    public void calculateProportions() {
    }

    public void calculateWeight() {
    }

    public abstract String getCompoundLabel();


    public ArrayList<TextCodeVisionEntry> getEntries() {
        calculateProportions();
        calculateWeight();

        ArrayList<TextCodeVisionEntry> entries = new ArrayList<>();

        var lengthLabel = sequence.length() + " " + getCompoundLabel();
        var lengthEntry = entry(".length", lengthLabel);
        entries.add(lengthEntry);

        var ambiguousPercent = getAmbiguousPercent();
        if (ambiguousPercent > 0) {
            var ambiguousLabel = formatLabel("Ambiguous", ambiguous, ambiguousPercent);
            var ambiguousEntry = entry(".ambiguous", ambiguousLabel);
            entries.add(ambiguousEntry);
        }

        return entries;
    }

    protected String formatLabel(String prefix, Object value, double percent) {
        return "%s: %s %s (%.2f%%)".formatted(prefix, value, getCompoundLabel(), percent);
    }

    protected TextCodeVisionEntry entry(String id, String label) {
        return new TextCodeVisionEntry(label, "fasta.vision" + id, null, "", "", List.of());
    }

    public double getAmbiguousPercent() {
        return ambiguous * 100. / sequence.length();
    }
}
