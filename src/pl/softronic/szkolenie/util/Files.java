package pl.softronic.szkolenie.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;

/**Klasa skrotow skladniowych obslugi plikow "Files"    
@author Wojciech Tomczyk  */
public class Files {
	
	/** czyta dane z pliku */
	public static String readStream(String nazw) throws Exception {
		FileInputStream f;
		StringBuffer sb = new StringBuffer();
		f = new FileInputStream(nazw);
		int c;
		while ((c = f.read()) != -1)
			sb.append((char) c);
		f.close();
		return sb.toString();
	}

	/** czyta plik i dzieli go na slowa */
	public static String[] readWords(String nazw) throws Exception {
		File f = new File(nazw);
		StringBuffer sb = new StringBuffer();
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null)
			sb.append(line).append("\n");
		br.close();
		fr.close();
		return sb.toString().split("[ \\s]");
	}

	/** czyta plik jako tekst */
	public static String readText(String nazw) throws Exception {
		File f = new File(nazw);
		StringBuffer sb = new StringBuffer();
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null)
			sb.append(line).append("\n");
		br.close();
		fr.close();
		return sb.toString();
	}

	/** czyta plik i dzieli na linie */
	public static String[] readLines(String nazw) throws Exception {
		File f = new File(nazw);
		StringBuffer sb = new StringBuffer();
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null)
			sb.append(line).append("\n");
		br.close();
		fr.close();
		return sb.toString().split("\\n");
	}

	/** zapisuje do pliku */
	public static void writeStream(String nazw, String stream) throws Exception {
		FileOutputStream f;
		f = new FileOutputStream(nazw);
		int dl = stream.length();
		for (int i = 0; i < dl; i++)
			f.write((int) stream.charAt(i));
		f.close();
	}

	/** dopisuje do pliku */
	public static void appendStream(String nazw, String stream) throws Exception {
		BufferedOutputStream f;
		f = new BufferedOutputStream(new FileOutputStream(nazw, true));
		int dl = stream.length();
		for (int i = 0; i < dl; i++)
			f.write((int) stream.charAt(i));
		f.close();
	}

	/** zapisuje obiekt do pliku */
	public static void writeObject(String nazw, Object stream) throws Exception {
		FileOutputStream out = new FileOutputStream(nazw);
		ObjectOutputStream s = new ObjectOutputStream(out);
		s.writeObject(stream);
		s.flush();
		out.close();
	}

	/** czyta plik jako obiekt */
	public static Object readObject(String nazw) throws Exception {
		Object stream;
		FileInputStream in = new FileInputStream(nazw);
		ObjectInputStream s = new ObjectInputStream(in);
		stream = s.readObject();
		in.close();
		return stream;
	}

	/** czyta plik z Internetu */
	public static String readURLStream(String nazw) throws Exception {
		BufferedInputStream f;
		StringBuffer sb = new StringBuffer();
		f = new BufferedInputStream(new java.net.URL(nazw).openStream());
		int c;
		while ((c = f.read()) != -1)
			sb.append((char) c);
		f.close();
		return sb.toString();
	}

	/** kopiuje plik w wybrane miejsce */
	public static void copy(String inName, String outName) throws Exception {
		File in = new File(inName);
		File out = new File(outName);
		FileInputStream fin = new FileInputStream(in);
		FileOutputStream fout = new FileOutputStream(out);
		FileChannel sourceChannel = fin.getChannel();
		FileChannel destinationChannel = fout.getChannel();
		sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
		sourceChannel.close();
		destinationChannel.close();
		fin.close();
		fout.close();
	}
}