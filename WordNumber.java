package javaapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordNumber {

  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<String> words = new ArrayList<String>();
    //word count
    ArrayList<Integer> count = new ArrayList<Integer>();

   
    File file = new File("E:\\Java\\javaapplication\\src\\javaapplication\\Text.txt");
    // Please select the path of the Text.txt where you have download or moved
    //Text.txt contains : The quick brown fox jumps over the lazy dog. The lazy dog slept.
    Scanner scanner = new Scanner(file);


    // read the file 
    while (scanner.hasNext()) {
      String nextLine = scanner.nextLine();
      // for removing punctual marks
      String lineWithoutPunctuation = nextLine.replaceAll("[^a-zA-Z ]", "");

      for (String word : lineWithoutPunctuation.split(" ")) {
    	 // word = word.toLowerCase(); // for case insensitive
    	  if (!word.isEmpty()) {
    		  processWord(word, words, count);
    		  
    	  }
      }
    }

    scanner.close();

    // Print the results
    for (int i = 0; i < words.size(); i++) {
      System.out.println(words.get(i) + " : " + count.get(i) + " times");
    }
  }

  // method for counting word 
  private static void processWord(String word, ArrayList<String> words, ArrayList<Integer> count) {
    if (words.contains(word)) {
    	
      int index = words.indexOf(word);
      count.set(index, count.get(index) + 1); // for duplicate word +1
      // System.out.println(word +" Duplicate");
    } else {
      words.add(word);
     // System.out.println(word+" first time");
      count.add(1);
    }
  }
}
