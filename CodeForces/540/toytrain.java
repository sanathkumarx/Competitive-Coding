import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * toytrain
 */
public class toytrain {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int nStations = Integer.parseInt(st.nextToken());
        int nPackages = Integer.parseInt(st.nextToken());
        TreeSet[] sets = new TreeSet[nStations];
        for (int i = 0; i < nStations; i++) {
            sets[i] = new TreeSet<>();
        }
        for (int i = 0; i < nPackages; i++) {
            st = new StringTokenizer(reader.readLine());
            sets[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

    }
}