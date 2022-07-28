package com.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieList {
	
	public static void main(String[] args) {
		
		Movie m1 = new Movie("HaaryPotter","A1",180,1990);
		Movie m2 = new Movie("Vampire Dairies1","A2",180,1990);
		Movie m3 = new Movie("Vampire Dairies2","A2",45,1991);
		Movie m4 = new Movie("Vampire Dairies3","A4",80,1992);
		Movie m5 = new Movie("Vampire Dairies4","A5",90,1993);
		Movie m6 = new Movie("Vampire Dairies5","A6",88,1994);
		Movie m7 = new Movie("Vampire Dairies6","A2",76,1995);
		Movie m8 = new Movie("Vampire Dairies7","A8",97,1997);
		Movie m9 = new Movie("Vampire Dairies8","A9",56,1998);
		Movie m10 = new Movie("I","A9",220,2002);
		
		List<Movie> movieList = new ArrayList<Movie>();
		
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		movieList.add(m5);
		movieList.add(m6);
		movieList.add(m7);
		movieList.add(m8);
		movieList.add(m9);
		movieList.add(m10);
		
		Map<String, List<String>> movieDirectorNames = new HashMap<String,List<String>>();
		
		for(Movie m: movieList) {
			List<String> allMoviesName = new ArrayList<String>();
			allMoviesName.add(m.getName());
			if(movieDirectorNames.containsKey(m.getDirector_name()))
				movieDirectorNames.get(m.getDirector_name()).add(m.getName());
			else
				movieDirectorNames.put(m.getDirector_name(), allMoviesName);
		}
		
		for(Map.Entry m: movieDirectorNames.entrySet()) {
			System.out.println(m.getKey()+ ": "+ m.getValue());
		}
		
	}

}
