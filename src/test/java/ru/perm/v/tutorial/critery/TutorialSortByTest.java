package ru.perm.v.tutorial.critery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TutorialSortByTest {
    @Test
    void sortByN() {
        TutorialSortBy sort = TutorialSortBy.N;

        assertEquals("N", sort.toString());
    }

    @Test
    void sortByTitle() {
        TutorialSortBy sort = TutorialSortBy.TITLE;

        assertEquals("TITLE", sort.toString());
    }
}
