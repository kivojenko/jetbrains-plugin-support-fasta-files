package com.kivojenko.plugin.fasta.language.formatter;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import com.kivojenko.plugin.fasta.language.FastaTokenTypes;
import com.kivojenko.plugin.fasta.language.formatter.settings.FastaCodeStyleSettings;
import org.jetbrains.annotations.NotNull;

final class FastaFormattingModelBuilder implements FormattingModelBuilder {
    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        var customSettings = settings.getCustomSettings(FastaCodeStyleSettings.class);
        return new SpacingBuilder(settings, FastaLanguage.INSTANCE)
                .between(FastaTokenTypes.SEQUENCE, FastaTokenTypes.SEQUENCE)
                .none()
                .after(FastaTokenTypes.HEADER)
                .lineBreakInCode()
                .between(FastaTokenTypes.START, FastaTokenTypes.DESCRIPTION)
                .spaces(customSettings.SPACE_AFTER_START ? 1 : 0)
                .after(FastaTokenTypes.BODY)
                .blankLines(customSettings.BLANK_LINE_BETWEEN_SEQUENCES ? 1 : 0);
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        var file = formattingContext.getContainingFile();
        var wrap = Wrap.createWrap(WrapType.NONE, false);
        var alignment = Alignment.createAlignment();
        var builder = createSpaceBuilder(codeStyleSettings);
        var block = new FastaBlock(formattingContext.getNode(), wrap, alignment, builder);
        return FormattingModelProvider.createFormattingModelForPsiFile(file, block, codeStyleSettings);
    }
}