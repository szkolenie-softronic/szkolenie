package pl.softronic.szkolenie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
	
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		
		JFrame frame = new PrzykladOkna();
		DrawPanel draw = new DrawPanel();
		WybierakPlci plecPanel;
		
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(new JLabel("<html>Jakiœ <br/>napis na panelu okna"), BorderLayout.NORTH);
		JButton przycisk = new JButton("<html><b><u>T</u>wo</b><br><font size=20 color=#ffaa00>lines</html>");
		mainPanel.add(przycisk, BorderLayout.WEST);
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
		
		przycisk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Klik:\n   iloœæ: "+e.getClickCount());
				System.out.println("x,y = " + e.getX() +", "+e.getY());
				System.out.println("Przycisk: " + e.getButton());
				System.out.println("Modif: " + e.getModifiers());
			}
		});
		
		przycisk.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent arg0) {}
			public void mouseDragged(MouseEvent arg0) {}
		});
		
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
