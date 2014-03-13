#include <iostream>

using namespace std;

void reverse(char* str);

int main(){
	char* str = new char;
	char* start = str;
	cin>>str;
	cout<<start<<endl;
	reverse(str);
	cout<<start<<endl;	
	delete str;
	return 0;
}

void reverse(char* str){
	char* end = str;
	char* p = str;
	while(*end){
		++end;
	}
	--end;
	char temp;
	while(str<end){
		temp = *str;
		*str = *end;
		*end = temp;
		++str;
		--end;
	}
}