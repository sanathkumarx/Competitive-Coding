import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

/**
 * choochoo
 */
public class choochoo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stops = Integer.parseInt(br.readLine());
        int candies = Integer.parseInt(br.readLine());
        HashMap[] maps = new HashMap[2];
        ArrayList[] arr = new ArrayList[stops];
        for (int i = 0; i < candies; i++) {
            arr[i] = new ArrayList<>();
        }

    }
}
