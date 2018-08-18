package MainServ;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 
 * @author H4dDock
 *
 */

public class TestServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(2500);
		
		System.out.println("Waiting users...");
		Socket accept = serverSocket.accept();
		System.out.println("User connected...");

		InputStream is = accept.getInputStream();
		OutputStream os = accept.getOutputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf8"));
		BufferedOutputStream bos = new BufferedOutputStream(os);

		String userInput = "";
		
		while (!"quit".equals(userInput)) {

			userInput = br.readLine();
			
			System.out.println(("Command " + userInput + " checked"));
			
			if (userInput == null)
				continue;

			try {
				if (SomeWeirdShit.ConcatThis(userInput, "time") && SomeWeirdShit.ConcatThis(userInput, "?")) {
					bos.write((">>> " + new Date(System.currentTimeMillis()).toString() + "\n").getBytes());
					bos.flush();
				} else {
					System.out.println("Unknown command.");
				}
			}catch(IllegalArgumentException illegalArgumentException) {
				bos.write("too short command".getBytes());
			}
			
		}

		System.out.println("All Done");
		accept.close();
		serverSocket.close();

	}

}
