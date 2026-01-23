package com.kivojenko.plugin.fasta.language.formatter.settings;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.*;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.NotNull;

final class FastaLanguageStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    @NotNull
    @Override
    public Language getLanguage() {
        return FastaLanguage.INSTANCE;
    }


    @Override
    protected void customizeDefaults(@NotNull CommonCodeStyleSettings commonSettings, @NotNull CommonCodeStyleSettings.IndentOptions indentOptions) {
        try {
            commonSettings.RIGHT_MARGIN = 80;
            commonSettings.WRAP_ON_TYPING = CommonCodeStyleSettings.WrapOnTyping.NO_WRAP.intValue;
        } catch (NoSuchFieldError ignored) {
        }
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        consumer.showCustomOption(FastaCodeStyleSettings.class, "SPACE_AFTER_START", "Space after '>'", null);
//        consumer.showCustomOption(FastaCodeStyleSettings.class, "BLANK_LINE_BETWEEN_SEQUENCES", "Blank line between sequences", null);
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

    @Override
    public @NotNull CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings baseSettings,
                                                             @NotNull CodeStyleSettings modelSettings) {
        return new CodeStyleAbstractConfigurable(baseSettings, modelSettings, "FASTA") {
            @Override
            protected @NotNull CodeStyleAbstractPanel createPanel(@NotNull CodeStyleSettings settings) {
                return new FastaCodeStyleSettingsPanel(settings);
            }
        };
    }

    @Override
    public CustomCodeStyleSettings createCustomSettings(@NotNull CodeStyleSettings settings) {
        return new FastaCodeStyleSettings(settings);
    }
}