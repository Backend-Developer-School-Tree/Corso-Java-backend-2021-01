import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterHolder {

    private BufferedWriter bw;

    WriterHolder()
    {
        try {
            bw = new BufferedWriter(new FileWriter("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public synchronized void writeLine(String line)
    {
        try {
            bw.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
