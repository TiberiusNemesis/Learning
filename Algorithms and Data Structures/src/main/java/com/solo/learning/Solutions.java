package com.solo.learning;

import java.util.*;

/**
 * Methods providing my own solutions for coding exercises found on HackerRank, LeetCode and the
 * likes.
 *
 * @author tiberiusdourado
 */
public class Solutions {

    // Every method has a case test (or multiple case tests) in the SolutionsTest class.

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
        HashMap<String, String> hm = new HashMap<>();
        return reversedList;
    }

    /**
     * Gets the smallest and the largest "k"-sized lexicographically significant substrings from a
     * string s.
     *
     * @param s The string which will be parsed.
     * @param k The size of the substrings to be calculated.
     * @return A newline-separated String containing the (lexicographically) smallest and the largest
     * substrings from the "s" String.
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
     * Takes in a String and checks if it is a palindrome, i.e. if the first character is equal to the last, the second equals the penultimate, and so forth.
     *
     * @param potentialPalindrome A String object which will be checked.
     * @return A String saying "Yes" if it is a palindrome and "No" otherwise.
     */
    public static String checkForPalindrome(String potentialPalindrome) {
        int halfwayPoint = potentialPalindrome.length() / 2;
        char[] firstHalf = potentialPalindrome.substring(0, halfwayPoint).toCharArray();
        char[] secondHalf = potentialPalindrome.substring(halfwayPoint).toCharArray();
        if (firstHalf.equals(secondHalf)) return "Yes";
        else return "No";
    }

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        int pairs = 0;

        stocksProfit.add(1);
        stocksProfit.add(1);

        stocksProfit.add(46);

        target = 47L;

        ListIterator<Integer> stockListIterator = stocksProfit.listIterator();
        HashMap<Long, Long> valueToTargetHashmap = new HashMap<>();

        for (Integer element : stocksProfit) {
            valueToTargetHashmap.put(Long.valueOf(element), target-element);
        }

        for (Long element :
                valueToTargetHashmap.values()) {
            if (element.equals(valueToTargetHashmap.get(element))) {
                pairs += Collections.frequency(stocksProfit, element);
            }
        }

        while (stockListIterator.hasNext()) {
            Long currentElement = Long.valueOf(stockListIterator.next());
        }

        return pairs;
    }
}

