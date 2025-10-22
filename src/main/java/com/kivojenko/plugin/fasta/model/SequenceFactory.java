package com.kivojenko.plugin.fasta.model;


import com.intellij.psi.tree.IElementType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.*;

public class SequenceFactory {
    private static final Map<IElementType, Function<String, Sequence>> creators = new HashMap<>();

    static {
        creators.put(DNA, DnaSequence::new);
        creators.put(RNA, RnaSequence::new);
        creators.put(PROTEIN, ProteinSequence::new);
    }

    public static Sequence create(IElementType type, String seq) {
        var creator = creators.get(type);
        if (creator == null)
            throw new IllegalArgumentException("Unsupported sequence type: " + type);
        seq = seq.toUpperCase().replaceAll("\n", "").trim();
        return creator.apply(seq.trim());
    }
}
