package com.coderscampus.testing.src.com.coderscampus.arraylist;

public class CustomListApplication {

	public static void main(String[] args) {

		// instantiate our new customList
		CustomList<String> names = new CustomArrayList<>();

		// test to add more than 10 elements
		for (int i = 1; i <= 15; i++) {
			names.add("John Doe " + "#" + i);
		}
		
		System.out.println("-----------");
		System.out.println("Print all elements added to the Custom List Array");
		System.out.println();
		
		// now print all those elements and check to make sure there are no "null" values
		for (int i = 0; i < names.getSize(); i++) {

			System.out.println(names.get(i));
		}
		
		System.out.println();
		System.out.println("-----------");
		System.out.println("Get the 7th element from our ArrayList");
		System.out.println();
		
		// use the getIndex method to check if it works as well -> should print John Doe #7
		System.out.println(names.get(7));
		boolean hmm = names.add(15, "Mel");
		System.out.println(hmm);


	}

}
