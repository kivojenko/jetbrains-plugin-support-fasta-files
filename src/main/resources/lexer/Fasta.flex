package com.kivojenko.plugin.fasta.lexer;

import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.kivojenko.plugin.fasta.language.FastaTokenTypes.*;

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
%state HEADER BODY

START = ">"
DESCRIPTION = [^\n\r]+
VALUE = ([A-z]+[\t\n\r])*[A-z*]+
WHITE_SPACE = [ \t\n\r]+

%%

<YYINITIAL> {
  {START} {
    yybegin(HEADER);
    return START;
  }

 {WHITE_SPACE} {
          return WHITE_SPACE;
      }

  . {
    return BAD_CHARACTER;
  }
}

<HEADER> {
  {DESCRIPTION} {
      yybegin(BODY);
      return DESCRIPTION;
    }

 {WHITE_SPACE} {
          return WHITE_SPACE;
      }

}

<BODY> {
  {VALUE} {
        return VALUE;
      }

 {WHITE_SPACE} {
          return WHITE_SPACE;
      }

  {START} {
    yybegin(HEADER);
    return START;
  }

  . {
    return BAD_CHARACTER;
  }
}