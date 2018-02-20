package zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	static ArrayList<Integer> readFile(String fileName) throws IOException {
			
      ArrayList<Integer> data = new ArrayList<Integer>();
          
      try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
   	   String line;
   	   while ((line = br.readLine()) != null) {
   		   for (char c : line.toCharArray()) {
   			   if (c != ' ') {
   			   	c = changeSymbolToValue(c);
   			   	
	        		   if (Integer.valueOf(c) > 14) 
	        			   data.add(Integer.valueOf(c - 48));
	        		   else 
	    				 	data.add(Integer.valueOf(c));
   			   }   
   		   }
   	   }
      }
      return data;
	}
	
    // should be some switch
	static char changeSymbolToValue(char c) {
		if (c == 'T')
		   c = 10;
		   if (c == 'J')
		  	   c = 11;
		   if (c == 'Q')
			   c = 12;
		   if (c == 'K')
			   c = 13;
		   if (c == 'A')
			   c = 14;
		   if (c == 'H')
			   c = 1;
		   if (c == 'D')
			   c = 2;
		   if (c == 'S')
			   c = 3;
		   if (c == 'C')
			   c = 4; 
		
		return c;
	}
}
