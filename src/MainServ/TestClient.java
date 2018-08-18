package MainServ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 * 
 * @author H4dDock
 *
 */
public class TestClient {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Socket socket = new Socket("localhost", 2500);

		BufferedReader bufRead = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf8"));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf8")); 
		
		String userOut = "";
		while (!"quit".equals(userOut)) {
			
			userOut = in.nextLine();
			System.out.println("Comand accept");
			writer.println(userOut);
			writer.flush();
			System.out.println(bufRead.readLine());

		}
		
		in.close();
		socket.close();
	}

}
