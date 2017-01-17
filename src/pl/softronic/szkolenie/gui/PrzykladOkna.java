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
		setTitle("Przyk�adowe okno Swing");
		setSize(400, 300);
		setLocationRelativeTo(null);
		add(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new PrzykladOkna();
		DrawPanel draw = new DrawPanel();
		
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(new JLabel("Jaki� napis na panelu okna"), BorderLayout.NORTH);
		mainPanel.add(new JButton("Przycisk"), BorderLayout.WEST);
		mainPanel.add(new JLabel("Inny napis"), BorderLayout.SOUTH);
		JTabbedPane centerPanel = new JTabbedPane();
		{
			JPanel formularzPanel = new JPanel();
			{
				formularzPanel.add(new JCheckBox("Wybierz mnie!"));
				formularzPanel.add(new JTextField("tekst w �rodku"));
				JPanel radioPanel = new JPanel();
				{
					radioPanel.setBorder(BorderFactory.createTitledBorder(
							BorderFactory.createEtchedBorder(), "P�e�"
							));
					radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
					ButtonGroup group = new ButtonGroup();
				    for(Plec plec : Plec.values()){
						JRadioButton b = (JRadioButton) 
								radioPanel.add(new JRadioButton(plec.name()));
						group.add(b);
						if(plec==Plec.NIE_WIEM){
							b.setSelected(true);
						}
					}
				}
				formularzPanel.add(radioPanel);
			}
			centerPanel.add(formularzPanel, "Formularz");
			centerPanel.add(draw, "Prostok�t");
			centerPanel.add(new DrawZegar(), "Zegar");
			centerPanel.setSelectedIndex(2);
			
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
