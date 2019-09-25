import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.io.*;


public class arithematicP{
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine());
            Integer[] arr = new Integer[num];
            for(int i=0;i<num;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> listt = new ArrayList<>(Arrays.asList(arr));
            int lo = 0;
            int hi = 1000000000;
            ahh:
            while(lo<hi){
                Integer mid = (hi-lo)/2;
                // print("> "+mid);
                // hi = mid;
                // if(Integer.parseInt(reader.readLine())==0){
                //
                // }else{
                //     break;
                // }

                hi=mid;
                System.out.println(listt.toString()+" "+hi);
                for(int i=0;i<listt.size();i++){
                    if(listt.get(i)>mid){
                        break ahh;
                    }
                }
            }
            // for(int i = hi;i>0;i--){
            //     print("> ")
            // }
            // System.out.println(hi);


        } catch (Exception e) {

        }
    }

    public static void print(String s){
        System.out.println(s);
        System.out.flush();
    }
}