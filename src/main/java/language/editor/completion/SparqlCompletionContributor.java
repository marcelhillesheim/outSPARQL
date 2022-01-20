package language.editor.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import language.psi.impl.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SparqlCompletionContributor extends CompletionContributor {

    public SparqlCompletionContributor() {

        // Completions for triples inside of WHERE clauses
        extend(CompletionType.SMART, PlatformPatterns.psiElement(),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        new LiveAutoCompletion(parameters, resultSet);
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement elementBeforeCaret = parameters.getOriginalFile().findElementAt(parameters.getOffset()-1);

                        // if there is nothing in front of the caret, prologue is either ahead or can be initialized
                        // check if element before caret is part of the prologue --> suggestions are extending an existing prologue
                        if (
                                elementBeforeCaret == null ||
                                PsiTreeUtil.prevVisibleLeaf(elementBeforeCaret) == null ||
                                PsiTreeUtil.getParentOfType(PsiTreeUtil.prevVisibleLeaf(elementBeforeCaret),SparqlPrologueImpl.class) != null
                        ) {
                            resultSet.addElement(LookupElementBuilder.create("PREFIX"));
                            resultSet.addElement(LookupElementBuilder.create("BASE"));
                        }

                        // suggestions for query types
                        if (
                                // empty file
                                parameters.getOriginalFile().getText().isBlank() ||
                                (
                                elementBeforeCaret != null &&
                                // check if not inside Prologue
                                PsiTreeUtil.getParentOfType(elementBeforeCaret, SparqlPrologueImpl.class) == null &&
                                // check if not in front of Prologue
                                PsiTreeUtil.getParentOfType(
                                        PsiTreeUtil.nextVisibleLeaf(elementBeforeCaret), SparqlPrologueImpl.class
                                ) == null &&
                                // check if file has already a query clause
                                PsiTreeUtil.findChildOfAnyType(parameters.getOriginalFile(),
                                        SparqlSelectQueryImpl.class,
                                        SparqlAskQueryImpl.class,
                                        SparqlConstructQueryImpl.class,
                                        SparqlDescribeQueryImpl.class,
                                        SparqlUpdate1Impl.class
                                ) == null
                                )
                        ){
                            String[] queryClauseKW = {"SELECT", "ASK", "CONSTRUCT", "DESCRIBE"};
                            String[] updateKW = {"LOAD", "CLEAR", "DROP", "ADD", "MOVE", "COPY", "CREATE", "WITH"};

                            resultSet.addAllElements(
                                    Arrays.stream(queryClauseKW).map(LookupElementBuilder::create).collect(Collectors.toList())
                            );
                            resultSet.addAllElements(
                                    Arrays.stream(updateKW).map(LookupElementBuilder::create).collect(Collectors.toList())
                            );
                        }
                    }
                }
        );

    }

}