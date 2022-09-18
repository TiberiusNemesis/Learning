package com.solo.learning;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SolutionsTest {

    @Test
    void reverseListTest() {
        List<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(8);
        integers.add(15);
        integers.add(16);
        integers.add(23);
        integers.add(42);
        List reversedList = Solutions.reverseList(integers);
        assertEquals(integers.get(integers.size() - 1), reversedList.get(0));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "welcometojava:3:ava:wel",
            "mszenilda:2:da:ze",
            "Far over the Misty Mountains cold through dungeons deep and caverns old:10: Misty Mou:y Mountain"
    }, delimiter = ':')
    void getSmallestAndLargestTest(String text, String sizeOfSubstring, String expectedSmallest, String expectedLargest) {
        assertEquals(String.format(expectedSmallest + "\n" + expectedLargest), Solutions.getSmallestAndLargest(text, Integer.parseInt(sizeOfSubstring)));
    }

    @Test
    void test() {
        Solutions.getSmallestAndLargest("Far over the Misty Mountains cold through dungeons deep and caverns old", 10);
    }

    @ParameterizedTest
    @CsvSource({"Willy,lliwy", "Illiad,dailli", "YMCACMY,CYMYCAM", "adultery,truelady", "funeral,realfun"})
    void checkForPalindromeTest() {
        assertEquals("Yes", Solutions.checkForPalindrome("ABBACABBA"));
    }

  /*void checkForPalindromeTest() {
    assertEquals("Yes", Solutions.checkForPalindrome("ABBACABBA"));
  }*/

    @ParameterizedTest
    @CsvSource({"Willy,lliwy", "Illiad,dailli", "YMCACMY,CYMYCAM", "adultery,truelady", "funeral,realfun"})
    void isAnAnagramTest(String firstWord, String secondWord) {
        assertTrue(Solutions.isAnAnagram(firstWord, secondWord));
    }

    @ParameterizedTest
    @CsvSource({"Willy,wonka", "Illiad,daily", "YMCA,MYCAM", "adultery,modesty", "funyums,realfun"})
    void isAnAnagramNegativeTest(String firstWord, String secondWord) {
        assertFalse(Solutions.isAnAnagram(firstWord, secondWord));
    }

    @Test
    void isAnagramTest() {
        assertTrue(Solutions.isAnagram("Renny", "Nyren"));
    }

    @Test
    void isAnagramNegativeTest() {
        assertFalse(Solutions.isAnagram("sunshine", "moonlight"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"And we chillin', kickin' it, kissed by the sun",
            "I'm your dream, make you real\nI'm your eyes when you must steal\nI'm your pain when you can't feel\nSad but true", "                \n"})
    void tokenSeparatorTest(String lyrics) {
        Solutions.tokenSeparator(lyrics);
    }
}
