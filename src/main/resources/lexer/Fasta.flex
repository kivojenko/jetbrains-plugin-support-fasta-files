package com.kivojenko.plugin.fasta.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.*;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.psi.TokenType.BAD_CHARACTER;

%%

%{
  public _FastaLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _FastaLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%state COMMENT_STATE HEADER_STATE BODY_STATE

START = ">"
COMMENT_START = ";"
DESCRIPTION = [^\s][^\n\r]+
DNA_CHARS = [ATGCN-]
RNA_CHARS = [AUGCN-]
PROTEIN_CHARS = [ACDEFGHIJKLMNPQRSTVWYBXZacdefghijklmnpqrstvwybxz-]
DNA = ({DNA_CHARS}+[\t\n\r]*)*({DNA_CHARS}|[*])+
RNA = ({RNA_CHARS}+[\t\n\r]*)*({RNA_CHARS}|[*])+
PROTEIN = ({PROTEIN_CHARS}+[\t\n\r]*)*({PROTEIN_CHARS}|[*])+
COMMENT_TEXT = (\s*[^\n\r]*)
LINE_TERMINATOR = \r|\n|\r\n
BAD_CHARACTER = .

%%

<YYINITIAL> {
 {LINE_TERMINATOR} | [ \t\f] { return WHITE_SPACE; }

  {START} {
    yybegin(HEADER_STATE);
    return START;
  }

  {COMMENT_START} {
      yybegin(COMMENT_STATE);
      return COMMENT_START;
  }

  . { return BAD_CHARACTER;}
}

<COMMENT_STATE> {
    {COMMENT_TEXT} {
        yybegin(YYINITIAL);
        return COMMENT_TEXT;
      }
    {LINE_TERMINATOR} | [ \t\f] {
      yybegin(YYINITIAL);
      return WHITE_SPACE;
    }
}

<HEADER_STATE> {
   {START} { return START; }

  {DESCRIPTION} { return DESCRIPTION; }

  {LINE_TERMINATOR} {
      yybegin(BODY_STATE);
      return WHITE_SPACE;
  }

  [ \t\f] { return WHITE_SPACE; }

  . { return BAD_CHARACTER; }

}

<BODY_STATE> {
  {RNA} { return RNA; }

  {DNA} { return DNA; }

 {PROTEIN} { return PROTEIN; }

 {LINE_TERMINATOR} | [ \t\f] {
      yybegin(YYINITIAL);
      return WHITE_SPACE;
  }

  {START} {
    yybegin(HEADER_STATE);
    return START;
  }

  {COMMENT_START} {
    yybegin(COMMENT_STATE);
    return COMMENT_START;
  }

  . { return BAD_CHARACTER; }
}