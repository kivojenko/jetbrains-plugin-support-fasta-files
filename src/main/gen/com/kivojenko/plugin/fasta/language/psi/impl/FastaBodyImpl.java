// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.kivojenko.plugin.fasta.language.psi.*;

public class FastaBodyImpl extends ASTWrapperPsiElement implements FastaBody {

  public FastaBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FastaVisitor visitor) {
    visitor.visitBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FastaVisitor) accept((FastaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getValue() {
    return FastaPsiImplUtil.getValue(this);
  }

}
