package dev.neelesh.main.topic.searching;

import dev.neelesh.main.exception.UnsupportedSearchOpeartionException;
import dev.neelesh.main.util.ExecutionType;
import dev.neelesh.main.util.SearchType;

public interface SearchingTemplate {
    int getIndexOfNumber(int[] arr, int number, SearchType searchType, ExecutionType executionType) throws UnsupportedSearchOpeartionException;

    int getIndexOfFirstOccurrence(int[] arr, int number, ExecutionType executionType);

    int getIndexOfLastOccurrence(int[] arr, int number, ExecutionType executionType);
}
