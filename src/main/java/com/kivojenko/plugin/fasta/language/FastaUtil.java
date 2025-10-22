package com.kivojenko.plugin.fasta.language;

import java.util.Set;

public class FastaUtil {
    public static final String HEADER_START = ">";
    public static final Set<Character> PROTEIN_AMBIGUOUS = Set.of('X', 'B', 'Z', 'J');
}
