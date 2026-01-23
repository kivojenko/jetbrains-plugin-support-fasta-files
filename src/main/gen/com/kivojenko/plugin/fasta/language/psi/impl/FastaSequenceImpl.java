// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElementVisitor;
import com.kivojenko.plugin.fasta.language.psi.FastaBody;
import com.kivojenko.plugin.fasta.language.psi.FastaHeader;
import com.kivojenko.plugin.fasta.language.psi.FastaSequence;
import com.kivojenko.plugin.fasta.language.psi.FastaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FastaSequenceImpl extends ASTWrapperPsiElement implements FastaSequence {

  public FastaSequenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FastaVisitor visitor) {
    visitor.visitSequence(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FastaVisitor) accept((FastaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FastaBody getBody() {
    return findChildByClass(FastaBody.class);
  }

  @Override
  @NotNull
  public FastaHeader getHeader() {
    return findNotNullChildByClass(FastaHeader.class);
  }

  @Override
  public ItemPresentation getPresentation() {
    return FastaPsiImplUtil.getPresentation(this);
  }

}
