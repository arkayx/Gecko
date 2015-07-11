package controler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Loader {
	
	/**
	 * Fichier de donn�es contenant les plateaux du jeu.
	 */
	private String file;
	
	/**
	 * Instancie un nouveau Loader avec le chemin sp�cifi�.
	 * @param chemin Indique le chemin du fichier de donn�es.
	 */
	public Loader(String path){
		this.file = path;
	}
	
	/**
	 * 
	 * @param numPlateau Repr�sente le num�ro du plateau, donc la ligne de donn�es � charger.
	 * @return Une cha�ne de caract�res repr�sentant le plateau demand�.
	 * @throws java.io.IOException Si les donn�es sp�cifi�es ne peuvent �tre lues
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
