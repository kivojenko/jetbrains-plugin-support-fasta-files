package com.kivojenko.plugin.fasta.language.formatter.settings;

import com.intellij.application.options.codeStyle.OptionTableWithPreviewPanel;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.Nullable;


public class FastaCodeStyleSettingsPanel extends OptionTableWithPreviewPanel {
    public FastaCodeStyleSettingsPanel(CodeStyleSettings settings) {
        super(settings);
        init();
    }

    @Override
    public LanguageCodeStyleSettingsProvider.SettingsType getSettingsType() {
        return LanguageCodeStyleSettingsProvider.SettingsType.BLANK_LINES_SETTINGS;
    }

    @Override
    protected void initTables() {
        addOption("ALIGN_GROUP_FIELD_DECLARATIONS", "Align group field declarations");
    }

    @Override
    public @Nullable Language getDefaultLanguage() {
        return FastaLanguage.INSTANCE;
    }
}