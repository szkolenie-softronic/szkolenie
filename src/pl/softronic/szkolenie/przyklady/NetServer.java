package pl.softronic.szkolenie.przyklady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer {

	public static void main(String[] args) throws IOException {
		System.out.println("NetServer start");

		ServerSocket server = new ServerSocket(80);
		System.out.println("port: "+server.getLocalPort());

		Socket client = server.accept();
		System.out.println("client: "+client.getInetAddress().getCanonicalHostName());

		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

		System.out.println("Strumienie otwarto.");
		
		out.println("Hello");
		
		System.out.println("Zapytanie:");
		while(in.ready()){
			String zapytanie = in.readLine();
			System.out.println(zapytanie);
			out.println("echo "+zapytanie);
		}

		out.close();
		in.close();
		server.close();
		
		System.out.println("NetServer end.");
	}

}
