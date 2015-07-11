package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;

public class GameFrame extends JFrame{
	
	private Game model;
	private GameSurface gameSurface;
	
	public GameFrame(Game g){
		
		super("Gecko");
		model = g;
		
		InitGraphics();
	}
	
	private void InitGraphics(){
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		gameSurface = new GameSurface(model);
		this.add(gameSurface);
		
		this.setVisible(true);
	}
	
	public void Update(Game g){
		this.model = g;
		gameSurface.Update(model);
	}
}
