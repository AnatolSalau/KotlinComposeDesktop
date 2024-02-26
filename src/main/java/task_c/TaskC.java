package task_c;

import java.util.Arrays;
/**
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел.
 * Требуется удалить из него все повторения.
 */
public class TaskC {

      public static void main(String[] args) {
            TaskC taskC = new TaskC();
            taskC.testDeleteDublicatesByLoop();
            taskC.testDeleteDublicatesBySet();
            taskC.testDeleteDublicatesByStream();
      }
      /*
      -9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11
      l    r
      l(-9) != r(-8) -> {
            1. move left forward
            2. copy right to left
            3. move right forward
      }
           l  r
      l(-8) != r(0) -> move l and r forward
              l  r
      l(0) == r(0) -> move r forward
              l     r
      l(0) != r(1) -> {
            1. move left forward
            2. copy right to left
            3. move right forward
      }
      -9, -8, 0, 1,
                 l    r
      l(1) == r(1) -> move r forward
                 l      r
      l(1) == r(1) -> move r forward
                 l         r
      l(1) != r(2) -> {
            1. move left forward
            2. copy right to left
            3. move right forward
      }
      -9, -8, 0, 1, 2
                    l         r
      l(2) != r(3) -> {
            1. move left forward
            2. copy right to left
            3. move right forward
      }
            -9, -8, 0, 1, 2, 3
            ....
            -9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,   ...     11
                                                   l             r
      after enf loop we have:
      last element 11 wasn't  moved
      we need move left forward and copy r to l
                  -9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11  ...     11
                                                            l           r
       */
      private int[] removeDuplicatesByLoop(int[] numbers) {

            int l = 0;
            int r = 1;
            while (r < numbers.length) {
                  if (numbers[l] != numbers[r]) { // left and right are equal

                  } else {// left and ri

                  }
            }

            int[] result = new int[l]; // create result with size l
            for (int i = 0; i < l; i++) {//fill result
                  result[i] = numbers[i];
            }

            return result;
      }
      private int[] removeDuplicatesBySet(int[] numbers) {
            return new int[0];
      }
      private int[] removeDuplicatesByStream(int[] numbers) {
            return new int[0];
      }

      private void testDeleteDublicatesByLoop() {
            System.out.println("Test 1 (Delete dublicates by loop)");
            int[] numbers = {-9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11};
            System.out.println("Array before : " + Arrays.toString(numbers));
            int[] byLoop = removeDuplicatesByLoop(numbers);
            System.out.println("removeDuplicatesByLoop : " + Arrays.toString(byLoop));
            System.out.println("Expected result : [-9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
            System.out.println();
      }

      private void testDeleteDublicatesBySet() {
            System.out.println("Test 2 (Delete dublicates by set)");
            int[] numbers = {-9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11};
            System.out.println("Array before : " + Arrays.toString(numbers));
            int[] byLoop = removeDuplicatesBySet(numbers);
            System.out.println("removeDuplicatesByLoop : " + Arrays.toString(byLoop));
            System.out.println("Expected result : [-9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
            System.out.println();
      }

      private void testDeleteDublicatesByStream() {
            System.out.println("Test 3 (Delete dublicates by stream)");
            int[] numbers = {-9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11};
            System.out.println("Array before : " + Arrays.toString(numbers));
            int[] byLoop = removeDuplicatesByStream(numbers);
            System.out.println("removeDuplicatesByLoop : " + Arrays.toString(byLoop));
            System.out.println("Expected result : [-9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
            System.out.println();
      }
}
