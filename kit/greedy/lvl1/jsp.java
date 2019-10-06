package kit.greedy.lvl1;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("run");
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };
		int solution = solution(n, lost, reserve);
		log.info("{}", solution);
	}

	public int solution(int n, int[] lost, int[] reserve) {
		int[] students = new int[n];
		Arrays.fill(students, 1);
		int max = Math.max(lost.length, reserve.length);
		for (int i = 0; i < max; i++) {
			if (i < lost.length) {
				students[lost[i] - 1]--;
			}
			if (i < reserve.length) {
				students[reserve[i] - 1]++;
			}
		}
		log.info("aaa {}", students);
		for (int i = 0; i < students.length; i++) {
			if (students[i] == 2) {
				if (i - 1 >= 0 && students[i - 1] == 0) {
					students[i - 1]++;
					students[i]--;
				} else if (i + 1 < students.length && students[i + 1] == 0) {
					students[i + 1]++;
					students[i]--;
				}
			}
		}
		log.info("bbb {}", students);
		return (int) Arrays.stream(students).filter(i -> i > 0).count();
	}
}
