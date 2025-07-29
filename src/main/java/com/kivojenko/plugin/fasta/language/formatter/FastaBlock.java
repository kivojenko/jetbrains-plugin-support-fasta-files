package com.kivojenko.plugin.fasta.language.formatter;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.BlockWithParent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FastaBlock extends AbstractBlock implements BlockWithParent {
    private BlockWithParent parent;
    private final SpacingBuilder spacingBuilder;

    protected FastaBlock(@NotNull ASTNode node,
                         @Nullable Wrap wrap,
                         @Nullable Alignment alignment,
                         SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while (child != null) {
            if (child.getElementType() != TokenType.WHITE_SPACE) {
                var alignment = Alignment.createAlignment();
                var wrap = Wrap.createChildWrap(this.myWrap, WrapType.NONE, false);
                var block = new FastaBlock(child, wrap, alignment, spacingBuilder);
                blocks.add(block);
            }
            child = child.getTreeNext();
        }
        return blocks;
    }


    @Override
    public Indent getIndent() {
        return Indent.getNoneIndent();
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    @Override
    public BlockWithParent getParent() {
        return parent;
    }

    @Override
    public void setParent(BlockWithParent newParent) {
        parent = newParent;
    }

}