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
%state HEADER_STATE BODY_STATE

START = ">"
DESCRIPTION = [^\n\r]+
VALUE = ([A-z]+[\t\n\r]*)*[A-z*]+
LINE_TERMINATOR = \r|\n|\r\n
BAD_CHARACTER = .

%%

<YYINITIAL> {
 {LINE_TERMINATOR} | [ \t\f] {
          return WHITE_SPACE;
      }

  {START} {
    yybegin(HEADER_STATE);
    return START;
  }

  . {
    return BAD_CHARACTER;
  }
}

<HEADER_STATE> {
    {START} {
        return START;
      }

  {DESCRIPTION} {
      return DESCRIPTION;
    }

   {LINE_TERMINATOR} {
          yybegin(BODY_STATE);
          return WHITE_SPACE;
      }

  [ \t\f] {
      return WHITE_SPACE;
      }

   . {
      return BAD_CHARACTER;
    }

}

<BODY_STATE> {
  {VALUE} {
        return VALUE;
      }

 {LINE_TERMINATOR} | [ \t\f] {
          yybegin(YYINITIAL);
          return WHITE_SPACE;
      }

  {START} {
    yybegin(HEADER_STATE);
    return START;
  }

  . {
    return BAD_CHARACTER;
  }
}