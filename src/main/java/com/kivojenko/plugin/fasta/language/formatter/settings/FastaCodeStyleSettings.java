package com.kivojenko.plugin.fasta.language.formatter.settings;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FastaCodeStyleSettings extends CustomCodeStyleSettings {
    public boolean BLANK_LINE_BETWEEN_SEQUENCES = true;
    public boolean SPACE_AFTER_START = false;

    protected FastaCodeStyleSettings(CodeStyleSettings settings) {
        super("FastaCodeStyleSettings", settings);
    }
}
