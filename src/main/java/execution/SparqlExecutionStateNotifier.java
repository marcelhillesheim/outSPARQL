package execution;

import com.intellij.util.messages.Topic;

public interface SparqlExecutionStateNotifier {
    Topic<SparqlExecutionStateNotifier> SPARQL_EXECUTION_STATE = Topic.create("SPARQL execution state", SparqlExecutionStateNotifier.class);

    void updateState(String message, Boolean isErrorMessage);
}
