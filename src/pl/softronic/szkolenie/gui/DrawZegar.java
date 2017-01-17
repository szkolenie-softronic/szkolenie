package pl.softronic.szkolenie.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class DrawZegar extends JPanel {
	
	public DrawZegar(){
		super();
		setPreferredSize(new Dimension(200, 200));
	}
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Dimension dim = getSize();
		
		g2d.setRenderingHint(
			    RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		
		Date date = new Date();   
		Calendar calendar = GregorianCalendar.getInstance(); 
		calendar.setTime(date);   
		int h = calendar.get(Calendar.HOUR_OF_DAY); 
		int m = calendar.get(Calendar.MINUTE); 
		int s = calendar.get(Calendar.SECOND); 
		
		for(int i=0; i<12; i++){
			double rad = (i*30 - 90 ) * Math.PI/180;
			g2d.setColor(Color.GREEN.darker());
			g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2d.drawLine((int)dim.getWidth()/2 + (int)((dim.getWidth()/2-10) * Math.cos(rad)), 
					(int)dim.getHeight()/2 + (int)((dim.getHeight()/2-10) * Math.sin(rad)),
					
					(int)dim.getWidth()/2 + (int)(dim.getWidth()/2 * Math.cos(rad)), 
					(int)dim.getHeight()/2 + (int)(dim.getHeight()/2 * Math.sin(rad)) );
		}
		
		
		double hRad = ((h%12)*30 - 90 ) * Math.PI/180;
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.drawLine((int)dim.getWidth()/2, (int)dim.getHeight()/2, 
				(int)dim.getWidth()/2 + (int)(dim.getWidth()/4 * Math.cos(hRad)), 
				(int)dim.getHeight()/2 + (int)(dim.getHeight()/4 * Math.sin(hRad)) );
		
		double minRad = (m*6 - 90 ) * Math.PI/180;
		g2d.setColor(Color.blue);
		g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.drawLine((int)dim.getWidth()/2, (int)dim.getHeight()/2, 
				(int)dim.getWidth()/2 + (int)(dim.getWidth()/3 * Math.cos(minRad)), 
				(int)dim.getHeight()/2 + (int)(dim.getHeight()/3 * Math.sin(minRad)) );
		
		double secRad = (s*6 - 90 ) * Math.PI/180;
		g2d.setColor(Color.red);
		g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.drawLine((int)dim.getWidth()/2, (int)dim.getHeight()/2, 
				(int)dim.getWidth()/2 + (int)(dim.getWidth()/2 * Math.cos(secRad)), 
				(int)dim.getHeight()/2 + (int)(dim.getHeight()/2 * Math.sin(secRad)) );
		
		
		
		

	}
	
}