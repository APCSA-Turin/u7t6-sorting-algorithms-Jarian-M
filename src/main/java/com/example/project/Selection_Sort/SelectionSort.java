package com.example.project.Selection_Sort;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class SelectionSort {

    // PART A. implementing selection sort
    public static int[] selectionSort(int[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < elements.length; j++) {
                if(elements[j] < elements[min]) {
                    min = j;
                }
            }
            int temp = elements[i];
            elements[i] = elements[min];
            elements[min] = temp;
        }
        return elements;
    }


    // PART B. sorting a 1000-word list
    public static ArrayList<String> selectionSortWordList(ArrayList<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            int min = i;
            for(int j = i + 1; j < words.size(); j++) {
                int comparison = words.get(j).compareTo(words.get(min));
                if( comparison < 0) {
                    min = j;
                }
            }
            words.set(i, words.set(min, words.get(i)));
        }

        return words;
    }

    //call this method to load 1000 words into list. Use it to test Part B
    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return wordList;
    }

    public static void main(String[] args) {
        ArrayList<String> words = SelectionSort.loadWordsInto(new ArrayList<String>());
        System.out.println(words);
        words = SelectionSort.selectionSortWordList(words);
        System.out.println();
        System.out.println(words);
        boolean pass = true;
        for(int i=1; i < words.size();i++){
            if(words.get(i).compareTo(words.get(i-1))<0){ //not in alphabetical order
                pass = false; 
            }
        }
        System.out.println(pass);
    }
}