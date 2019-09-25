#include<bits/stdc++.h>
#include<iostream>

using namespace std;

int main(){
	int n,k;
	string s;
	cin >> n >> k >> s;
	if(k==0){
		cout << s << endl;
		return 0;
	}
	if(n==1){
		cout << 0 << endl;
		return 0;
	}
	if(s[0]!='1'){
		s[0] = '1';
		k--;
	}
	for(int i = 1 ; k>0 && i < s.length() ; i++){
		if(s[i]!='0'){
			s[i] = '0';
			k--;
		}
	}
	cout << s << endl;
	return 0;
}