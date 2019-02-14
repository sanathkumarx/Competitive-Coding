/*
5 5 2 2 1 2 2 5 5 5
5 2 1 2 5
5 2 5
5

1 2 3

8 3 1 3 9 9 3 0 1
8 3 1 3 9 3 0 1
8 3 9 3 0 1
8 3 0 1
8 3 1
8 1
8


4 5 2 1 3 5
5 2 1 3 5
5 1 3 5
5 3 5
5



*/
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class floodfill{
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<Integer> listt = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int prev=-1;
            for(int i=0;i<n;i++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp!=prev){
                    listt.add(temp);
                    prev = temp;
                }
            }
            int ans = 0;
            while(listt.size()>2){
                for(int i=1;i<listt.size();i++){
                    if((i+1)<listt.size() && listt.get(i-1)==listt.get(i+1)){
                        int frm = listt.remove(i);
                        Integer to = listt.remove(i);
                        for(int j=0;j<listt.size();j++){
                            if(listt.get(j)==frm){
                                listt.set(j, to);
                            }
                        }
                        ans++;
                        break;
                    }
                    if(i==(listt.size()-1)){
                        int frm1 = listt.get(i-2);
                         Integer to1 =listt.get(i);
                        listt.set(i-2, to1);
                        for(int j=0;j<listt.size();j++){
                            if(listt.get(j)==frm1){
                                listt.set(j, to1);
                            }
                        }
                        ans++;
                    }
                }
                //System.out.println("After "+listt.toString());
            }
            if(listt.size()==2 &&(listt.get(0)!= listt.get(1)))ans++;
            System.out.println(ans);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

                        // int temp = i;
                        // ans++;
                        // while(temp>-1){
                        //    int tempo = listt.get(temp);
                        //    System.out.println("rem "+listt.remove(temp));
                        //     if(listt.contains(tempo)){
                        //         listt.add(tempo);
                        //         temp--;
                        //     }else{
                        //         break;
                        //     }
                        // }
                        // if(temp==-1){
                        //     listt.remove(0);
                        // }