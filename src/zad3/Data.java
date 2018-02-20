package zad3;

import java.io.IOException;
import java.util.ArrayList;

public class Data  {
	
	private static ArrayList<Integer> data = new ArrayList<Integer>();
	
	void loadDataFromFile(String fileName) throws IOException {
		this.setData(FileManager.readFile(fileName));
	}

	public static ArrayList<Integer> getData() {
		return data;
	}

	public void setData(ArrayList<Integer> data) {
		Data.data = data;
	}
}