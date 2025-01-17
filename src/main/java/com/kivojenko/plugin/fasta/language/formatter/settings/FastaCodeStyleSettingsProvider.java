package com.kivojenko.plugin.fasta.language.formatter.settings;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.*;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FastaCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
    @Override
    public CustomCodeStyleSettings createCustomSettings(@NotNull CodeStyleSettings settings) {
        return new FastaCodeStyleSettings(settings);
    }

    @Nullable
    @Override
    public Language getLanguage() {
        return FastaLanguage.INSTANCE;
    }

    @Override
    public @NotNull DisplayPriority getPriority() {
        return DisplayPriority.COMMON_SETTINGS;
    }

    @Override
    public @NotNull String getConfigurableDisplayName() {
        return "FASTA Style";
    }

    @NotNull
    public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings,
                                                    @NotNull CodeStyleSettings modelSettings) {
        return new CodeStyleAbstractConfigurable(settings, modelSettings, this.getConfigurableDisplayName()) {
            @Override
            protected @NotNull CodeStyleAbstractPanel createPanel(@NotNull CodeStyleSettings settings) {
                return new FastaStyleMainPanel(getCurrentSettings(), settings);
            }
        };
    }

    private static class FastaStyleMainPanel extends TabbedLanguageCodeStylePanel {
        public FastaStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
            super(FastaLanguage.INSTANCE, currentSettings, settings);
        }

    }

}
