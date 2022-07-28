package com.tests;

import java.util.*;

public class DemoLinkedList {

 public static void main(String args[])
 {
     LinkedList<String> ll = new LinkedList<String>();
     
     Collection<String> collect = new ArrayList<String>();
     collect.add("My");
     collect.add("Name");
     collect.add("is");
     collect.add("sudhanshu");
     ll.add("D");
     ll.addAll(collect);
     ll.addFirst("D");
     ll.addLast("C");
     ll.add("A");
     
     System.out.println(ll);
     System.out.println("Index is: "+ ll.indexOf("Name"));
     System.out.println("Last index of:" +ll.lastIndexOf("D"));
     System.out.println(ll.peekFirst());
     System.out.println(ll.peekLast());
     System.out.println(ll.pollFirst());
     System.out.println(ll.pollLast());
     System.out.println(ll.size());
 }
}