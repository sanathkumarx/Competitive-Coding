    #include<bits/stdc++.h>
    #include<iostream>
     
    using namespace std;
     
    int main(){
    	string s;
    	char minz;
    	cin >> s;
    	minz = s[0];
     
    	for(int i=0;i<s.length();i++){
    		if(s[i]>minz){
    			cout << "Ann" << endl;
    		}
    		else{
    			cout << "Mike" << endl;
    			minz = s[i];
    		}
    	}
    }
