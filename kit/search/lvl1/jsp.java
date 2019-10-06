package kit.search.lvl1;


public int[] solution(int[] answers) {
		int[] solution = { 0, 0, 0 };
		int[] s1 = { 1, 2, 3, 4, 5 };
		int[] s2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] s3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == s1[i % 5]) {
				solution[0]++;
			}
			if (answers[i] == s2[i % 8]) {
				solution[1]++;
			}
			if (answers[i] == s3[i % 10]) {
				solution[2]++;
			}
		}

		int max = Math.max(solution[0], Math.max(solution[1], solution[2]));
		ArrayList<Integer> list = new ArrayList<>();
		if (solution[0] == max) {
			list.add(1);
		}
		if (solution[1] == max) {
			list.add(2);
		}
		if (solution[2] == max) {
			list.add(3);
		}

		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
		}

		return a;
	}
