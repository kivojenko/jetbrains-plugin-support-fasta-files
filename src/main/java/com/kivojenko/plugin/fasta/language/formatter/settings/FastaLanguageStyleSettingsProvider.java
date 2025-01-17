package com.kivojenko.plugin.fasta.language.formatter.settings;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider.SettingsType.*;

final class FastaLanguageStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    @NotNull
    @Override
    public Language getLanguage() {
        return FastaLanguage.INSTANCE;
    }


    @Override
    protected void customizeDefaults(@NotNull CommonCodeStyleSettings commonSettings, @NotNull CommonCodeStyleSettings.IndentOptions indentOptions) {
        try {
            commonSettings.WRAP_ON_TYPING = CommonCodeStyleSettings.WrapOnTyping.NO_WRAP.intValue;
        } catch (NoSuchFieldError ignored) {
        }
    }


    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        if (settingsType == BLANK_LINES_SETTINGS) {
            consumer.showStandardOptions("BLANK_LINES_AROUND_CLASS");
            consumer.showCustomOption(FastaCodeStyleSettings.class, "SPACE_AFTER_START", "Space after '>'", "Fasta");
            consumer.showCustomOption(FastaCodeStyleSettings.class, "BLANK_LINES_BETWEEN_SEQUENCES", "Lines between sequences", "Fasta");
        }
        if (settingsType == SPACING_SETTINGS) {
            consumer.showStandardOptions("SPACE_BEFORE_METHOD_CALL_PARENTHESES");
        }
    }

    @Override
    public String getCodeSample(@NotNull SettingsType settingsType) {
        return """
                >seq1
                AGCTGTTAG
                >gi|123456|gb|NM_001301.1| Homo sapiens ATP synthase F1 subunit alpha mRNAv
                ATGCGTACCAGT
                >BRCA1 Homo sapiens breast cancer gene 1, 185 kDa protein
                ATGCTGAAG
                >Homo sapiens chromosome 1 gene X
                ATGACGTT
                >Homo sapiens insulin receptor [PIR:Q9Y6I3] from Smith et al. 2020
                GGTCCAGGAG
                >kinase_domain_kinase_X
                GAGTCAAG
                >chromosome_3:100-200 Homo sapiens exon 7
                GCGTTCAG
                """;
    }

}