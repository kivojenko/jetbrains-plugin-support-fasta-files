package com.kivojenko.plugin.fasta.language.inspector.visionPlaceholders;

import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind;
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering;
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FastaGcContentVisionProvider implements DaemonBoundCodeVisionProvider {
    @Override
    public @NotNull String getId() {
        return "fasta.vision.gc";
    }

    @Override
    public @NotNull String getName() {
        return "FASTA GC content";
    }

    @Override
    public @NotNull CodeVisionAnchorKind getDefaultAnchor() {
        return CodeVisionAnchorKind.Top;
    }

    @Override
    public @NotNull List<CodeVisionRelativeOrdering> getRelativeOrderings() {
        return List.of();
    }
}