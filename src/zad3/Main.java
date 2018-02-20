package zad3;

import java.io.IOException;

public class Main {
	
	public static void main(String [] args) throws IOException {
		Data data = new Data();
		GUI gui = new GUI();
		gui.perform(data);
	}
}
