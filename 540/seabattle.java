import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * seabattle
 */
public class seabattle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int w1 = Integer.parseInt(st.nextToken());
        int h1 = Integer.parseInt(st.nextToken());
        int w2 = Integer.parseInt(st.nextToken());
        int h2 = Integer.parseInt(st.nextToken());
        int ans = (h1 + h2 + 2) * 2;
        ans += w1;
        ans += w2;
        ans += Math.abs(w1 - w2);
        System.out.println(ans);

    }
}