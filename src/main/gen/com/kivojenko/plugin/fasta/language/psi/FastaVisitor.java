// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class FastaVisitor extends PsiElementVisitor {

  public void visitBody(@NotNull FastaBody o) {
    visitPsiElement(o);
  }

  public void visitComment(@NotNull FastaComment o) {
    visitPsiElement(o);
  }

  public void visitHeader(@NotNull FastaHeader o) {
    visitPsiElement(o);
  }

  public void visitSequence(@NotNull FastaSequence o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
