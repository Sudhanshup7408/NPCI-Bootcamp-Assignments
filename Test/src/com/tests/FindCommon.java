package com.tests;

import java.util.*;
public class FindCommon {
public static void main(String[] args) {
	
      HashSet<String> a_set = new HashSet<String>();
      	a_set.add("A");
      	a_set.add("B");
      	a_set.add("C");
      	a_set.add("D");
        System.out.println("First HashSet content: "+a_set);
        
        HashSet<String>b_set = new HashSet<String>();
        b_set.add("X");
        b_set.add("D");
        b_set.add("B");
        b_set.add("Z");
        System.out.println("Second HashSet content: "+b_set);
        
        a_set.retainAll(b_set);
        
        System.out.println("Common Data:");
        System.out.println(a_set);
   }
}