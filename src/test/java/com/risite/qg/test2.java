package com.risite.qg;

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
//		// ����
//		long t0 = System.nanoTime();
//
//		long count = values.stream().sorted().count();
//		System.out.println(count);
//
//		long t1 = System.nanoTime();
//
//		// ����ת΢��
//		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//		System.out.println(String.format("˳���������ʱ: %d ms", millis));

		// ˳���������ʱ: 899 ms

		// ����
		long t0 = System.nanoTime();

		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		// ����ת΢��
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("�����������ʱ: %d ms", millis));

		// �����������ʱ: 472 ms

	}
}