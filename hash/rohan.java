import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

class rohan {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("c_memorable_moments.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int nCases = Integer.parseInt(br.readLine());
        Picture[] pics = new Picture[nCases];
        for (int i = 0; i < nCases; i++) {
            String[] arr = br.readLine().split(" ");
            String type = arr[0];
            int nFeat = Integer.parseInt(arr[1]);
            HashSet<String> tags = new HashSet<String>();
            for (int j = 0; j < nFeat; j++) {
                tags.add(arr[j + 2]);
            }
            pics[i] = new Picture(i, type, nFeat, tags);
        }
        int max = 1, maxj = 0, n = 0;
        // int[][] points = new int[nCases][nCases];
        for (int i = 0; max != 0; i = maxj) {
            max = 0;
            for (int j = 0; j < nCases; j++) {
                if (pics[j].nTags > 0 && i != j) {
                    // points[i][j] = score(pics[i], pics[j]);
                    int a = score(pics[i], pics[j]);
                    if (a > max) {
                        max = a;
                        maxj = j;
                    }
                }
            }
            System.out.println(maxj);
            pics[i].nTags = 0;
            n++;
        }
        System.out.println(n);
        /*
         * int aindex = 0; int bindex = 0; int score = 0; int anz = 0; for (int i = 0; i
         * < nCases; i++) { score = 0; for (int j = 0; j < nCases; j++) { if
         * (points[j][i] > score) { score = points[j][i]; aindex = j; bindex = i; } } if
         * (score > 0) { anz += score; System.out.println(aindex);
         * System.out.println(bindex); } }
         */
    }

    public static int score(Picture a, Picture b) {
        HashSet<String> atags = new HashSet<String>(a.tags);
        HashSet<String> btags = new HashSet<String>(b.tags);
        atags.retainAll(btags);
        int size1 = atags.size();
        atags = new HashSet<String>(a.tags);
        atags.removeAll(btags);
        int size2 = atags.size();
        btags.removeAll(a.tags);
        int size3 = btags.size();

        size1 = Math.min(size1, size2);
        size1 = Math.min(size1, size3);
        return size1;
    }
}

class Picture {
    int id;
    String type;
    int nTags;
    HashSet<String> tags;

    Picture(int id, String type, int nTags, HashSet<String> tags) {
        this.id = id;
        this.type = type;
        this.nTags = nTags;
        this.tags = tags;
    }

}
