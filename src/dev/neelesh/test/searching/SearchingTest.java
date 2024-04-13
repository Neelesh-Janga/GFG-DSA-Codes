package dev.neelesh.test.searching;

import dev.neelesh.main.topic.searching.Searching;
import dev.neelesh.main.util.ExecutionType;
import dev.neelesh.main.util.SearchType;
import dev.neelesh.main.exception.UnsupportedSearchOpeartionException;

class SearchingTest {

    public static void main(String[] args) throws Exception {
        testGetIndexOfNumber();
    }

    static void testGetIndexOfNumber() throws Exception {
        Searching searchService = new Searching();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        assert searchService.getIndexOfNumber(arr, 5, SearchType.BINARY, ExecutionType.ITERATIVE) == 4;
        assert searchService.getIndexOfNumber(arr, 8, SearchType.BINARY, ExecutionType.RECURSIVE) == 7;
        assert searchService.getIndexOfNumber(arr, 10, SearchType.BINARY, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfNumber(arr, 0, SearchType.BINARY, ExecutionType.RECURSIVE) == -1;

        assert searchService.getIndexOfNumber(arr, 5, SearchType.LINEAR, ExecutionType.ITERATIVE) == 4;
        assert searchService.getIndexOfNumber(arr, 8, SearchType.LINEAR, ExecutionType.RECURSIVE) == 7;
        assert searchService.getIndexOfNumber(arr, 10, SearchType.LINEAR, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfNumber(arr, 0, SearchType.LINEAR, ExecutionType.RECURSIVE) == -1;

        try {
            searchService.getIndexOfNumber(arr, 5, SearchType.UNKNOWN, ExecutionType.ITERATIVE);
            System.out.println("Test failed: UnsupportedSearchOpeartionException expected but not thrown");
        } catch (UnsupportedSearchOpeartionException e) {
            System.out.println("Test passed: UnsupportedSearchOpeartionException thrown as expected");
        }
    }
}
