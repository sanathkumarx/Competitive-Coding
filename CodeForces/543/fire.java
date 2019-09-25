import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * fire
 */
public class fire {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int nStu = Integer.parseInt(st.nextToken());
        int nClg = Integer.parseInt(st.nextToken());
        int nCho = Integer.parseInt(st.nextToken());
        int ans = nCho;
        st = new StringTokenizer(reader.readLine());
        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        student[] arr = new student[nStu];
        student[] selected = new student[nClg];
        for (int i = 0; i < nClg; i++) {
            selected[i] = new student(0, -1, i + 1);
        }
        for (int i = 0; i < nStu; i++) {
            arr[i] = new student(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
            int clg = arr[i].clg;
            if (selected[clg - 1].power < arr[i].power) {
                selected[clg - 1] = arr[i];
            }
        }
        // for (int i = 0; i < nClg; i++) {
        // System.out.println(selected[i].clg + " " + selected[i].id);
        // }
        st = new StringTokenizer(reader.readLine());
        int[] cho = new int[nCho];
        for (int i = 0; i < nCho; i++) {
            cho[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < nCho; i++) {
            if (arr[cho[i] - 1].id == selected[arr[cho[i] - 1].clg - 1].id) {
                // System.out.println(arr[cho[i] - 1].id + " " + selected[arr[cho[i] - 1].clg -
                // 1].id);
                ans--;
            }
        }
        System.out.println(ans);

    }
}

class student {
    int power;
    int clg;
    int id;

    student(int id, int power, int clg) {
        this.id = id;
        this.power = power;
        this.clg = clg;
    }
}