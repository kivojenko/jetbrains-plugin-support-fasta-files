// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface FastaSequence extends PsiElement {

  @NotNull
  FastaBody getBody();

  @NotNull
  FastaHeader getHeader();

  ItemPresentation getPresentation();

}
