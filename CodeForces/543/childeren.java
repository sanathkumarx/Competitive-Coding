import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class childeren {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nSweets = Integer.parseInt(reader.readLine());
        int[] arr = new int[nSweets];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < nSweets; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < nSweets; i++) {
            for (int j = i + 1; j < nSweets; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);

                } else {
                    map.put(sum, 1);
                }
            }
        }
        int ans = 0;
        for (Map.Entry e : map.entrySet()) {
            if ((int) e.getValue() > ans) {
                ans = (int) e.getValue();
            }
        }
        System.out.println(ans);
    }
}
