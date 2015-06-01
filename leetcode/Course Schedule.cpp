#include <iostream>
#include <vector>

using namespace std;

    vector<bool> courses;
    void resetCourses() {
        for(int i = 0; i < courses.size(); i++) {
            courses[i] = true;
        }
    }
    
    bool search(int c, vector<vector<bool> >& m) {
//		  cout<<"c = "<<c<<endl;
        if(courses[c] == false) return false;
        else {
				courses[c] = false;
            for(int i = 0; i < m.size(); i++) {
//					cout<<"m["<<c<<"]["<<i<<"]="<<m[c][i]<<" courses[i]="<<courses[i]<<endl;
                if (m[c][i]) {
						 if (!courses[i]) {
							return false;
						}
                    if(search(i,m) == false) return false;
                }
            }
				courses[c] = true;
        }
        return true;
    }
    bool canFinish(int numCourses, vector<vector<int> >& prerequisites) {
        vector<vector<bool> > m(numCourses, vector<bool>(numCourses));
        courses.resize(numCourses);
        
        for(int i = 0; i < prerequisites.size(); i++) {
            m[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        
//		  for(int i = 0; i < numCourses; i ++) {
//			for (int j = 0; j < numCourses; j ++) {
//				cout<<m[i][j]<<" ";
//			}
//			cout<<endl;
//		}	
		
        for(int i = 0; i < numCourses; i ++) {
//				cout<<"i = "<<i<<endl;
            resetCourses();
            if(!search(i, m)) return false;
        }
        
        return true;
    }

int main(int argc, char *argv[]) {
	vector<vector<int> > test;
	vector<int> t;
	t.push_back(1);
	t.push_back(0);
	test.push_back(t);
	t[0] = 0;
	t[1] = 1;
	test.push_back(t);
	cout<<canFinish(2,test)<<endl;
}