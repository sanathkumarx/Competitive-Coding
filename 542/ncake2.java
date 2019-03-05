import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ncake2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[2 * n];
        long steps = 0;
        int apos = 0, bpos = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (!map1.containsKey(arr[i])) {
                map1.put(arr[i], i);
            } else {
                map2.put(arr[i], i);
            }
        }
        for (int i = 1; i < n + 1; i++) {
            int a = map1.get(i);
            int b = map2.get(i);
            int dis1 = (Math.abs(apos - a)) + (Math.abs(bpos - b));
            int dis2 = (Math.abs(apos - b)) + (Math.abs(bpos - a));
            if (dis1 < dis2) {
                steps += dis1;
                apos = a;
                bpos = b;
            } else {
                steps += dis2;
                apos = b;
                bpos = a;
            }
        }
        System.out.println(steps);
    }

}