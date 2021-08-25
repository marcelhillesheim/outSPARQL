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
            SparqlTypes.GROUP_GRAPH_PATTERN
    );

    private static final Set<IElementType> NO_INDENT_ELEMENT_TYPES = Sets.newHashSet(
            SparqlTypes.OP_LCURLY,
            SparqlTypes.OP_RCURLY,
            SparqlTypes.OP_LROUND,
            SparqlTypes.OP_RROUND,
            SparqlTypes.OP_LSQUARE,
            SparqlTypes.OP_RSQUARE
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
            if (INDENT_PARENTS.contains(treeParent.getElementType())) {
                return Indent.getNormalIndent();
            }
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
        return null;
    }

    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

}