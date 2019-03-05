
/*

Sample Input: 
4 9
8 52
6 80
26 42
2 72
51 19
39 11
37 29
81 3
59 5
79 23
53 7
43 33
77 21

Sample Output:
5

Explanation:

To traverse the board via the shortest route, the player first rolls the die to get a '5', and
ends up at square 6 and climbs the ladder to square 80. 
He then rolls the die to get '6' three times, to get to square 98(6+6+6=18,80+18=98).		
A final roll of 2 lands on the target square.
So, the player required 5 rolls(5,6,6,6,2) of the die for this shortest and best case scenario.

 * 
 */

import java.util.*;

public class SnakesLadders {

    public static void main(String[] args) throws Exception {

        int numLadders, numSnakes;
        Scanner sc = new Scanner(System.in);
        numLadders = sc.nextInt();
        numSnakes = numLadders + sc.nextInt();
        ArrayList[] graph = new ArrayList[100];
        int[] visited = new int[100];
        int[] parents = new int[100];
        int[][] distances = new int[100][100];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 99; i++)
            parents[i] = i - 1;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == j)
                    distances[i][j] = 0;
                else if (j == i + 1)
                    distances[i][j] = 1;
                else
                    distances[i][j] = 99;
            }
        }
        for (int i = 0; i < 100; i++)
            graph[i] = new ArrayList<Integer>();
        for (int i = 0; i < 99; i++)
            graph[i].add(i + 1);
        for (int i = 0; i < numSnakes; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u - 1].add(v - 1);
            distances[u - 1][v - 1] = 1;
        }
        Arrays.fill(visited, 0);
        q.add(0);
        bfs(graph, q, visited, distances, 0, parents);
        System.out.println(dies(parents));

    }

    public static void bfs(ArrayList[] graph, Queue<Integer> q, int[] visited, int[][] distances, int source,
            int[] parents) {

        while (!q.isEmpty()) {
            int curr = q.remove();
            visited[curr] = 1;
            for (Object obj : graph[curr]) {
                int temp = (int) obj;
                if (visited[temp] == 0) {
                    q.add(temp);
                }
                if (distances[source][temp] > distances[source][curr] + distances[curr][temp]) {
                    distances[source][temp] = distances[source][curr] + distances[curr][temp];
                    parents[temp] = curr;
                }
            }
        }
    }

    public static int dies(int[] parents) {
        int ans = 0;
        int i = 99;
        // System.out.println(parents[1]);

        // System.out.println(parents[99]);
        while (parents[i] != 0) {
            int cnt = 0;
            while (i > 0 && parents[i - 1] == parents[i] - 1) {

                i--;
                cnt++;
                System.out.println(i + " " + cnt);
            }
            if (cnt > 6) {
                ans += cnt / 6;
                // System.out.println("----" + ans);
                ans += cnt % 6;
                // System.out.println("----" + ans);
            } else {
                ans++;
            }
            if (i == 0)
                break;
            i = parents[i - 1];
        }
        return ans;
    }
}
