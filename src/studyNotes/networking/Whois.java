package studyNotes.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
    public static void main(String[] args) {
        int c;

        try (Socket s = new Socket("whois.internic.net", 43)) {
            // Obtain input and output streams.
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            // Construct a request string.
            String str = (args.length == 0 ? "MHProfessional.com" : args[0]) + "\n";
            // Convert to bytes.
            byte[] buf = str.getBytes();
            // Send request.
            out.write(buf);
            // Read and display response.
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
