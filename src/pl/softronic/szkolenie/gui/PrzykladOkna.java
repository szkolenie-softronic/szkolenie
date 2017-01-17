package pl.softronic.szkolenie.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(new JLabel("Jakiœ napis na panelu okna"), BorderLayout.NORTH);
		mainPanel.add(new JButton("Przycisk"), BorderLayout.WEST);
		mainPanel.add(new JLabel("Inny napis"), BorderLayout.SOUTH);
		JPanel centerPanel = new JPanel();
		{
			JCheckBox cb = (JCheckBox) centerPanel.add(new JCheckBox("Wybierz mnie!"));
			JTextField txt = (JTextField) centerPanel.add(new JTextField("tekst w œrodku"));
			centerPanel.add(draw);
		}
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		
		
		frame.setVisible(true);
		int t = 0;
		while(frame.isVisible()){
			Thread.sleep(200);
			t = (t+1)%15;
			draw.margin = t;
			mainPanel.repaint();
			//System.out.println(txt.getText());
		}
	}

}
