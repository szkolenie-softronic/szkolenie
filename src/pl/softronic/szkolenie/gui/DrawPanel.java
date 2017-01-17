package pl.softronic.szkolenie.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	
	public int margin = 10;
	
	public DrawPanel(){
		super();
		setPreferredSize(new Dimension(150, 100));
	}
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Dimension dim = getSize();
		g2d.setColor(Color.red);
		g2d.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
		g2d.setColor(Color.green);
		g2d.fillRect(margin* 2, margin* 2, dim.width - margin * 4, dim.height - margin * 4);
		g2d.setColor(Color.blue);
		g2d.fillRect(margin* 3, margin* 3, dim.width - margin * 6, dim.height - margin * 6);
	}
	
}