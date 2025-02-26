package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import com.example.project.Selection_Sort.SelectionSort;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int count = 0;
        for(int i = 1; i < elements.length; i++) {
            int ind = i;
            int temp = elements[ind];
            while(ind > 0 && elements[ind] < elements[ind - 1]) {
                elements[ind] = elements[ind - 1];
                elements[ind - 1] = temp;
                ind--;
                count++;
            }
        }
        System.out.println("INSERTION SORT: NUMBER OF ITERATIONS: " + count);
        return elements;
    }


    public static void selectionSort(int[] elements) {
        int count = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < elements.length; j++) {
                if(elements[j] < elements[min]) {
                    min = j;
                }
                count++;
            }
            int temp = elements[i];
            elements[i] = elements[min];
            elements[min] = temp;
        }
        System.out.println("SELECTION SORT: NUMBER OF ITERATIONS: " + count);
    }

    public static void main(String[] args) {
        /* int[] arrA = {62,99,6,53,82,41,81,53,44,22,23,80,84,87,54,64,91,2,71,81,29,59,89,63,50,81,91,7,3,12,46,62,89,5,11,96,63,37,48,85,47,19,57,45,21,50,27,12,27,26};
        InsertionSort.selectionSort(arrA);
        System.out.println(Arrays.toString(arrA));
        System.out.println();
        int[] arrB = {62,99,6,53,82,41,81,53,44,22,23,80,84,87,54,64,91,2,71,81,29,59,89,63,50,81,91,7,3,12,46,62,89,5,11,96,63,37,48,85,47,19,57,45,21,50,27,12,27,26};
        InsertionSort.insertionSort(arrB);
        System.out.println(Arrays.toString(arrB)); */

        ArrayList<String> words1 = SelectionSort.loadWordsInto(new ArrayList<String>());
        InsertionSort.selectionSortWordList(words1);
        ArrayList<String> words2 = SelectionSort.loadWordsInto(new ArrayList<String>());
        InsertionSort.insertionSortWordList(words2);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int count = 0;
        for(int i = 1; i < words.size(); i++) {
            int ind = i;
            String temp = words.get(i);
            while(ind > 0 && temp.compareTo(words.get(ind - 1)) < 0) {
                words.set(ind, words.get(ind - 1));
                words.set(ind - 1, temp);
                ind--;
                count++;
            }
        }
        System.out.println("INSERTION SORT: NUMBER OF ITERATIONS: " + count);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int count = 0;
        for (int i = 0; i < words.size() - 1; i++) {
            int min = i;
            for(int j = i + 1; j < words.size(); j++) {
                int comparison = words.get(j).compareTo(words.get(min));
                if( comparison < 0) {
                    min = j;
                }
                count++;
            }
            words.set(i, words.set(min, words.get(i)));
        }
        System.out.println("SELECTION SORT: NUMBER OF ITERATIONS: " + count);
    }

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
}