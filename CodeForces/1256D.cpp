#include<bits/stdc++.h>
#include<iostream>

using namespace std;

int main(){
    int t;
    cin >> t;
    string one="1",zer="0";
    while(t--){
        int n,k;
        string s,res;
        bool flag = false;
        cin >> n >> k >> s;
        int count=0;
        for(int i=0;i<n;i++){
            if(k>0){
                if(s[i]=='1'){
                    count++;
                }
                else{
                    if(count <= k ){
                        k -= count;
                        res += zer;
                    }
                    else{
                        for(int j=0;j<count-k;j++){
                            res += one;
                            count--;
                        }
                        res += zer;
                        while(count>0){
                            res += one;
                            count--;
                        }
                        k=0;
                    }
                }
            }
            else{
                res += s[i];
            }
        }
        cout << res <<" "<<count<< endl;
}
}