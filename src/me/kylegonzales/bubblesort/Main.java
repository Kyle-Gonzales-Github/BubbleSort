package me.kylegonzales.bubblesort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static int staticNumber = 0;
	private static int startArray = 0;
	
	public static void main(String[] args) {
		int[] array = new int[5];
		
		Scanner scanner = new Scanner(System.in);
		while (staticNumber < 5) {
			System.out.println("Please enter an integer (5 times)");
			int number = scanner.nextInt();
			array[startArray] = number;
			startArray++;
			staticNumber++;
		}
		scanner.close();
		writeArrayToFile(array, "integers.txt");
		System.out.println("");
		System.out.println("Array saved to integers.txt! Now sorting!");
		System.out.println("");
		printArray(array);
		bubbleSort(array);
		writeArrayToFile(array, "sorted.txt");
		System.out.println("");
		System.out.println("Array saved to sorted.txt! Done!");
		
		
		//bubbleSort(array);
		//writeArrayToFile(array, "sorted.txt");
		//System.out.println("Done!");
	}
	
	
	public static int[] createRandomArray(int arrayLength) {
		int[] array = new int[arrayLength];
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(100);
		}
		return array;
	}
	
	public static void writeArrayToFile(int[] array, String filename) {
		try {
			FileWriter fileWriter = new FileWriter(filename);
			for (int a : array) {
				fileWriter.write(a + "\n");
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int[] readArrayFromFile(String fileName) { //Same as readFileToArray
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			ArrayList<Integer> arraylist = new ArrayList<Integer>();
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine();
				int a = Integer.parseInt(str);
				arraylist.add(a);
			}
			int[] array = new int [arraylist.size()];
			for (int i = 0; i < arraylist.size(); i++) {
				array[i] = (int) arraylist.get(i);
			}
			scanner.close();
			return array;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void printArray(int[] array) {
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println(" ");
	}
	
	public static void bubbleSort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			printArray(array);
		}
	}

}
