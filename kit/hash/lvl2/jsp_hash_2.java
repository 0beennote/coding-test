package kit.hash.lvl2;

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
		String[] phone_book = { "119", "97674223", "1195524421" };
		boolean solution = solution(phone_book);
		log.info("{}", solution);
	}

	public boolean solution(String[] phone_book) {
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[i].length() > phone_book[j].length() && phone_book[i].startsWith(phone_book[j])) {
					return false;
				} else if (phone_book[i].length() < phone_book[j].length() && phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		return true;
	}
}
