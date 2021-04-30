if __name__ == '__main__':
    print("Which query_list should be used for generating? normal/update")
    input = input()
    modifier = ""
    if input == "update":
        modifier = "Update"
    file = open('W3_query' + modifier + '_list', 'r')
    content = file.read()
    queries = content.split("###\n")

    for idx, val in enumerate(queries):
        f = open("queries/" + "Parsing" + modifier + "Test" + "{:03d}".format(idx) + ".sparql", "w+")
        f.write(val)
        f.close()
        print("    public void testParsing" + modifier + "Test" + "{:03d}".format(idx) + "() { doTest(true, true); }")

    print("Next step is to copy the code into the test class and run the tests. "
          "Reference PSI files will be generated for each SPARQL query after first run.")