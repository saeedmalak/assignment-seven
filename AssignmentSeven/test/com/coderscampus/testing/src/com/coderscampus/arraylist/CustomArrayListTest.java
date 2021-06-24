package com.coderscampus.testing.src.com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {
	// Test-Driven Development Methodology
	// Step 1 - Write a failing test
	// Step 2 - Write the business logic to make the test pass  
	// Step 3 - Refactor your code
	@Test
	void should_add_one_item_to_list() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		sut.add(15);
		Integer expectedResult = sut.get(0);
		Integer expectedSize = sut.getSize();
		
		// Assert
		//  I expect there to be an Integer with value 15 stored in the first index in my customList
		assertEquals(15, expectedResult);
		assertEquals(1, expectedSize);
		
	}
	
	@Test
	void should_add_100000_to_list() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		for (int i = 0; i <= 99999; i++) {
			sut.add(i);
		}
		
		// Assert
		for (int i = 0; i < 99999; i++) {
			assertEquals(i, sut.get(i));
		}
		
		assertEquals(100000, sut.getSize());
	}
	
	@Test
	void should_add_extra_item_at_index_22() {
		// Arrange
		CustomList<String> sut = new CustomArrayList<>();
		
		// Act
		for (int i = 0; i < 30; i++) {
			sut.add("John Doe " + "#" + i);
		}
		sut.add(22, "James Bond");
		Integer expectedSize = sut.getSize();
		
		// Assert
		//  I expect there to be an extra String with value "James Bond" stored at index 22 in my expanded customList of 31 items
		for (int i = sut.getSize()-1; i >= 0; i--) {
			if (i > 22) {
				assertEquals("John Doe " + "#" + (i-1), sut.get(i));
			} else if (i == 22) {
				assertEquals("James Bond", sut.get(i));
			} else if (i < 22) {
				assertEquals("John Doe " + "#" + (i), sut.get(i));
			}
		}
		assertEquals(31, expectedSize);
	}
	
	@Test
	void should_remove_item_at_index_7() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		for (int i = 0; i < 20; i++) {
			sut.add(i);
		}
		sut.remove(7);
		Integer expectedSize = sut.getSize();
		
		// Assert
		//  I expect item #8 from my customList to be removed with a new total of 19 items
		for (int i = 0; i > sut.getSize(); i++) {
			if (i < 7) {
				assertEquals(i, sut.get(i));
			} else {
				assertEquals((i+1), sut.get(i));
			} 
		}
		assertEquals(19, expectedSize);
	}

}
