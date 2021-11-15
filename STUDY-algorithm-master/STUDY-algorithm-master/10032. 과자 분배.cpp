#pragma warning(disable4996)
#include iostream
using namespace std;

int main(void) {
	int t, n, k;
	scanf(%d, &t);
	for (int t_i = 1; t_i = t; t_i++) {
		scanf(%d %d, &n, &k);
		printf(#%d %dn, t_i, (n%k) != 0);
	}
	while(1){}
	return 0;
}