package com.springSecurityClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Stack;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

//		You are given a string A. An operation on the string is defined as follows:
//		Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
//				Therefore the string after this operation will be "acd".
//				Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
//
//				Input:
//		A = abccbc
//
//		Output:
//		ac
//
//		Input:
//		A = ab
//
//		Output:
//		ab


		SpringApplication.run(DemoApplication.class, args);

		String value="abccbc";
		char firstValue = value.charAt(0);
		Stack<Character> st = new Stack<>();
		st.push(value.charAt(0));

		for(int i=1;i<value.length();i++){
			if(st.peek() == value.charAt(i))
			{
				st.pop();
				//continue;
			}
			else
				st.push(value.charAt(i));
		}

		System.out.println("" +st);

//		Given an integer array A of size N. In one second, you can increase the value of one element by 1.
//
//		Find the minimum time in seconds to make all elements of the array equal.
//
//		A = [2, 4, 1, 3, 2]
//		Output - 8

//		int max=4,sum=0;
//
//		for(int a : array){
//			sum = sum + (max-a);
//
//		}
//		sum;

//		Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
//		If not, return the index where it would be if it were inserted in order.
//
//				A = [1, 3, 5, 10]
//		B = 8
//
//		Output: 3
//
//
//		A = [1]
//		B = 1
//
//		Output: 0

//		int v = Arrays.binarySearch(int arr[],target);
//
//		while(low<high)
//		{
//			mid = low +(high-low)/2;
//			if(arr[mid] < target)
//				low=mid+1;
//			else
//				high=mid;
//
//		}
//		low






	}

}
