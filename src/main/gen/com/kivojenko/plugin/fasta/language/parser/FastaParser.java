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
    return FASTA(b, l + 1);
  }

  /* ********************************************************** */
  // VALUE
  public static boolean BODY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BODY")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY, "<body>");
    r = consumeToken(b, VALUE);
    exit_section_(b, l, m, r, false, FastaParser::recover_property);
    return r;
  }

  /* ********************************************************** */
  // SEQUENCE* <<eof>>
  static boolean FASTA(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FASTA")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FASTA_0(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEQUENCE*
  private static boolean FASTA_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FASTA_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SEQUENCE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FASTA_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // START DESCRIPTION
  public static boolean HEADER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HEADER")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADER, "<header>");
    r = consumeTokens(b, 0, START, DESCRIPTION);
    exit_section_(b, l, m, r, false, FastaParser::recover_property);
    return r;
  }

  /* ********************************************************** */
  // HEADER WHITE_SPACE? BODY WHITE_SPACE?
  public static boolean SEQUENCE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SEQUENCE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SEQUENCE, "<sequence>");
    r = HEADER(b, l + 1);
    r = r && SEQUENCE_1(b, l + 1);
    r = r && BODY(b, l + 1);
    r = r && SEQUENCE_3(b, l + 1);
    exit_section_(b, l, m, r, false, FastaParser::recover_property);
    return r;
  }

  // WHITE_SPACE?
  private static boolean SEQUENCE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SEQUENCE_1")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  // WHITE_SPACE?
  private static boolean SEQUENCE_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SEQUENCE_3")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  /* ********************************************************** */
  // !(WHITE_SPACE)
  static boolean recover_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, WHITE_SPACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
