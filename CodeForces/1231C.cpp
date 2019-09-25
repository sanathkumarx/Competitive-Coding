#include<bits/stdc++.h>
#include<iostream>

using namespace std;

int main(){
	int n,m;
	cin >> n >> m;
	bool flag = true;
	int graph[n][m];
	for(int i=0 ; i<n ; i++){
		for(int j=0 ; j<m ; j++){
			cin >> graph[i][j];
		}
	}
	
	for(int i=n-2 , j=m-2 ; i>0 && j>0 ;i--, j--){
		for(int k = j ; k > 0 ; k--){
			if(graph[i][k]==0){
				flag = false;
				int mini = min(graph[i+1][k],graph[i][k+1]) - 1;
				if(mini!=graph[i-1][k] && mini!=graph[i][k-1]){
					graph[i][k]=mini;	
				}
				else{
					cout << -1 << endl;
					return 0;
				}
			}
		}
		for(int k = i ; k > 0 ; k--){
			if(graph[k][j]==0){
				flag = false;
				int mini = min(graph[k+1][j],graph[k][j+1]) - 1;
				if(mini!=graph[k-1][j] && mini!=graph[k][j-1]){
					graph[k][j]=mini;	
				}
				else{
					cout << -1 << endl;
					return 0;
				}
			}
		}
	}
	int sum=0;
	for(int i=0 ; i<n ; i++){
		for(int j=0 ; j<m ; j++){
			sum += graph[i][j];
			if((i < n-1 && graph[i][j] >= graph[i+1][j]) || (j < m-1 && graph[i][j] >= graph[i][j+1])){
				cout << -1 << endl;
				return 0;
			}					
		}
	
	}
	
	cout << sum << endl;
	return 0;
}