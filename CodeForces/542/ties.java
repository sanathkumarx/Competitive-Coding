import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;

/**
 * ties
 */
public class ties {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0, a = 0, b = 0;
        int n = sc.nextInt();
        HashSet<Edge> edg = new HashSet<>();
        int[][] arr = new int[n + 1][2];
        arr[0][0] = 0;
        arr[0][1] = 0;
        // edg.add(new Edge(0, 0));
        for (int i = 1; i < n + 1; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            int ta = arr[i][0];
            int tb = arr[i][1];
            if (edg.contains(new Edge(ta, tb))) {
                continue;
            }
            edg.add(new Edge(ta, tb));
            int max = Math.max(a, b);
            if (ta < tb) {
                if (a <= ta && b <= ta)
                    ans += ta - max + 1;
                System.out.println(ans + "  " + ta + "  " + max);

            } else {
                if (a <= tb && b <= tb)
                    ans += tb - max + 1;
                System.out.println(ans + "  " + tb + "  " + max);

            }
            a = ta;
            b = tb;
        }
        System.out.println(ans);

    }
}

class Edge {
    int u;
    int v;

    Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public boolean equals(Object obj) {
        Edge e = (Edge) obj;
        if (e.u == this.u && e.v == this.v) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {

        return Arrays.hashCode(new Object[] { new Integer(u), new Integer(v) });

    }
}
