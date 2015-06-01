#include <iostream>

using namespace std;
bool check(char *s,char *p){
	if(s==NULL||p==NULL) {
		//cout<<"WAT?"<<endl;
		return false;
	}
	//cout<<*s<<" "<<*p<<endl;
	if(*p=='\0'){
		//cout<<"done"<<endl;
		return *s=='\0';
	}
	
	if(*(p+1)=='*'){
		while((*s!='\0'&&*p=='.')||*s==*p){
			if(check(s,p+2)) return true;
			s++;
		}
		return check(s,p+2);
	}else{
		if((*s!='\0'&&*p=='.')||*s==*p)
		{
			return check(s+1,p+1);
		}
	}
	return false;
}
int main(int argc, char *argv[]) {
	char s[]="aaaabbbbc";
	char p[]=".*b.*";
	if(check(s,p)) cout<<"Good";
	else cout<<"Fail";
}