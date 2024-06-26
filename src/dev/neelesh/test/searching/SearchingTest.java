package dev.neelesh.test.searching;

import dev.neelesh.main.topic.searching.Searching;
import dev.neelesh.main.util.ExecutionType;
import dev.neelesh.main.util.SearchType;
import dev.neelesh.main.exception.UnsupportedSearchOpeartionException;

class SearchingTest {

    public static void main(String[] args) throws Exception {
        testGetIndexOfNumber();
        testGetFirstOccurrenceBinarySearch();
        testGetLastOccurrenceBinarySearch();
        testGetNumberOfOccurrences();
        testSquareRoot();
    }

    static void testGetIndexOfNumber() throws Exception {
        Searching searchService = new Searching();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        assert searchService.getIndexOfNumber(arr, 5, SearchType.BINARY, ExecutionType.ITERATIVE) == 4;
        assert searchService.getIndexOfNumber(arr, 5, SearchType.BINARY, ExecutionType.RECURSIVE) == 4;
        assert searchService.getIndexOfNumber(arr, 8, SearchType.BINARY, ExecutionType.ITERATIVE) == 7;
        assert searchService.getIndexOfNumber(arr, 8, SearchType.BINARY, ExecutionType.RECURSIVE) == 7;
        assert searchService.getIndexOfNumber(arr, 10, SearchType.BINARY, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfNumber(arr, 10, SearchType.BINARY, ExecutionType.RECURSIVE) == -1;
        assert searchService.getIndexOfNumber(arr, 0, SearchType.BINARY, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfNumber(arr, 0, SearchType.BINARY, ExecutionType.RECURSIVE) == -1;

        assert searchService.getIndexOfNumber(arr, 5, SearchType.LINEAR, ExecutionType.ITERATIVE) == 4;
        assert searchService.getIndexOfNumber(arr, 5, SearchType.LINEAR, ExecutionType.RECURSIVE) == 4;
        assert searchService.getIndexOfNumber(arr, 8, SearchType.LINEAR, ExecutionType.ITERATIVE) == 7;
        assert searchService.getIndexOfNumber(arr, 8, SearchType.LINEAR, ExecutionType.RECURSIVE) == 7;
        assert searchService.getIndexOfNumber(arr, 10, SearchType.LINEAR, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfNumber(arr, 10, SearchType.LINEAR, ExecutionType.RECURSIVE) == -1;
        assert searchService.getIndexOfNumber(arr, 0, SearchType.LINEAR, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfNumber(arr, 0, SearchType.LINEAR, ExecutionType.RECURSIVE) == -1;

        try {
            searchService.getIndexOfNumber(arr, 5, SearchType.UNKNOWN, ExecutionType.ITERATIVE);
            System.out.println("Test failed: UnsupportedSearchOpeartionException expected but not thrown");
        } catch (UnsupportedSearchOpeartionException e) {
            System.out.println("Test passed: UnsupportedSearchOpeartionException thrown as expected");
        } finally {
            System.out.println("testGetIndexOfNumber(): All test cases passed successfully.");
        }
    }

    static void testGetFirstOccurrenceBinarySearch() {
        Searching searchService = new Searching();
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9};

        assert searchService.getIndexOfFirstOccurrence(arr, 2, ExecutionType.ITERATIVE) == 1;
        assert searchService.getIndexOfFirstOccurrence(arr, 2, ExecutionType.RECURSIVE) == 1;
        assert searchService.getIndexOfFirstOccurrence(arr, 1, ExecutionType.ITERATIVE) == 0;
        assert searchService.getIndexOfFirstOccurrence(arr, 1, ExecutionType.RECURSIVE) == 0;
        assert searchService.getIndexOfFirstOccurrence(arr, 9, ExecutionType.ITERATIVE) == 12;
        assert searchService.getIndexOfFirstOccurrence(arr, 9, ExecutionType.RECURSIVE) == 12;
        assert searchService.getIndexOfFirstOccurrence(arr, 0, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfFirstOccurrence(arr, 0, ExecutionType.RECURSIVE) == -1;
        assert searchService.getIndexOfFirstOccurrence(arr, 0, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfFirstOccurrence(arr, 0, ExecutionType.RECURSIVE) == -1;
        assert searchService.getIndexOfFirstOccurrence(arr, 5, ExecutionType.ITERATIVE) == 6;
        assert searchService.getIndexOfFirstOccurrence(arr, 5, ExecutionType.RECURSIVE) == 6;

        System.out.println("testGetFirstOccurrenceBinarySearch(): All test cases passed successfully.");
    }

    static void testGetLastOccurrenceBinarySearch() {
        Searching searchService = new Searching();
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9};

        assert searchService.getIndexOfLastOccurrence(arr, 2, ExecutionType.ITERATIVE) == 3;
        assert searchService.getIndexOfLastOccurrence(arr, 2, ExecutionType.RECURSIVE) == 3;
        assert searchService.getIndexOfLastOccurrence(arr, 1, ExecutionType.ITERATIVE) == 0;
        assert searchService.getIndexOfLastOccurrence(arr, 1, ExecutionType.RECURSIVE) == 0;
        assert searchService.getIndexOfLastOccurrence(arr, 9, ExecutionType.ITERATIVE) == 12;
        assert searchService.getIndexOfLastOccurrence(arr, 9, ExecutionType.RECURSIVE) == 12;
        assert searchService.getIndexOfLastOccurrence(arr, 0, ExecutionType.ITERATIVE) == -1;
        assert searchService.getIndexOfLastOccurrence(arr, 0, ExecutionType.RECURSIVE) == -1;
        assert searchService.getIndexOfLastOccurrence(arr, 5, ExecutionType.ITERATIVE) == 8;
        assert searchService.getIndexOfLastOccurrence(arr, 5, ExecutionType.RECURSIVE) == 8;

        System.out.println("testGetLastOccurrenceBinarySearch(): All test cases passed successfully.");
    }

    static void testGetNumberOfOccurrences() {
        Searching searchService = new Searching();
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9};

        assert searchService.getNumberOfOccurrences(arr, 2, ExecutionType.ITERATIVE) == 3;
        assert searchService.getNumberOfOccurrences(arr, 2, ExecutionType.RECURSIVE) == 3;
        assert searchService.getNumberOfOccurrences(arr, 1, ExecutionType.ITERATIVE) == 1;
        assert searchService.getNumberOfOccurrences(arr, 1, ExecutionType.RECURSIVE) == 1;
        assert searchService.getNumberOfOccurrences(arr, 10, ExecutionType.ITERATIVE) == -1;
        assert searchService.getNumberOfOccurrences(arr, 10, ExecutionType.RECURSIVE) == -1;
        assert searchService.getNumberOfOccurrences(arr, 5, ExecutionType.ITERATIVE) == 3;
        assert searchService.getNumberOfOccurrences(arr, 5, ExecutionType.RECURSIVE) == 3;

        System.out.println("testGetNumberOfOccurrences(): All test cases passed successfully.");
    }

    static void testSquareRoot() throws UnsupportedSearchOpeartionException {
        Searching searchService = new Searching();

        assert searchService.computeSquareRoot(16, ExecutionType.ITERATIVE) == 4;
        assert searchService.computeSquareRoot(16, ExecutionType.RECURSIVE) == 4;
        assert searchService.computeSquareRoot(10, ExecutionType.ITERATIVE) == 3;
        assert searchService.computeSquareRoot(10, ExecutionType.RECURSIVE) == 3;
        assert searchService.computeSquareRoot(0, ExecutionType.ITERATIVE) == 0;
        assert searchService.computeSquareRoot(0, ExecutionType.RECURSIVE) == 0;
        assert searchService.computeSquareRoot(1, ExecutionType.ITERATIVE) == 1;
        assert searchService.computeSquareRoot(1, ExecutionType.RECURSIVE) == 1;
        assert searchService.computeSquareRoot(1000000, ExecutionType.ITERATIVE) == 1000;
        assert searchService.computeSquareRoot(1000000, ExecutionType.RECURSIVE) == 1000;
        assert searchService.computeSquareRoot(999999, ExecutionType.ITERATIVE) == 999;
        assert searchService.computeSquareRoot(999999, ExecutionType.RECURSIVE) == 999;

        try {
            searchService.computeSquareRoot(-1, ExecutionType.ITERATIVE);
            System.out.println("Test failed: UnsupportedSearchOpeartionException expected but not thrown");
        } catch (UnsupportedSearchOpeartionException e) {
            System.out.println("Test passed: UnsupportedSearchOpeartionException thrown as expected");
            System.out.println("testSquareRoot(): All test cases passed successfully.");
        }
    }
}
