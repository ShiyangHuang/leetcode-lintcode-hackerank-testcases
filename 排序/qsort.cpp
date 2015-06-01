#include <iostream>
using namespace std;

void swap(int &a, int &b) {
	int tmp = a;
	a = b;
	b = tmp;
}

void qsort(int a[], int start, int end) {
	int l = start, r = end;
	int tmp = a[l];
	while (l < r) {
		while (l < r && tmp < a[r]) {
			r--;
		}
		if (l < r) {
			a[l] = a[r];
			l++;
		}
		while (l < r && tmp > a[l]) {
			l++;
		}
		if (l < r) {
			a[r] = a[l];
			r--;
		}
	}
	a[l] = tmp;
	if (start < l) qsort(a, start, r-1);
	if (l < end) qsort(a, r + 1, end);
}

int main(int argc, char *argv[]) {
	int a[] = {1,4,3,2,6,5,7,9,8,0};
	qsort(a,0,9);
	for(int i = 0; i < 10; i++) {
		cout<<a[i]<<endl;
	}
}