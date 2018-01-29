package com.revature.hello;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		
		System.out.println(Arrays.toString(streamOfArray.toArray()));
		
		Stream<Integer> streamIterated = Stream.iterate(2, n -> n * 2).limit(20);
		System.out.println(Arrays.toString(streamIterated.toArray()));
		
		IntStream.range(1, 9).mapToObj(i -> "Putting " + i + " bottles of beer on the wall...").forEach(System.out::println);

	}

}
