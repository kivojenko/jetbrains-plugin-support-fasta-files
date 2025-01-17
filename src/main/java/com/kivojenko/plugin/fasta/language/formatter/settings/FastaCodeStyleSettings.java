package com.kivojenko.plugin.fasta.language.formatter.settings;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class FastaCodeStyleSettings extends CustomCodeStyleSettings {
    public int LINE_WIDTH = 80;
    public int BLANK_LINES_BETWEEN_SEQUENCES = 2;
    public boolean SPACE_AFTER_START = false;

    protected FastaCodeStyleSettings(CodeStyleSettings settings) {
        super("FastaCodeStyleSettings", settings);
    }
}
