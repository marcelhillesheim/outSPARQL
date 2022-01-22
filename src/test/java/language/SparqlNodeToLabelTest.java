package language;

import language.editor.completion.LiveAutoCompletion;
import org.apache.commons.io.IOUtils;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.sparql.core.Var;
import org.apache.jena.sparql.engine.binding.Binding;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;


@RunWith(Parameterized.class)
public class SparqlNodeToLabelTest {


    @Parameterized.Parameter()
    public String title;

    @Parameterized.Parameter(value = 1)
    public String input;

    @Parameterized.Parameter(value = 2)
    public String expected;

    @Parameterized.Parameters(name = "{index} {0} expected {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                    "literal string",
                    "\"type\": \"literal\", \"xml:lang\": \"en\", \"value\": \"test\"",
                    "\"test\"@en"
                },
                {
                    "literal custom datatype",
                    "\"type\": \"typed-literal\", \"datatype\": \"http://dbpedia.org/datatype/minute\", \"value\": \"10.0\"",
                    "\"10.0\"^^<http://dbpedia.org/datatype/minute>"
                },
                {
                    "literal custom datatype prefix",
                    "\"type\": \"typed-literal\", \"datatype\": \"test.com#minute\", \"value\": \"10.0\"",
                    "\"10.0\"^^test:minute"
                },
                {
                    "literal boolean",
                    "\"type\": \"typed-literal\", \"datatype\": \"http://www.w3.org/2001/XMLSchema#boolean\", \"value\": \"0\" ",
                    "false"
                },
                {
                    "literal int",
                    "\"type\": \"typed-literal\", \"datatype\": \"http://www.w3.org/2001/XMLSchema#integer\", \"value\": \"1996\"",
                    "1996"
                },
                {
                    "literal double",
                    "\"type\": \"typed-literal\", \"datatype\": \"http://www.w3.org/2001/XMLSchema#double\", \"value\": \"-2.0\"",
                    "-2.0"
                },
                {
                    "iri",
                    "\"type\": \"uri\", \"value\": \"http://www.w3.org/2000/01/rdf-schema#Datatype\"",
                    "<http://www.w3.org/2000/01/rdf-schema#Datatype>"
                },
                {
                    "iri prefix",
                    "\"type\": \"uri\", \"value\": \"test.com#something\"",
                    "test:something"
                }
        });
    }


    @Test
    public void testLiteralDataTypes() {

        PrefixMapping prefixMapping = PrefixMapping.Factory.create();
        prefixMapping.setNsPrefix("test", "test.com#");


        String jsonString = "{ \"head\": { \"link\": [], \"vars\": [\"var\"] },\n" +
                "  \"results\": { \"distinct\": false, \"ordered\": true, \"bindings\": [\n" +
                "    { \"var\": { " +
                input +
                " }} ] } }";

        ResultSet results;
        InputStream targetStream = IOUtils.toInputStream(jsonString,"UTF-8");
        results = ResultSetFactory.fromJSON(targetStream);

        assert results != null;
        Binding entry = results.nextBinding();
        String result = LiveAutoCompletion.nodeToLabel(entry.get(Var.alloc("var")), prefixMapping);
        assertEquals(expected, result);
    }
}
