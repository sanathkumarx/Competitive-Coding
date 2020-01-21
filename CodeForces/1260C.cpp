#include<bits/stdc++.h>
#include<iostream>

using namespace std;

int main()
{
    int t;
    cin >> t;
    while(t--){
        int r,b,k,last;
        cin >> r >> b >> k;
        int mini = min(r,b);
        if(k==1 || abs(r-b)/mini>=k){
            cout << "REBEL" << endl;
            continue;
        }
        if(r==b){
            cout <<"OBEY"<<endl;
            continue;
        }

        last = mini;
        int R=r;
        int B=b;
        int  rm=0, bm=0, rl=0, bl=0;
        while(true){
            if(R==B){
                break;
            }         
            else if(R<B){
                if(last!=r){
                    bl=0;
                }
                rl++;
                last = r;
                R += r;
            }
            else{
                if(last!=b){
                    rl=0;
                }
                bl++;
                last = b;
                B += b;
            }
            if(rl>rm)rm=rl;
            if(bl>bm)bm=bl;
            if(rm>=k || bm>=k)break;
            
        }

            //cout << rm << " " << bm << endl;
            if(rm>=k || bm>=k)
                cout << "REBEL" << endl;
            else
                cout << "OBEY" << endl;
        }
    }
