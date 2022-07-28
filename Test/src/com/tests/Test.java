package com.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Test {
	
   public static void main(String[] args) {
	   
      List<String> languageList = new ArrayList<String>();
      languageList.add("C");
      languageList.add("C++");
      languageList.add("Java");
      languageList.add("Python");
      languageList.add("Kotlin");
      languageList.add("save");
      languageList.add("vase");
      
      System.out.println("The size of the ArrayList is: " + languageList.size());
      System.out.println("ArrayList is Empty:" + languageList.isEmpty());
      System.out.println("ArrayList at index:" +languageList.get(0));
      languageList.set(3, "Python3");
      System.out.println("List after changes:"+languageList);
      
      List<String> secondList = new ArrayList<String>();
      secondList.add("HTML");
      secondList.add("CSS");
      secondList.add("JS");
      secondList.add("REACT");
      
      System.out.println("The second list is :"+secondList);
      languageList.addAll(secondList);
      
      System.out.println("After appending to the list"+languageList);
      
      List<String> anagramaList = new ArrayList<>();
      
      for(int i = 0; i < languageList.size()-1; i++) {
    	  for(int j = i+1; j<languageList.size(); j++) {
    		  char prev[] = languageList.get(i).toCharArray();
    		  Arrays.sort(prev);
    		  char next[] = languageList.get(j).toCharArray();
    		  Arrays.sort(next);
    		  if(new String(prev).equals(new String(next))) {
    			  anagramaList.add(languageList.get(i));
    			  anagramaList.add(languageList.get(j));
    		  }
    	  }
      }
      
     System.out.println("Anagrams are:" +anagramaList);
   }
}