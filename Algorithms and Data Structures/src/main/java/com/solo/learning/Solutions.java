package com.solo.learning;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

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
   * This is the "real" anagram checker without using easy methods from the Arrays class. Basically,
   * it stores a value of how many times a character appears in the "count" * array; incrementing it
   * if it appears in a, and decrementing if it also appears in b. The end * result (if we're
   * actually dealing with an anagram is an array filled with zeroes. Otherwise, * any number
   * different from that indicates it's not an anagram. Works only if our constraints limit the
   * input to ASCII characters (a-z,A-Z,0-9...), otherwise the count array would be too large, and
   * we likely would lack memory to execute this if we had to store, say, Unicode strings.
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

  static String[] tokenSeparator(String text) {
    log.info("Initializing TokenSeparator. \nReceived text: {}", text);
    text = text.trim().replaceAll("[!,?._'@]", " ");
    text = text.replaceAll("(\\s)+", " ");

    if (text.trim().equalsIgnoreCase("")) {
      return new String[] {"0"};
    }
    String[] splitString = text.split(" ");

    log.info("Total separated tokens: {}", splitString.length);
    for (String string : splitString) {
      System.out.println(string);
    }

    return splitString;
  }

  /**
   * Checks a 6x6 2D array (arr) containing integers where arr[x][y->y+2], arr[x+1][y+2] and
   * arr[x+2][y->y+2] form an "hourglass" pattern. Determines the sum of all hourglasses in the 6x6
   * array, then prints out the value of the highest sum.
   *
   * @param arr A 6x6 2D array (or rather, a List of Lists).
   * @return The sum of the highest values found in an hourglass pattern.
   */
  public static int hourglassSum(List<List<Integer>> arr) {
    int highest = Integer.MIN_VALUE;
    for (int j = 0; j < 4; j++) {
      for (int i = 0; i < 4; i++) {
        // There are 16 possible hourglasses; 4 lines of 4.
        int sum = 0;
        sum += arr.get(j).get(i);
        sum += arr.get(j).get(i + 1);
        sum += arr.get(j).get(i + 2);
        sum += arr.get(j + 1).get(i + 1);
        sum += arr.get(j + 2).get(i);
        sum += arr.get(j + 2).get(i + 1);
        sum += arr.get(j + 2).get(i + 2);
        if (sum > highest) highest = sum;
      }
    }
    return highest;
  }

  /**
   * Performs a left-rotation on an array by "d" positions, i.e. shifts them to the left by a "d"
   * amount of index positions.
   *
   * @param d The number of indexes to shuffle to the left.
   * @param arr The Integer list to be rotated.
   * @return The rotated/shifted list.
   */
  public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    int j = 0;
    List<Integer> copy = new ArrayList<>();

    for (Integer number : arr) {
      copy.add(number.intValue());
    }

    for (int i = 0; i < arr.size(); i++) {
      if (i + d >= arr.size()) {
        arr.set(i, copy.get(j));
        j++;
      } else {
        arr.set(i, copy.get(i + d));
      }
    }
    return arr;
  }

  /**
   * Takes in a List of Strings containing character sequences, and a "queries" list of Strings
   * containing patterns to be checked. The method compares the entries in the "queries" list to
   * each entry of "stringList" and if there is a match, it adds +1 to a counter. This is then added
   * to a "results" list. Basically, finds how many times each element from the "queries" list is
   * present in the "stringsList".
   *
   * @param stringList A list of strings containing random character sequences.
   * @param queries A list of strings containing character sequences to be checked and counted from
   *     stringsList.
   * @return A list of how many times each element from the "queries" list can be found in
   *     "stringList".
   */
  public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    List<Integer> results = new ArrayList<>();
    for (String query : queries) {
      int count = 0;
      for (int i = 0; i < stringList.size(); i++) {
        if (stringList.get(i).equals(query)) {
          count++;
        }
      }
      results.add(count);
    }
    return results;
  }

  /**
   * Using a 2D array of unknown size (which we'll call potato), this method generates an n-sized Long-type result List, which
   * contains the results of certain operations defined in the potato. Each line of the potato contains 3 integer elements
   * in the format "a b k", which describe an operation that will be repeated from indexes a to b
   * (inclusive) on the result list. Which means that each of the indexes on the result list, from a to b, will have
   * "k" added to them. Then we return the largest number from the result list. That's it. But
   * apparently HackerRank doesn't know how to explain this without me having to read the page 10
   * times. Or maybe I'm just dumb. Who knows?
   *
   * @param n The size of the result list.
   * @param queries The operations to be executed on the result list, in format a b k (from indexes
   *     a to b, add number k)
   * @return A Long representing the highest number from the final result list.
   */
  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    List<Long> resultsList = new ArrayList<>();
    Long highest = Long.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      resultsList.add(0L);
    }

    for (List<Integer> list : queries) {
      int a = list.get(0) - 1;
      int b = list.get(1);
      int k = list.get(2);

      for (int i = a; i < b; i++) {
        Long current = (Long.valueOf(k) + resultsList.get(i));
        resultsList.set(i, current);
        if (current > highest) highest = current;
      }
    }

    return highest;
  }
}
