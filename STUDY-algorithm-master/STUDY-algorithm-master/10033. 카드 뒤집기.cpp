#include <iostream>

int main(void) {
	int t, total_cnt, a_cnt;
	long long ans;
	char cards[200001];
    
	scanf("%d", &t);
	
    for (int t_i = 1; t_i <= t; t_i++) {
		scanf("%s", cards);
		total_cnt = a_cnt = ans = 0;
		for (int i = 0; cards[i]; i++) {
			total_cnt++;
			if (cards[i] == 'W') {
				a_cnt++;
				ans += total_cnt - a_cnt;
			}
		}
		printf("#%d %lld\n", t_i, ans);
	}
	return 0;
}