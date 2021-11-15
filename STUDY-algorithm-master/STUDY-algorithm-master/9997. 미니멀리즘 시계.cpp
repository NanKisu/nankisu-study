#include <iostream>

int main(void) {
	int t, n, h, m;
	scanf("%d", &t);
	for (int t_i = 1; t_i <= t; t_i++) {
		scanf("%d", &n);
		h = n / 30;
		m = (n % 30) * 2;
		printf("#%d %d %d\n", t_i, h, m);
	}
	return 0;
}