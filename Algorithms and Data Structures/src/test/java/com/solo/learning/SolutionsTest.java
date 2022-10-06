package com.solo.learning;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
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
  @CsvSource(
      value = {
        "welcometojava:3:ava:wel",
        "mszenilda:2:da:ze",
        "Far over the Misty Mountains cold through dungeons deep and caverns old:10: Misty Mou:y Mountain"
      },
      delimiter = ':')
  void getSmallestAndLargestTest(
      String text, String sizeOfSubstring, String expectedSmallest, String expectedLargest) {
    assertEquals(
        String.format(expectedSmallest + "\n" + expectedLargest),
        Solutions.getSmallestAndLargest(text, Integer.parseInt(sizeOfSubstring)));
  }

  @Test
  void test() {
    Solutions.getSmallestAndLargest(
        "Far over the Misty Mountains cold through dungeons deep and caverns old", 10);
  }

  @ParameterizedTest
  @CsvSource({
    "Willy,lliwy",
    "Illiad,dailli",
    "YMCACMY,CYMYCAM",
    "adultery,truelady",
    "funeral,realfun"
  })
  void checkForPalindromeTest() {
    assertEquals("Yes", Solutions.checkForPalindrome("ABBACABBA"));
  }

  /*void checkForPalindromeTest() {
    assertEquals("Yes", Solutions.checkForPalindrome("ABBACABBA"));
  }*/

  @ParameterizedTest
  @CsvSource({
    "Willy,lliwy",
    "Illiad,dailli",
    "YMCACMY,CYMYCAM",
    "adultery,truelady",
    "funeral,realfun"
  })
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
  @ValueSource(
      strings = {
        "And we chillin', kickin' it, kissed by the sun",
        "I'm your dream, make you real\nI'm your eyes when you must steal\nI'm your pain when you can't feel\nSad but true",
        "                \n"
      })
  void tokenSeparatorTest(String lyrics) {
    Solutions.tokenSeparator(lyrics);
  }

  @Test
  void hourglassSumTest() {
    List<List<Integer>> columns = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      columns.add(new ArrayList<>());
    }
    // Line 1.
    columns.get(0).add(5);
    columns.get(0).add(5);
    columns.get(0).add(5);
    columns.get(0).add(0);
    columns.get(0).add(0);
    columns.get(0).add(0);

    // Line 2.
    columns.get(1).add(0);
    columns.get(1).add(5);
    columns.get(1).add(0);
    columns.get(1).add(-1);
    columns.get(1).add(-1);
    columns.get(1).add(-5);

    // Line 3.
    columns.get(2).add(0);
    columns.get(2).add(0);
    columns.get(2).add(0);
    columns.get(2).add(0);
    columns.get(2).add(-9);
    columns.get(2).add(20);

    // Line 4.
    columns.get(3).add(0);
    columns.get(3).add(6);
    columns.get(3).add(10);
    columns.get(3).add(6);
    columns.get(3).add(0);
    columns.get(3).add(1);

    // Line 5.
    columns.get(4).add(0);
    columns.get(4).add(0);
    columns.get(4).add(10);
    columns.get(4).add(0);
    columns.get(4).add(0);
    columns.get(4).add(1);

    // Line 6.
    columns.get(5).add(0);
    columns.get(5).add(6);
    columns.get(5).add(10);
    columns.get(5).add(6);
    columns.get(5).add(0);
    columns.get(5).add(50);

    /* The final 2D array looks something like this:
     * 5 5 5 0 0 0
     * 0 5 0 -1 -1 -5
     * 0 0 0 0 -9 20
     * 0 6 10 6 0 1
     * 0 0 10 0 0 1
     * 0 6 10 6 0 50
     */

    Solutions.hourglassSum(columns);
  }

  @Test
  void rotateLeftTest() {
    List<Integer> array = new ArrayList<>();
    array.add(1);
    array.add(2);
    array.add(3);
    array.add(4);
    array.add(5);

    Solutions.rotateLeft(3, array);
  }

  @Test
  void testingtest(){
    Integer a = new Integer(3);
    Integer b = new Integer(3);
    System.out.println(a==b);
  }
}
