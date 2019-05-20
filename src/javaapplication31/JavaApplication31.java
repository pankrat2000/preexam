/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Seva
 */
public class JavaApplication31 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        Random random = new Random();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};            //creating of array
        int[] newArray = new int[arr.length];                   //creating the new array with the same number of elements
        
        ArrayList<Integer> indexes = new ArrayList<>(arr.length);    // the ArrayList for work with primitive data type (here it is Integer=int)has been created
        int count = 0;
        while (true) {
            int var = random.nextInt(arr.length);//generating of random number from 0 to array elements amount
            if (!indexes.contains(var)) {
                indexes.add(var);
                newArray[var] = arr[count++];
            }
            if (count == arr.length) {
                break;
            }
        }
        System.out.println(Arrays.toString(newArray));
       int low = 0;
		int high = newArray.length - 1;
 
		quickSort(newArray, low, high);
		System.out.println(Arrays.toString(newArray));
	}
 
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
    
}
