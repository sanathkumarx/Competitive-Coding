import java.util.Scanner;

/**
 * bepos
 */
public class bepos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int z = 0;
        if (n % 2 == 0) {
            z = n / 2;
        } else {
            z = (int) (n / 2) + 1;
        }
        // System.out.println("req " + z);
        double[] arr = new double[n];
        int neg = 0, pos = 0, zer = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
            if (arr[i] > 0)
                pos++;
            else if (arr[i] < 0)
                neg++;
            else
                zer++;
        }
        if (pos >= z) {
            System.out.println(1);
        } else if (neg >= z) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }

    }
}