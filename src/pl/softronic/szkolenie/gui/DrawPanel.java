package pl.softronic.szkolenie.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	
	public int margin = 10;
	
	public DrawPanel(){
		super();
		setPreferredSize(new Dimension(150, 100));
	}
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dim = getSize();
		g.setColor(Color.red);
		g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
		g.setColor(Color.green);
		g.fillRect(margin* 2, margin* 2, dim.width - margin * 4, dim.height - margin * 4);
		g.setColor(Color.blue);
		g.fillRect(margin* 3, margin* 3, dim.width - margin * 6, dim.height - margin * 6);
	}
	
}