package model;

/**
 * 
 * @author Pierre Nicola�
 * @version 1.0
 */
public class Game {
	
	/**
	 * Tableau � deux dimensions pour le stockage et la manipulation des cases.
	 */
	private Case[][] grid;
	
	/**
	 * Repr�sentation logique du pion.
	 */
	private Token token;
	
	/**
	 * Repr�sentation logique de la case d�part
	 */
	private Case start;
	
	/**
	 * Repr�sentation logique de la case d'arriv�e
	 */
	private Case end;
	
	/**
	 * Constructeur de la Grille du jeu. �l�ment de base repr�sentant le plateau de jeu.
	 * @param gridData Chaine de caract�res repr�setant la grille.
	 */
	public Game(String gridData){
		this.grid = new Case[5][5];
		initGrid(gridData.toCharArray());
	}
	
	/**
	 * Initialise une grille de 5x5 avec des objets de type Case.
	 * @param gridData Tableau de caract�re d�finissant la grille
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
	 * @return Un tableau de Case � deux dimension repr�sentant la grille de jeu.
	 */
	public Case[][] getGrid(){
		return this.grid;
	}
	
	/**
	 * Getter de la case d�part du plateau
	 * @return Un objet de type Case repr�sentant la case d�part du jeu
	 */
	public Case Start(){
		return this.start;
	}
	
	/**
	 * Getter de la case arriv�e du plateau
	 * @return Un objet de type Case repr�sentant la case arriv�e du jeu
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
