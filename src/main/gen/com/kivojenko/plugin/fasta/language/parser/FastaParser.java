// This is a generated file. Not intended for manual editing.
package com.kivojenko.plugin.fasta.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.*;
import static com.kivojenko.plugin.fasta.language.parser.FastaParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FastaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // PROTEIN | RNA | DNA
  public static boolean body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY, "<body>");
    r = consumeToken(b, PROTEIN);
    if (!r) r = consumeToken(b, RNA);
    if (!r) r = consumeToken(b, DNA);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMENT_START COMMENT_TEXT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, COMMENT_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMENT_START, COMMENT_TEXT);
    exit_section_(b, m, COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // (comment* sequence)* comment?<<eof>>
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0(b, l + 1);
    r = r && file_1(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comment* sequence)*
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_0", c)) break;
    }
    return true;
  }

  // comment* sequence
  private static boolean file_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0_0_0(b, l + 1);
    r = r && sequence(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comment*
  private static boolean file_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_0_0_0", c)) break;
    }
    return true;
  }

  // comment?
  private static boolean file_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_1")) return false;
    comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // START DESCRIPTION
  public static boolean header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header")) return false;
    if (!nextTokenIs(b, START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, START, DESCRIPTION);
    exit_section_(b, m, HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // header body?
  public static boolean sequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence")) return false;
    if (!nextTokenIs(b, START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = header(b, l + 1);
    r = r && sequence_1(b, l + 1);
    exit_section_(b, m, SEQUENCE, r);
    return r;
  }

  // body?
  private static boolean sequence_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence_1")) return false;
    body(b, l + 1);
    return true;
  }

}
