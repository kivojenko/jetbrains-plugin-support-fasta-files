// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FastaBody extends PsiElement {

  @Nullable
  PsiElement getDna();

  @Nullable
  PsiElement getProtein();

  @Nullable
  PsiElement getRna();

  PsiElement getValue();

}
