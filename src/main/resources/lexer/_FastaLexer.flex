package lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.kivojenko.plugin.fasta.FastaTokenTypes.*;

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

EOL=\R
WHITE_SPACE=\s+

HEADER_CONTENT=[^\n\r]+[a-zA-Z_0-9]
SEQUENCE_CONTENT=([A-z]+\n)*[A-z*]+

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  ">"                      { return HEADER_START; }
  "WHITE_SPACE"            { return WHITE_SPACE; }

  {HEADER_CONTENT}         { return HEADER_CONTENT; }
  {SEQUENCE_CONTENT}       { return SEQUENCE_CONTENT; }

}

[^] { return BAD_CHARACTER; }
