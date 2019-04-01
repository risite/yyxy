package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class test2 {

	@Test
	public void test() {
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
//		// ÄÉÃë
//		long t0 = System.nanoTime();
//
//		long count = values.stream().sorted().count();
//		System.out.println(count);
//
//		long t1 = System.nanoTime();
//
//		// ÄÉÃë×ªÎ¢Ãë
//		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//		System.out.println(String.format("Ë³ÐòÁ÷ÅÅÐòºÄÊ±: %d ms", millis));

		// Ë³ÐòÁ÷ÅÅÐòºÄÊ±: 899 ms

		// ÄÉÃë
		long t0 = System.nanoTime();

		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		// ÄÉÃë×ªÎ¢Ãë
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("²¢ÐÐÁ÷ÅÅÐòºÄÊ±: %d ms", millis));

		// ²¢ÐÐÁ÷ÅÅÐòºÄÊ±: 472 ms

	}
}