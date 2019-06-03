package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

	public static List<String> readFile() throws IOException{
		List<String> listLines;
		listLines = Files.readAllLines(Paths.get("src/data/jugadores10k.csv"));
		return listLines;		
	}
	
	public static List<String> readFileWeather() throws IOException{
		List<String> listLines;
		listLines = Files.readAllLines(Paths.get("src/data/datosClimaSinresolver.csv"));
		return listLines;		
	}
	
	public static List<String> readFileLanzamientos() throws IOException{
		List<String> listLines;
		listLines = Files.readAllLines(Paths.get("src/data/lanzamientos.csv"));
		return listLines;		
	}

	public static String[] readPoker() throws IOException{
		FileReader fileReader = new FileReader(new File("src/data/datosPoker.txt"));
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String text = "";
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			text += line + "\n";
		}
		bufferedReader.close();
		fileReader.close();
		return text.split("\n");
	}


	public static String[] splitLine(String line, String separator){
		return line.split(separator);
	}

	public double toDouble(String line) {
		return Double.parseDouble(line);
	}

	public void print(List<String> listData) {
		for (int i = 0; i < listData.size(); i++) {
			if (listData.get(i) != null) {
				System.out.println(listData.get(i).toString());
			}
		}
	}

}