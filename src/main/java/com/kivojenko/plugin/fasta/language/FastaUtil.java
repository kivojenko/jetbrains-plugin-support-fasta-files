package com.kivojenko.plugin.fasta.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.kivojenko.plugin.fasta.language.file.FastaFile;
import com.kivojenko.plugin.fasta.language.file.FastaFileType;
import com.kivojenko.plugin.fasta.language.psi.FastaSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FastaUtil {
    public static final String FILE_EXTENSION = ".fasta";
    public static final String HEADER_START = ">";

    public static List<FastaSequence> findSequences(Project project, String name) {

        List<FastaSequence> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(FastaFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(file -> !name.equals(file.getName()));

        for (var virtualFile : virtualFiles) {
            FastaFile file = (FastaFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (file == null) {
                continue;
            }
            FastaSequence[] properties = PsiTreeUtil.getChildrenOfType(file, FastaSequence.class);
            if (properties == null) {
                continue;
            }
            result.addAll(Arrays.asList(properties));
        }
        return result;
    }

}
