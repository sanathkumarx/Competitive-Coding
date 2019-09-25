
/*
 * 
Mr. Abby loves his new friend jadu.Jadu has come from different planet.
As Jadu is not fit for our planet Earth,he is destined to go. 
But jadu agrees to be on planet Earth if Mr.Abby solves one of this mysterious problem 
which he has been pondering over from a long time. So jadu seeks your help!! 

You are given N and M,where N is the size of the array. S is a set of elements from 1 to M. 
You need to assign/match each number of an array to any one of its distinct prime divisors 
and the corresponding prime divisor must be present in the set S. Once assigned/matched,
the corresponding prime divisor gets deleted from the set automatically. 
You have to find the optimal assignment/matching such as to maximize 
the count of numbers assigned/matched.

Input Format:
-------------
First line contains N and M.
Next line follows N integers which implies elements of an array.

Output Format:
--------------
Print the maximum matching possible as explained.


Sample Input:
4 10
10 60 40 55

Sample Output:
3

Explanation:
Here N=4,M=10.
S = {1,2,3,4,5,6,7,8,9,10}
Lets find prime divisors first.
For 10 = {2,5},
60 = {2,3,5},
40 = {2,5},
55 = {5,11}.
One of the optimal matching is 2 for 10,3 for 60 and 5 for 40. 

 * 
 */
import java.util.*;

public class JaiduAbby {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashSet[] set = new HashSet[n];
        for (int i = 0; i < n; i++) {
            set[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = primeFactors(arr[i]);
            for (int curr : list) {
                if (curr <= m)
                    set[i].add(curr);
            }
        }
        HashSet<Integer> added = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            added.clear();
            int tcnt = count(set, arr, i, added, 0);
            // System.out.println(added.toString());
            // System.out.println(tcnt);
            if (tcnt > cnt) {
                cnt = tcnt;
            }
        }
        System.out.println(cnt);
    }

    public static int count(HashSet[] set, int[] arr, int i, HashSet<Integer> added, int cnt) {
        for (int j = 0; j < set.length; j++) {
            if (j != i) {
                for (Object obj : set[j]) {
                    int temp = (int) obj;
                    if (!added.contains(temp)) {
                        added.add(temp);
                        set[j].remove(temp);
                        cnt++;
                        return count(set, arr, j, added, cnt);
                    }
                }
            }
        }
        return cnt;
    }

    // function to get all unique prime factors
    // of a given number n
    static private List<Integer> primeFactors(int num) {
        List<Integer> primeFactor = new ArrayList<Integer>();
        // add the number of 2s that divide n
        while (num % 2 == 0) {
            primeFactor.add(2);
            num /= 2;
        }

        // n must be odd at this point. So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            // While i divides n, add i and divide n
            while (num % i == 0) {
                primeFactor.add(i);
                num /= i;
            }
        }
        // This condition is to handle the case where
        // n is a prime number greater than 2
        if (num > 2) {
            primeFactor.add(num);
        }

        /* we need unique primefactors in list */
        HashSet hs = new HashSet();
        hs.addAll(primeFactor);
        primeFactor.clear();
        primeFactor.addAll(hs);

        return primeFactor;
    }

}