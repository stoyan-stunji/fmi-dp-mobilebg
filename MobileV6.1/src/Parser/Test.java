package Parser;

public class Test
{
    public static void main(String[] args)
    {
        QueryTester tester = new QueryTester();
        Searcher searcher = new SearcherImplementation();
        tester.test(searcher);
    }
}
