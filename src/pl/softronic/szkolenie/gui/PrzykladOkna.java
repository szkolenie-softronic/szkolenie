package pl.softronic.szkolenie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import pl.softronic.szkolenie.przyklady.serializacja.Dane.Plec;

public class PrzykladOkna extends JFrame {

	static JPanel mainPanel = new JPanel();
	
	public PrzykladOkna(){
		setTitle("Przyk³adowe okno Swing");
		setSize(400, 300);
		setLocationRelativeTo(null);
		add(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new PrzykladOkna();
		DrawPanel draw = new DrawPanel();
		WybierakPlci plecPanel;
		
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(new JLabel("Jakiœ napis na panelu okna"), BorderLayout.NORTH);
		mainPanel.add(new JButton("Przycisk"), BorderLayout.WEST);
		mainPanel.add(new JLabel("Inny napis"), BorderLayout.SOUTH);
		JTabbedPane centerPanel = new JTabbedPane();
		{
			JPanel formularzPanel = new JPanel();
			{
				formularzPanel.add(new JCheckBox("Wybierz mnie!"));
				formularzPanel.add(new JTextField("tekst w œrodku"));
				
				plecPanel = (WybierakPlci) 
						formularzPanel.add(new WybierakPlci());
				
			}
			centerPanel.add(formularzPanel, "Formularz");
			centerPanel.add(draw, "Prostok¹t");
			centerPanel.add(new DrawZegar(), "Zegar");
			centerPanel.setSelectedIndex(2);
			
		}
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		
		plecPanel.addPlecChangeListener(jest->{
			System.out.println("Plec zmienia siê na: " + jest);
		});
		
		plecPanel.setWybranaPlec(Plec.CZESC_ROWEROWA);
		
		frame.setVisible(true);
		int t = 0;
		while(frame.isVisible()){
			Thread.sleep(200);
			t = (t+1)%15;
			draw.margin = t;
			mainPanel.repaint();
			//System.out.println(plecPanel.getWybranaPlec());
		}
	}

}
