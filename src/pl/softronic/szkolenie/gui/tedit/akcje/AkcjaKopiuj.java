package pl.softronic.szkolenie.gui.tedit.akcje;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

import pl.softronic.szkolenie.gui.tedit.TEditMain;

public class AkcjaKopiuj extends AbstractAction {

	static ImageIcon icon;
	static {
		try {
			InputStream stream = System.class.
					getResourceAsStream("/pl/softronic/szkolenie/gui/tedit/Editing-Copy-icon.png");
			Image image = ImageIO.read(stream);
			image = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			icon = new ImageIcon(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public AkcjaKopiuj(){
		super("Kopiuj", icon);
		putValue(ACCELERATOR_KEY,
		        KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		new DefaultEditorKit.CopyAction().actionPerformed(null);
		TEditMain.textArea.requestFocus();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



}
