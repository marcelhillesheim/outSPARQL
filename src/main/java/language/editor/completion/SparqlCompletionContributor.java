package language.editor.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class SparqlCompletionContributor extends CompletionContributor {

    public SparqlCompletionContributor() {

        // Completions for triples inside of WHERE clauses
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        LiveAutoCompletion completion = new LiveAutoCompletion(parameters, resultSet);
                    }
                }
        );
    }

}