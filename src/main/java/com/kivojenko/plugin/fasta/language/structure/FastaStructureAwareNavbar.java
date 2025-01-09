package com.kivojenko.plugin.fasta.language.structure;

import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import com.kivojenko.plugin.fasta.language.FastaLanguage;
import com.kivojenko.plugin.fasta.language.psi.FastaSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

final class FastaStructureAwareNavbar extends StructureAwareNavBarModelExtension {

  @NotNull
  @Override
  protected Language getLanguage() {
    return FastaLanguage.INSTANCE;
  }

  @Override
  public @Nullable String getPresentableText(Object object) {
    if (object instanceof FastaSequence) {
      return ((FastaSequence) object).getHeader().getDescription().getText();
    }

    return null;
  }

  @Override
  @Nullable
  public Icon getIcon(Object object) {
    if (object instanceof FastaSequence) {
      return AllIcons.Nodes.Record;
    }

    return null;
  }

}