#include <iostream>


int L, N, Ans;
int Peak[100010][2];

void input() {
	scanf("%d %d", &L, &N);
	for (int i = 1; i <= N; i++) {
		scanf("%d %d", &Peak[i][0], &Peak[i][1]);
	}
}

void getAns() {
	int i_s, i_e, start, end, time, left;
	i_s = i_e = 1;
	time = 0;
	while (i_s <= N) {
		start = Peak[i_s][0];
		end = start + L;
		while (i_e <= N && end >= Peak[i_e][1]) {
			time += Peak[i_e][1] - Peak[i_e][0];
			i_e++;
		}
		left = 0;
		if (i_e <= N && end > Peak[i_e][0]) {
			left = end - Peak[i_e][0];
		}
		if (time + left > Ans)
			Ans = time + left;
		if(i_e > i_s)
			time -= (Peak[i_s][1] - Peak[i_s][0] >= L ? L : Peak[i_s][1] - Peak[i_s][0]);
		i_s++;
		if (i_e < i_s)
			i_e = i_s;
	} 
}

int main(void) {
	int t;
	scanf("%d", &t);
	for (int t_i = 1; t_i <= t; t_i++) {
		Ans = 0;
		input();
		getAns();
		printf("#%d %d\n", t_i, Ans);
	}
	return 0;
}