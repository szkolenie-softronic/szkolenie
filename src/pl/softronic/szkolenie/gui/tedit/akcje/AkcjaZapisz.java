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

public class AkcjaZapisz extends AbstractAction {

	public AkcjaZapisz(){
		super("Zapisz");
		putValue(ACCELERATOR_KEY,
		        KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		if(TEditMain.otwartyPlik == null){
			
			new AkcjaZapiszJako().actionPerformed(null);
			
		} else {
			
			try {
				File f = TEditMain.otwartyPlik;
				
				FileOutputStream fos = new FileOutputStream(f);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				osw.write(TEditMain.textArea.getText());
				
				osw.flush();
				osw.close();
				fos.close();
				
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
