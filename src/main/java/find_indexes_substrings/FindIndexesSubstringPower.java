package find_indexes_substrings;

import java.util.LinkedList;
import java.util.List;

/**
 * 28. Find the Indexes of the All Occurrence in a String
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0, 6
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0 and 6 , so we return 0 and 6.
 * <p>
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * <p>
 * Example 3:
 * Input: haystack = "aabaabaaaaaabaabaabaabbaaab", needle = "aabaab"
 * Output: 0, 10, 13, 16
 */
public class FindIndexesSubstringPower {
      public static void main(String[] args) {
            FindIndexesSubstringPower findIndexesSubstringPower = new FindIndexesSubstringPower();
            findIndexesSubstringPower.test1();
            findIndexesSubstringPower.test2();
            findIndexesSubstringPower.test3();
      }

      private void test1() {
            String text = "sadbutsad";
            String sample = "sad";
            String expect = "[0, 6]";
            List<Integer> indexesSubstring = getIndexesPowerMethod(text, sample);

            System.out.println("Test 1");
            System.out.println("Text : " + text);
            System.out.println("Sample : " + sample);
            System.out.println("Expect : " + expect);
            System.out.println("Answer : " + indexesSubstring);
            System.out.println();
      }

      private void test2() {
            String text = "leetcode";
            String sample = "leeto";
            String expect = "-1";
            List<Integer> indexesSubstring = getIndexesPowerMethod(text, sample);

            System.out.println("Test 2");
            System.out.println("Text : " + text);
            System.out.println("Sample : " + sample);
            System.out.println("Expect : " + expect);
            System.out.println("Answer : " + indexesSubstring);
            System.out.println();
      }

      private void test3() {
            String text = "aabaabaaaaaabaabaabaabbaaab";
            String sample = "aabaab";
            String expect = "0, 10, 13, 16";
            List<Integer> indexesSubstring = getIndexesPowerMethod(text, sample);

            System.out.println("Test 3");
            System.out.println("Text : " + text);
            System.out.println("Sample : " + sample);
            System.out.println("Expect : " + expect);
            System.out.println("Answer : " + indexesSubstring);
            System.out.println();
      }

      /*
            text = sadbutsad
            sample = sad

            i
            sadbutsad
            sad
            j
       */

      /**
       *    О(n * m)
       */
      private List<Integer> getIndexesPowerMethod(String text, String sample) {
            List<Integer> answer = new LinkedList<>();

            for (int l = 0; l < text.length(); l++) {
                  for (int r = 0; r < sample.length(); r++) {
                        //Exit from loop when we out of boundary
                        if (l+r >= text.length()) break;

                        char textChar = text.charAt(l+r);
                        char sampleChar = sample.charAt(r);

                        //compare characters
                        if (textChar != sampleChar) break;

                        //add result if we went through all sample
                        if (r == sample.length() - 1) {
                              answer.add(l);
                        }
                  }
            }

            if (answer.size() > 0 ) return answer;
            else {
                  answer.add(-1);
                  return answer;
            }
      }
}
