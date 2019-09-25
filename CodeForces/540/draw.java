import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class draw {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int x = 0, y = 0;
        int count = 1;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (x != a || y != b) {
                int z = Math.min(a, b) - Math.max(x, y);
                if (z >= 0) {
                    if (x != y)
                        count++;
                    count += z;
                }
                x = a;
                y = b;
            }
        }
        System.out.println(count);
    }
}