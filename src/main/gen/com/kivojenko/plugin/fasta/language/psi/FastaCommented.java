// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FastaCommented extends PsiElement {

  @NotNull
  FastaSequence getSequence();

  @Nullable
  PsiElement getComment();

  @Nullable
  PsiElement getCommentStart();

}
