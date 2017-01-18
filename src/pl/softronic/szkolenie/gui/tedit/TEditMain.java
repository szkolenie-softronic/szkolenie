package pl.softronic.szkolenie.gui.tedit;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import pl.softronic.szkolenie.gui.tedit.akcje.AkcjaOtworz;
import pl.softronic.szkolenie.gui.tedit.akcje.AkcjaZapisz;
import pl.softronic.szkolenie.gui.tedit.akcje.AkcjaZapiszJako;

public class TEditMain extends JFrame {
	
	static class ActionAdapter extends AbstractAction{
		public ActionAdapter(String s){super(s);};
		public void actionPerformed(ActionEvent e) {}
	}
	public static JFrame mainFrame;
	public static File otwartyPlik = null;
	
	static JPanel mainPanel = new JPanel(new BorderLayout());
	public static JTextArea textArea = new JTextArea();
	public static JLabel statusDlugoscTekstu = new JLabel("Znaków: 0");
	static JMenuBar mainMenu = new JMenuBar();
	
	static Action akcjaOtworz = new AkcjaOtworz();
	static Action akcjaZapisz = new AkcjaZapisz();
	static Action akcjaZapiszJako = new AkcjaZapiszJako();
	static Action akcjaZamknij = new AbstractAction("Zamknij"){
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	static Action akcjaKopiuj = new ActionAdapter("Kopiuj");
	static Action akcjaWytnij = new ActionAdapter("Wytnij");
	static Action akcjaWklej = new ActionAdapter("Wklej");
	
	public TEditMain(){
		setTitle("Przyk³adowe okno Swing");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setJMenuBar(mainMenu);
		{
			JMenu menuPlik = mainMenu.add(new JMenu("Plik"));
			{
				menuPlik.add(akcjaOtworz);
				menuPlik.add(akcjaZapisz);
				menuPlik.add(akcjaZapiszJako);
				menuPlik.addSeparator();
				menuPlik.add(akcjaZamknij);
			}
			JMenu menuEdycja = mainMenu.add(new JMenu("Edycja"));
			{
				menuEdycja.add(akcjaKopiuj);
				menuEdycja.add(akcjaWytnij);
				menuEdycja.add(akcjaWklej);
			}
			JMenu menuPomoc = mainMenu.add(new JMenu("Pomoc"));
			{
				menuPomoc.add("O programie").addActionListener(a -> {
					JOptionPane.showMessageDialog(this, 
							"<html><font color=#ffaa00 size=20>TEdit<br/></font>Prosty edytor tekstu.", 
							"O Programie", JOptionPane.INFORMATION_MESSAGE);
				});
			}
		}
		JToolBar toolBar = new JToolBar("Edycja");
		mainPanel.add(toolBar, BorderLayout.NORTH);
		{
			toolBar.add(akcjaKopiuj);
			toolBar.add(akcjaWytnij);
			toolBar.add(akcjaWklej);
		}
		
		add(mainPanel);
		{
			JScrollPane scroll = new JScrollPane(textArea);
			JPopupMenu popup = new JPopupMenu();
			textArea.setComponentPopupMenu(popup);
			{
				popup.add(akcjaKopiuj);
				popup.add(akcjaWytnij);
				popup.add(akcjaWklej);
			}
			mainPanel.add(scroll, BorderLayout.CENTER);
			JPanel statusBar = new JPanel(new GridLayout(1, 1));
			mainPanel.add(statusBar, BorderLayout.SOUTH);
			{
				statusDlugoscTekstu.setHorizontalAlignment(JLabel.RIGHT);
				statusBar.add(statusDlugoscTekstu);
			}
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		//System.out.println("Start");
		mainFrame = new TEditMain();
		mainFrame.setVisible(true);
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override public void keyReleased(KeyEvent e) {
				JTextArea zrodlo = (JTextArea)e.getSource();
				statusDlugoscTekstu.setText("Znaków: "+zrodlo.getText().length());
			}
		});

	}

}
