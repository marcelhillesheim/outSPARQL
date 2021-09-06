package language.editor;

import com.google.common.collect.Sets;
import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ContainerUtil;
import language.psi.SparqlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class SparqlBlock extends AbstractBlock {

    private List<Block> blocks = null;

    public static Set<IElementType> INDENT_PARENTS = Sets.newHashSet(
            SparqlTypes.GROUP_GRAPH_PATTERN,
            SparqlTypes.QUAD_DATA,
            SparqlTypes.QUAD_PATTERN,
            SparqlTypes.CONSTRUCT_TEMPLATE
    );

    private static final Set<IElementType> NO_INDENT_ELEMENT_TYPES = Sets.newHashSet(
            SparqlTypes.OP_LCURLY,
            SparqlTypes.OP_RCURLY,
            //removed for inline data / values clause
            //SparqlTypes.OP_LROUND,
            SparqlTypes.OP_RROUND,
            SparqlTypes.OP_LSQUARE,
            SparqlTypes.OP_RSQUARE
    );

    private static final Set<IElementType> SINGLE_LINE_ELEMENT_TYPES = Sets.newHashSet(
            SparqlTypes.PROLOGUE,
            SparqlTypes.PREFIX_DECL,
            SparqlTypes.BASE_DECL
    );

    public SparqlBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment) {
        super(node, wrap, alignment);
    }

    @Override
    protected List<Block> buildChildren() {
        if (blocks == null) {
            blocks = ContainerUtil.mapNotNull(myNode.getChildren(null), node -> {
                if (node.getTextLength() == 0) {
                    return null;
                }
                if (node.getElementType() == TokenType.WHITE_SPACE) {
                    return null;
                }
                return new SparqlBlock(node, null, null);
            });
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        if (NO_INDENT_ELEMENT_TYPES.contains(myNode.getElementType())) {
            return Indent.getNoneIndent();
        }
        final ASTNode treeParent = myNode.getTreeParent();
        if (treeParent != null) {
            if (INDENT_PARENTS.contains(treeParent.getElementType())) return Indent.getNormalIndent();
            // custom cases for rules with additional elements, which shouldn't have an indent
            if (treeParent.getElementType() == SparqlTypes.CONSTRUCT_QUERY &&
                myNode.getElementType() == SparqlTypes.TRIPLES_TEMPLATE
            ) return Indent.getNormalIndent();
            if (treeParent.getElementType() == SparqlTypes.QUADS_NOT_TRIPLES &&
                    myNode.getElementType() == SparqlTypes.TRIPLES_TEMPLATE
            ) return Indent.getNormalIndent();
            if (treeParent.getElementType() == SparqlTypes.INLINE_DATA_ONE_VAR &&
                    myNode.getElementType() == SparqlTypes.DATA_BLOCK_VALUE
            ) return Indent.getNormalIndent();
            if (treeParent.getElementType() == SparqlTypes.INLINE_DATA_FULL &&
                    (myNode.getElementType() == SparqlTypes.DATA_BLOCK_VALUE ||
                            myNode.getElementType() == SparqlTypes.OP_LROUND)
            ) return Indent.getNormalIndent();
        }
        return Indent.getNoneIndent();
    }

    @Nullable
    @Override
    protected Indent getChildIndent() {
        final IElementType elementType = myNode.getElementType();
        if (INDENT_PARENTS.contains(elementType)) {
            return Indent.getNormalIndent();
        }
        return Indent.getNoneIndent();
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        ASTBlock sparqlBlock1 = (ASTBlock) child1;

        if (sparqlBlock1 != null &&
                sparqlBlock1.getNode() != null &&
                SINGLE_LINE_ELEMENT_TYPES.contains(sparqlBlock1.getNode().getElementType())
        ) {
            return Spacing.createSpacing(0, 0, 1, true, 0);
        }
        return null;
    }

    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

}