package org.elyograg.fibservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.elyograg.fibservice.util.Common;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FibserviceApplicationTests {

	@Test
	public void contextLoads() {
		//
	}

	@Test
	public void testSequence() {
		List<Long> actual = null;
		List<Long> expected = null;
		actual = Common.getFibonacciSequence(5);
		expected = Arrays.asList(0L, 1L, 1L, 2L, 3L);
		assertThat(actual, is(expected));
		actual = Common.getFibonacciSequence(8);
		expected = Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L);
		assertThat(actual, is(expected));
	}
}
