package pl.softronic.szkolenie.gui.tedit.akcje;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import pl.softronic.szkolenie.gui.tedit.TEditMain;

public class AkcjaOtworz extends AbstractAction {

	public AkcjaOtworz(){
		super("Otwórz");
		putValue(ACCELERATOR_KEY,
		        KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		JFileChooser fc = new JFileChooser(new File("."));
		int status = fc.showOpenDialog(TEditMain.mainFrame);
		if(status == JFileChooser.APPROVE_OPTION){
			try {
				File f = fc.getSelectedFile();
				TEditMain.otwartyPlik = f;
				
				FileInputStream fis = new FileInputStream(f);
				InputStreamReader irs = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(irs);
				List<String> lines = br.lines().collect(Collectors.toList());
				StringBuilder stringBuilder = new StringBuilder();
				for(String line : lines){
					stringBuilder.append(line).append("\r\n");
				}
				TEditMain.textArea.setText(stringBuilder.toString());
				TEditMain.statusDlugoscTekstu.setText("Odczytano z pliku tekst o d³ugoœci: "
						+ stringBuilder.length());
				
				br.close();
				irs.close();
				fis.close();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(TEditMain.mainFrame, e.toString(), 
						"B³¹d", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



}
