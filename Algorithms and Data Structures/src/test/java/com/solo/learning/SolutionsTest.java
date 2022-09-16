package com.solo.learning;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {

    @Test
    void reverseList() throws IOException {
    }

    @Test
    void getSmallestAndLargest() {
        assertEquals("ava\nwel", Solutions.getSmallestAndLargest("welcometojava", 3));
    }

    @Test
    void checkForPalindrome() {
        assertEquals("Yes", Solutions.checkForPalindrome("ABBAABBA"));
    }
}