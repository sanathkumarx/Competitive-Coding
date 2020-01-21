#include<bits/stdc++.h>
#include<iostream>

using namespace std;
int connected(vector<int> graph[], int glob[]);

int main(){
    int n;
    cin >> n;
    string str;
    vector<int> graph[26];
    unordered_set <string> stringSet ;
    int glob[26] = {};
    while(n--){
        string temp;
        cin >> str;
        int arr[26]={};
        int c1 = -1;
        for(int i=0;i<str.length();i++){
            arr[int(str[i])-int('a')]++;
            glob[int(str[i])-int('a')]++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]>0)
                temp+=to_string(i);
        }
        
        if(stringSet.find(temp) == stringSet.end()){
            for(int i=0;i<26;i++){
                if(arr[i]>0){
                    c1=i;
                    break;
                    
                }
            }
            for(int i=c1+1 ; i<26;i++){
                
                if(arr[i]>0){
                    graph[c1].push_back(i);
                    graph[i].push_back(c1);
                }
            }
            stringSet.insert(temp);
        }
    }
    // for(string str:stringSet){
    //     int c1 = int(str[0])-int('a');
    //     for(int i=1;i<str.length();i++){
    //         graph[c1].push_back(int(str[i])-int('a'));
    //         graph[int(str[i])-int('a')].push_back(c1);
    //     }
    // }
    cout << connected(graph, glob)<<endl;

}

int connected(vector<int> graph[], int glob[]){
    int visited[26] = {};
    stack<int> stk;
    int count =0;

    for(int i=0;i<26;i++){
        
        if(visited[i]==0 && graph[i].size()!=0){
            
            count++;
            stk.push(i);
            while(!stk.empty()){
                int curr = stk.top();
                stk.pop();
                visited[curr]=1;
                
                for(int i : graph[curr]){
                    
                    if(visited[i]!=1)
                    stk.push(i);
                }
                
            }
        }
    }
    for(int i=0;i<26;i++){
        
        if(visited[i]==0 && glob[i]>0){
            count++;}
    }
    return count;

}