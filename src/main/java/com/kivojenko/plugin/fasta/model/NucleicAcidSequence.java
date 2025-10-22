package com.kivojenko.plugin.fasta.model;

import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry;
import com.intellij.psi.tree.IElementType;

import java.util.ArrayList;

public abstract class NucleicAcidSequence extends Sequence {
    protected long atu = 0;
    protected long gc = 0;

    public NucleicAcidSequence(String sequence, IElementType type) {
        super(sequence, type);
    }

    public void calculateProportions() {
        for (char c : sequence.toCharArray()) {
            switch (c) {
                case 'G':
                case 'C':
                    gc++;
                    break;
                case 'A':
                case 'T':
                case 'U':
                    atu++;
                    break;
                default:
                    ambiguous++;
                    break;
            }
        }
    }

    public ArrayList<TextCodeVisionEntry> getEntries() {
        var entries = super.getEntries();

        var gcPercent = getGcPercent();
        if (gcPercent > 0) {
            var gcLabel = formatLabel("GC", gc, gcPercent);
            var gcEntry = entry(".gc", gcLabel);
            entries.add(gcEntry);
        }

        return entries;
    }

    public double getGcPercent() {
        if (gc + atu == 0) return 0;
        return gc * 100. / (gc + atu);
    }

}
