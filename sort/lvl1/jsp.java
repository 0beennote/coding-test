package com.example.demo;

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
		int[] b = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] a = new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] solution = solution(b, a);
		log.info("{} {} {}", solution[0], solution[1], solution[2]);
	}

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] command = commands[i];
			int[] copyOfRange = Arrays.copyOfRange(array, command[0] - 1, command[1]);
			Arrays.sort(copyOfRange);
			answer[i] = copyOfRange[command[2] - 1];
		}
		return answer;
	}
}
