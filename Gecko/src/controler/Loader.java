package controler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Loader {
	
	/**
	 * Fichier de données contenant les plateaux du jeu.
	 */
	private String file;
	
	/**
	 * Instancie un nouveau Loader avec le chemin spécifié.
	 * @param chemin Indique le chemin du fichier de données.
	 */
	public Loader(String path){
		this.file = path;
	}
	
	/**
	 * 
	 * @param numPlateau Représente le numéro du plateau, donc la ligne de données à charger.
	 * @return Une chaîne de caractères représentant le plateau demandé.
	 * @throws java.io.IOException Si les données spécifiées ne peuvent être lues
	 */
	public String loadGrid(int gridNo){
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			
			while(line != null){
				String index = line.split("-")[0];
				String strGrid = line.split("-")[1];
				
				if(Integer.parseInt(index) == gridNo){
					br.close();
					return strGrid;
				}
				line = br.readLine();
			}
			br.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
