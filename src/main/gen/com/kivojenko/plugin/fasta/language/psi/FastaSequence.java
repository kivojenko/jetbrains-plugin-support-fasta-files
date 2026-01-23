// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FastaSequence extends PsiElement {

  @Nullable
  FastaBody getBody();

  @NotNull
  FastaHeader getHeader();

  ItemPresentation getPresentation();

}
