package com.knubisoft.tasks.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchImplTest {
    private final Search search = new SearchImpl();

    @Test
    void searchPass() {
        long[] array = {1, 3, 5, 6, 7, 9, 10, 11};
        assertEquals(2, search.binarySearch(array, 5L));
        assertEquals(3, search.binarySearch(array, 6L));
        assertEquals(7, search.binarySearch(array, 11L));
        assertEquals(-1, search.binarySearch(array, 12L));
        assertEquals(-1, search.binarySearch(array, 0L));
    }
    @Test
    void searchFail() {
        assertThrows(IllegalArgumentException.class, () -> search.binarySearch(new long[] {-10, 0, 5, 2, 3, 6}, 6));
    }
}
