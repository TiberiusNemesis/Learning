package com.solo.learning;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Methods providing my own solutions for coding exercises found on HackerRank, LeetCode and the
 * likes.
 *
 * @author tiberiusdourado
 */


@Slf4j
public class Solutions {

  // Every method has a test case (or multiple test cases) in the SolutionsTest class.

  /**
   * Reverses a list. The last element becomes the first, the penultimate element will become the
   * second, antepenultimate becomes the third, and so forth.
   *
   * @param list The to-be-reversed list.
   * @return A reversed list.
   */
  public static List<Object> reverseList(List list) {
    List<Object> reversedList = new ArrayList<>();
    for (int i = list.size() - 1; i > -1; i--) {
      reversedList.add(list.get(i));
    }
    return reversedList;
  }

  /**
   * Gets the smallest and the largest "k"-sized lexicographically significant substrings from a
   * string s.
   *
   * @param s The string which will be parsed.
   * @param k The size of the substrings to be calculated.
   * @return A newline-separated String containing the (lexicographically) smallest and the largest
   *     substrings from the "s" String.
   */
  public static String getSmallestAndLargest(String s, int k) {
    String smallest = s.substring(0, k);
    String largest = "";
    for (int i = 0; k <= s.length(); i++) {
      String currentSubstring = s.substring(i, k);
      if (currentSubstring.compareTo(smallest) < 0) {
        smallest = currentSubstring;
      } else if (currentSubstring.compareTo(largest) > 0) {
        largest = currentSubstring;
      }
      k++;
    }
    return smallest + "\n" + largest;
  }

  /**
   * Takes in a String and checks if it is a palindrome, i.e. if the first character is equal to the
   * last, the second equals the penultimate, and so forth.
   *
   * @param potentialPalindrome A String object which will be checked.
   * @return A String saying "Yes" if it is a palindrome and "No" otherwise.
   */
  public static String checkForPalindrome(String potentialPalindrome) {
    int j = potentialPalindrome.length() - 1;
    for (int i = 0; i < potentialPalindrome.length() / 2; i++) {
      if (potentialPalindrome.charAt(i) != potentialPalindrome.charAt(j)) {
        return "No";
      }
      j--;
    }
    return "Yes";
  }

  /**
   * Interview question. Quite interesting!
   *
   * @param stocksProfit
   * @param target
   * @return
   */
  public static int stockPairs(List<Integer> stocksProfit, long target) {
    int pairs = 0;

    stocksProfit.add(1);
    stocksProfit.add(1);

    stocksProfit.add(46);

    target = 47L;

    ListIterator<Integer> stockListIterator = stocksProfit.listIterator();
    HashMap<Long, Long> valueToTargetHashmap = new HashMap<>();

    for (Integer element : stocksProfit) {
      valueToTargetHashmap.put(Long.valueOf(element), target - element);
    }

    for (Long element : valueToTargetHashmap.values()) {
      if (element.equals(valueToTargetHashmap.get(element))) {
        pairs += Collections.frequency(stocksProfit, element);
      }
    }

    while (stockListIterator.hasNext()) {
      Long currentElement = Long.valueOf(stockListIterator.next());
    }

    return pairs;
  }

  /**
   * This is the lazy Java version of anagram checking. Transforms the strings into character
   * arrays, sorts them, them compares the arrays.
   *
   * @param a The first potential anagram to be checked.
   * @param b The second potential anagram to be checked.
   * @return True if it is an anagram, false otherwise.
   */
  static boolean isAnagram(String a, String b) {
    char[] firstString = a.toLowerCase().toCharArray();
    char[] secondString = b.toLowerCase().toCharArray();

    Arrays.sort(firstString);
    Arrays.sort(secondString);

    if (Arrays.compare(firstString, secondString) == 0) return true;
    else return false;
  }

  /**
   * This is the "real" anagram checker without using easy methods from the Arrays class. Basically, it stores a value of how many times a character appears in the "count"
   *    * array; incrementing it if it appears in a, and decrementing if it also appears in b. The end
   *    * result (if we're actually dealing with an anagram is an array filled with zeroes. Otherwise,
   *    * any number different from that indicates it's not an anagram. Works only
   * if our constraints limit the input to ASCII characters (a-z,A-Z,0-9...), otherwise the count array would be too
   * large, and we likely would lack memory to execute this if we had to store, say, Unicode
   * strings.
   *
   * @param a The first potential anagram to be checked.
   * @param b The second potential anagram to be checked.
   * @return True if it is an anagram, false otherwise.
   */
  static boolean isAnAnagram(String a, String b) {
    int[] count = new int[256];
    a = a.toLowerCase();
    b = b.toLowerCase();
    if (b.length() != a.length()) return false;

    for (int i = 0; i < a.length(); i++) {
      count[a.charAt(i)]++;
      count[b.charAt(i)]--;
    }

    for (int i = 0; i < 256; i++) {
      if (count[i] != 0) {
        return false;
      }
    }

    return true;
  }

  static String[] tokenSeparator(String text){
    log.info("Initializing TokenSeparator. \nReceived text: {}", text);
    text = text.trim().replaceAll("[!,?._'@]", " ");
    text = text.replaceAll("(\\s)+", " ");

    if (text.trim().equalsIgnoreCase("")){
      return new String[]{"0"};
    }
    String[] splitString = text.split(" ");

    log.info("Total separated tokens: {}", splitString.length);
    for (String string : splitString) {
      System.out.println(string);
    }

    return splitString;
  }
}

