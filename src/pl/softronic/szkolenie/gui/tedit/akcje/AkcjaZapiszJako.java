package pl.softronic.szkolenie.gui.tedit.akcje;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import pl.softronic.szkolenie.gui.tedit.TEditMain;

public class AkcjaZapiszJako extends AbstractAction {

	public AkcjaZapiszJako(){
		super("Zapisz jako...");
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		JFileChooser fc = new JFileChooser(new File("."));
		int status = fc.showSaveDialog(TEditMain.mainFrame);
		if(status == JFileChooser.APPROVE_OPTION){

				File f = fc.getSelectedFile();
				TEditMain.otwartyPlik = f;
				
				new AkcjaZapisz().actionPerformed(null);

		}
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



}
