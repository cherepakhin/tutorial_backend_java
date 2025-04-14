package ru.perm.v.tutorial.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TutorialEntityTest {

    @Test
    void testEquals() {
        TutorialEntity entity1 = new TutorialEntity(1L, "TITLE", "DESCRIPTION", true);
        TutorialEntity entity2 = new TutorialEntity(1L, "TITLE", "DESCRIPTION", true);

        assertEquals(entity1, entity2);
    }

    @Test
    void testNotEquals() {
        TutorialEntity entity1 = new TutorialEntity(1L, "TITLE", "DESCRIPTION", true);
        TutorialEntity entity2 = new TutorialEntity(2L, "TITLE", "DESCRIPTION", true);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testHashCode() {
        TutorialEntity entity1 = new TutorialEntity(1L, "TITLE", "DESCRIPTION", true);
        TutorialEntity entity2 = new TutorialEntity(1L, "TITLE", "DESCRIPTION", true);

        assertEquals(entity1.hashCode(), entity2.hashCode());
    }
}