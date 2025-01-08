// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.kivojenko.plugin.fasta.language.parser.FastaElementType;
import com.kivojenko.plugin.fasta.language.parser.FastaTokenType;
import com.kivojenko.plugin.fasta.language.psi.impl.*;

public interface FastaTokenTypes {

  IElementType BODY = new FastaElementType("BODY");
  IElementType HEADER = new FastaElementType("HEADER");
  IElementType SEQUENCE = new FastaElementType("SEQUENCE");

  IElementType DESCRIPTION = new FastaTokenType("DESCRIPTION");
  IElementType START = new FastaTokenType("START");
  IElementType VALUE = new FastaTokenType("VALUE");
  IElementType WHITE_SPACE = new FastaTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BODY) {
        return new FastaBodyImpl(node);
      }
      else if (type == HEADER) {
        return new FastaHeaderImpl(node);
      }
      else if (type == SEQUENCE) {
        return new FastaSequenceImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
