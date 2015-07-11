package View;

import javax.swing.JComponent;
import javax.swing.JPanel;

import model.Game;

public class GameSurface extends JPanel{

	private Game model;
	
	private Tile[][] gameGrid;
	
	public GameSurface(Game g){
		this.model = g;
		this.gameGrid = new Tile[5][5];
		
		InitGameSurface();
	}
	
	private void InitGameSurface(){
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				gameGrid[i][j] = new Tile(model.CaseByXY(i, j), this);
			}
		}
	}
	
	public void Update(Game g){
		
	}
}
