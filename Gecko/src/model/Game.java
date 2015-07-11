package model;

/**
 * 
 * @author Pierre Nicolaï
 * @version 1.0
 */
public class Game {
	
	/**
	 * Tableau à deux dimensions pour le stockage et la manipulation des cases.
	 */
	private Case[][] grid;
	
	/**
	 * Représentation logique du pion.
	 */
	private Token token;
	
	/**
	 * Représentation logique de la case départ
	 */
	private Case start;
	
	/**
	 * Représentation logique de la case d'arrivée
	 */
	private Case end;
	
	/**
	 * Constructeur de la Grille du jeu. Élément de base représentant le plateau de jeu.
	 * @param gridData Chaine de caractères représetant la grille.
	 */
	public Game(String gridData){
		this.grid = new Case[5][5];
		initGrid(gridData.toCharArray());
	}
	
	/**
	 * Initialise une grille de 5x5 avec des objets de type Case.
	 * @param gridData Tableau de caractère définissant la grille
	 */
	private void initGrid(char[] gridData)
	{
		int k = 0;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				grid[i][j] = new Case(i, j, gridData[k]);
				if(gridData[k] == 'D')
					this.start = grid[i][j];
				else if(gridData[k] == 'A')
					this.end = grid[i][j];
				k++;
			}
		}
	}
	
	/**
	 * Getter de la grille de jeu
	 * @return Un tableau de Case à deux dimension représentant la grille de jeu.
	 */
	public Case[][] getGrid(){
		return this.grid;
	}
	
	/**
	 * Getter de la case départ du plateau
	 * @return Un objet de type Case représentant la case départ du jeu
	 */
	public Case Start(){
		return this.start;
	}
	
	/**
	 * Getter de la case arrivée du plateau
	 * @return Un objet de type Case représentant la case arrivée du jeu
	 */
	public Case End(){
		return this.end;
	}
	
	public Case CaseByXY(int x, int y){
		if(x < 0 || x > 4 || y < 0 || y > 4)
			throw new IllegalArgumentException("The required cell doesn't exists : Index is out of bounds");
		return this.grid[x][y];
	}
	
	public Token Token(){
		return this.token;
	}
}
