import java.util.Scanner;

/**
 * ncake
 */
public class ncake {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        int steps = 0;
        int asz = 1, bsz = 1;
        int apos = 0, bpos = 0;
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }
        steps = move(apos, asz, n, arr, steps);
        steps = move(bpos, bsz, n, arr, steps);
        System.out.println(steps);
    }

    public static int move(int apos, int asz, int n, int[] arr, int steps) {

        while (asz <= n) {
            int tpos1 = apos;
            int tpos2 = apos;
            while (tpos1 > 0 && arr[tpos1] != asz) {
                tpos1--;
            }
            while (tpos2 < 2 * n - 1 && arr[tpos2] != asz) {
                tpos2++;
            }
            if (arr[tpos1] != asz) {
                steps += tpos2 - apos;
                arr[tpos2] = 0;
                apos = tpos2;
            } else if (arr[tpos2] != asz) {
                steps += apos - tpos1;
                arr[tpos1] = 0;
                apos = tpos1;
            } else {
                int a = apos - tpos1;
                int b = tpos2 - apos;
                int[] a1 = arr.clone();
                int[] a2 = arr.clone();
                int sz1 = steps + a;
                int sz2 = steps + b;
                a1[tpos1] = 0;
                a2[tpos2] = 0;
                sz1 = move(tpos1, asz + 1, n, a1, sz1);
                sz2 = move(tpos2, asz + 1, n, a2, sz2);
                System.out.println("----" + sz1 + " " + sz2);

                if (sz1 < sz2) {

                    steps += a;
                    arr[tpos1] = 0;
                    apos = tpos1;
                } else {
                    steps += b;
                    arr[tpos2] = 0;
                    apos = tpos2;
                }
            }
            asz++;
        }
        return steps;
    }
}
