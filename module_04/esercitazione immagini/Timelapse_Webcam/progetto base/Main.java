import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {


    /**
     * Questo metodo dato un array di immagini crea una gif e la salva su disco.
     * @param captures Le immagini da salvare
     * @param millisPerFrame durata di ogni frame della gif in millisecondi
     * @param filename Nome del file su cui salvare la gif.
     * @return
     */
    private static boolean writeGif(BufferedImage[] captures, int millisPerFrame, String filename)
    {
        ImageOutputStream output;
        try {
            output = new FileImageOutputStream(new File(filename));
            GifSequenceWriter writer =
                    new GifSequenceWriter(output, 5, millisPerFrame, true);
            for(BufferedImage image: captures)
                writer.writeToSequence(image);
            writer.close();
            output.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
