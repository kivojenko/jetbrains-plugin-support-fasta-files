package com.kivojenko.plugin.fasta.language.inspector.visionPlaceholders;

import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind;
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering;
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FastaMolecularWeightVisionProvider implements DaemonBoundCodeVisionProvider {
    @Override
    public @NotNull String getId() {
        return "fasta.vision.weight";
    }

    @Override
    public @NotNull String getName() {
        return "FASTA Molecular Weight";
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