package dev.neelesh.main.topic.searching;

import dev.neelesh.main.util.ExecutionType;
import dev.neelesh.main.util.SearchType;
import dev.neelesh.main.exception.UnsupportedSearchOpeartionException;

public class Searching implements SearchingTemplate {

    @Override
    public int getIndexOfNumber(int[] arr, int number, SearchType searchType, ExecutionType executionType)
            throws UnsupportedSearchOpeartionException {
        return switch (searchType) {
            case LINEAR -> linearSearch(arr, number, executionType);
            case BINARY -> binarySearch(arr, number, executionType);
            default -> throw new UnsupportedSearchOpeartionException(
                    String.format("Search operation, %s, is not supported.", searchType)
            );
        };
    }

    @Override
    public int getIndexOfFirstOccurrence(int[] arr, int number, ExecutionType executionType) {
        return getFirstOccurrenceBinarySearch(arr, number, executionType);
    }

    private int binarySearch(int[] arr, int number, ExecutionType executionType) {
        int low = 0, high = arr.length - 1, mid = low + (high - low) / 2;

        if (executionType == ExecutionType.RECURSIVE) return binarySearchUsingRecursion(arr, low, high, number);

        while (low <= high) {
            if (number < arr[mid]) high = mid - 1;
            else if (number > arr[mid]) low = mid + 1;
            else return mid;
            mid = low + (high - low) / 2;
        }
        return -1;
    }

    private int binarySearchUsingRecursion(int[] arr, int low, int high, int number) {
        if (low > high) return -1;
        else {
            int mid = low + (high - low) / 2;
            if (number < arr[mid]) return binarySearchUsingRecursion(arr, low, mid - 1, number);
            else if (number > arr[mid]) return binarySearchUsingRecursion(arr, mid + 1, high, number);
            else return mid;
        }
    }

    private int linearSearch(int[] arr, int number, ExecutionType executionType) {

        if (executionType == ExecutionType.RECURSIVE) return linearSearchUsingRecursion(arr, 0, number);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) return i;
        }
        return -1;
    }

    private int linearSearchUsingRecursion(int[] arr, int index, int number) {
        if (index >= arr.length) return -1;
        else {
            if (arr[index] == number) return index;
            return linearSearchUsingRecursion(arr, index + 1, number);
        }
    }

    private int getFirstOccurrenceBinarySearch(int[] arr, int number, ExecutionType executionType) {
        int low = 0, high = arr.length - 1, mid = low + (high - low) / 2;

        if (executionType == ExecutionType.RECURSIVE)
            return getFirstOccurrenceBinarySearchUsingRecursion(arr, low, high, number);

        while (low <= high) {
            if (number < arr[mid]) high = mid - 1;
            else if (number > arr[mid]) low = mid + 1;
            else {
                return getFirstIndex(arr, number, mid);
            }
            mid = low + (high - low) / 2;
        }
        return -1;
    }

    private int getFirstIndex(int[] arr, int number, int index) {
        if (index == 0 || arr[index] != arr[index - 1]) return index;
        while (index > 0 && arr[index] == arr[index - 1]) index--;
        return index;
    }

    private int getFirstOccurrenceBinarySearchUsingRecursion(int[] arr, int low, int high, int number) {
        if (low > high) return -1;
        else {
            int mid = low + (high - low) / 2;
            if (number < arr[mid]) return getFirstOccurrenceBinarySearchUsingRecursion(arr, low, mid - 1, number);
            else if (number > arr[mid]) return getFirstOccurrenceBinarySearchUsingRecursion(arr, mid + 1, high, number);
            else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) return mid;
                else return getFirstOccurrenceBinarySearchUsingRecursion(arr, low, mid - 1, number);
            }
        }
    }
}
