package View;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;
import javax.swing.JPanel;

import model.Case;

public class Tile extends JComponent{
	
	private Case model;
	private int x, y, xA, xB, xC, xD, yA, yB, yC, yD, parentHeight, parentWidth;
	private final int tileHeight = 66, tileWidth = 100, offsetX = 0, offestY = 0;
	
	
	public Tile(Case c, JPanel parent){
		super();
		this.model = c;
		x = model.X();
		y = model.Y();
		parentHeight = parent.getHeight();
		parentWidth = parent.getWidth();
		ComputeTilePoints();
		repaint();
	}

	private void ComputeTilePoints(){
		xA = tileWidth * x + parentWidth / 2 - (tileWidth * y) / 2 + offsetX;
		xB = xA + tileWidth / 2;
		xC = xA;
		xD = xA - tileWidth / 2;
		
		yA = tileHeight * x + offestY;
		yB = yA + tileHeight / 2;
		yC = yA + tileHeight;
		yD = yA - tileHeight / 2;
	}
	
	 @Override
	protected void paintComponent(Graphics g){
		 
		super.paintComponent(g);
		
		int[] xPoints = {xA, xB, xC, xD};
		int[] yPoints = {yA, yB, yC, yD};
		
		Polygon tile = new Polygon(xPoints, yPoints, xPoints.length);
		g.drawPolygon(tile);
	}
}
