package com.kivojenko.plugin.fasta.language.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import com.kivojenko.plugin.fasta.language.psi.FastaSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FastaStructureViewModel extends StructureViewModelBase implements
    StructureViewModel.ElementInfoProvider {

  public FastaStructureViewModel(@Nullable Editor editor, PsiFile psiFile) {
    super(psiFile, editor, new FastaStructureViewElement(psiFile));
  }

  @NotNull
  public Sorter @NotNull [] getSorters() {
    return new Sorter[]{Sorter.ALPHA_SORTER};
  }


  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    return false;
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    return element.getValue() instanceof FastaSequence;
  }

  @Override
  protected Class<?> @NotNull [] getSuitableClasses() {
    return new Class[]{FastaSequence.class};
  }

}