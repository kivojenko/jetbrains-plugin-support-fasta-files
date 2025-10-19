package com.kivojenko.plugin.fasta.language.highlight.settings;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.kivojenko.plugin.fasta.FastaIcons;
import com.kivojenko.plugin.fasta.language.highlight.FastaHighlightingColors;
import com.kivojenko.plugin.fasta.language.highlight.FastaSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

final class FastaColorSettingsPage implements ColorSettingsPage {

  private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
      new AttributesDescriptor("Protein", FastaHighlightingColors.getProteinHighlightingKey()),
      new AttributesDescriptor("DNA", FastaHighlightingColors.getDNAHighlightingKey()),
      new AttributesDescriptor("RNA", FastaHighlightingColors.getRNAHighlightingKey())
  };

  @Override
  public Icon getIcon() {
    return FastaIcons.FILE;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new FastaSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return """
>DNA_Sequence
ATGCNNNNNNNNNNNNNNNNGCTAGCAGTNNNNNNNAGCTAGNNNNNNNNNNNNNNNAGCTAGNNNNNNN
>RNA_Sequence
AUGCNNNNNNNNNNNNNNNNGCUAGCAGUNNNNNNNAGCUAGNNNNNNNNNNNNNNNAGCUAGNNNNNNN
>Protein_Sequence
MFRWSKQNXXXXXXXXXXXXXXXXXXXXXLVAAKDDSSQRPQFGLNXXXX
            """;
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

  @Override
  public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @Override
  public ColorDescriptor @NotNull [] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "FASTA";
  }

}