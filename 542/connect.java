import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * connect
 */
public class connect {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        Set set = new Set(size * size);
        st = new StringTokenizer(br.readLine(), " ");
        int fu = Integer.parseInt(st.nextToken()) - 1;
        int fv = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine(), " ");
        int tu = Integer.parseInt(st.nextToken()) - 1;
        int tv = Integer.parseInt(st.nextToken()) - 1;
        int[][] graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(temp[j]);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph[i][j] == 0) {
                    int pos = i * size + j;
                    if (i - 1 > -1 && graph[i - 1][j] == 0) {
                        set.union(pos, pos - size);
                    }
                    if (i + 1 < size && graph[i + 1][j] == 0) {
                        set.union(pos, pos + size);
                    }
                    if (j - 1 > -1 && graph[i][j - 1] == 0) {
                        set.union(pos, pos - 1);
                    }
                    if (j + 1 < size && graph[i][j + 1] == 0) {
                        set.union(pos, pos + 1);
                    }
                }
            }
        }
        int frompos = fu * size + fv;
        int topos = tu * size + tv;
        int fset = set.parent[frompos];
        int tset = set.parent[topos];
        if (fset == tset) {
            System.out.println(0);
            System.exit(0);
        } else {
            int ans = Integer.MAX_VALUE;
            HashSet<edge> set1 = new HashSet<>();
            HashSet<edge> set2 = new HashSet<>();
            for (int i = 0; i < set.parent.length; i++) {
                if (set.parent[i] == fset) {
                    int v = i % size;
                    int u = (i - v) / size;
                    set1.add(new edge(u, v));
                } else if (set.parent[i] == tset) {
                    int v = i % size;
                    int u = (i - v) / size;
                    set2.add(new edge(u, v));
                }
            }
            for (edge e1 : set1) {
                for (edge e2 : set2) {
                    int dis = (int) (Math.pow((e2.u - e1.u), 2) + Math.pow((e2.v - e1.v), 2));
                    if (dis < ans) {
                        ans = dis;
                    }
                }
            }
            System.out.println(ans);
        }

    }
}

class Set {
    int[] parent;

    Set(int j) {
        parent = new int[j];
        for (int i = 0; i < j; i++) {
            parent[i] = i;
        }
    }

    void union(int u, int v) {
        int temp = parent[v];
        parent[v] = u;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == temp) {
                parent[i] = u;
            }
        }

    }

    int find(int u) {
        int temp = u;
        while (parent[temp] != temp) {
            temp = parent[temp];
        }
        return temp;
    }

}

class edge {
    int u, v;

    edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}