package language.editor;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import language.psi.impl.SparqlBaseDeclImpl;
import language.psi.impl.SparqlPrefixDeclImpl;
import language.psi.impl.SparqlPrologueImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class SparqlBlock extends AbstractBlock {

    //TODO add all block elements
    //list contains all psi elements, which should have no other element within the same line
    //e.g. only one prefix declaration per line
    private final List<Class<?>> singleLineElements = Arrays.asList(
            SparqlPrologueImpl.class, SparqlPrefixDeclImpl.class, SparqlBaseDeclImpl.class
    );

    private final SpacingBuilder spacingBuilder;

    protected SparqlBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while (child != null) {
            if (child.getElementType() != TokenType.WHITE_SPACE) {
                Block block = new SparqlBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                        spacingBuilder);
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
        if (child1 instanceof ASTBlock && child2 instanceof ASTBlock) {
            final PsiElement element1 = Objects.requireNonNull(((ASTBlock) child1).getNode()).getPsi();
            final PsiElement element2 = Objects.requireNonNull(((ASTBlock) child2).getNode()).getPsi();

            // add newline before and after element
            if (singleLineElements.contains(element1.getClass()) || singleLineElements.contains(element2.getClass())) {
                return Spacing.createSpacing(0,0,1,true,0);
            }


        }

        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

}