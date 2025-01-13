package com.kivojenko.plugin.fasta.language.formatter;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import org.jetbrains.annotations.NotNull;

final class FastaFormattingModelBuilder implements FormattingModelBuilder {
    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, FastaLanguage.INSTANCE)
                .after(FastaTokenTypes.SEQUENCE)
                .blankLines(settings.getCommonSettings(FastaLanguage.INSTANCE.getID()).BLANK_LINES_AFTER_PACKAGE);
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        var file = formattingContext.getContainingFile();
        var wrap = Wrap.createWrap(WrapType.NORMAL, false);
        var alignment = Alignment.createAlignment();
        var builder = createSpaceBuilder(codeStyleSettings);
        var block = new FastaBlock(formattingContext.getNode(), wrap, alignment, builder);
        return FormattingModelProvider.createFormattingModelForPsiFile(file, block, codeStyleSettings);
    }
}