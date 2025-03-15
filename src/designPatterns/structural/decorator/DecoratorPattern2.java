package designPatterns.structural.decorator;

import java.io.*;

class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}

public class DecoratorPattern2 {
    public static void main(String[] args) {
        int c;
        byte[] bytes = "Ify Osakwe is Really gooD".getBytes();

        try {
            InputStream inputStream = new LowerCaseInputStream(new ByteArrayInputStream(bytes));
            while ((c = inputStream.read()) > 0) {
                System.out.print((char) c);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
