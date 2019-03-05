
/*
Given N strings.
Find the longest possible subsequence from each of these N strings such that
they are anagram to each other.
The task is to print the largest subsequence among all the subsequences in alphabetical order.

Sample Input:
3
ngitfinishing kmitschool ksjcih

Sample Output:
his

Explanation:

First string has "shi", Second string has "ish", third string has "sih".
These three are anagrams. "his" is large and is in alphabetical order.
 *
 */
import java.util.*;

public class LongestCommonAnagram {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");
        int[][] count = new int[num][26];
        for (int i = 0; i < num; i++)
            Arrays.fill(count[i], 0);
        for (int j = 0; j < arr.length; j++) {
            String s = arr[j];
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                // System.out.println(c);
                count[j][c] += 1;
            }
        }
        int[] farr = new int[26];
        Arrays.fill(farr, Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 26; j++) {
                farr[j] = Math.min(count[i][j], farr[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < farr[i]; j++) {
                System.out.print((char) (i + (int) 'a'));
            }
        }
    }
}