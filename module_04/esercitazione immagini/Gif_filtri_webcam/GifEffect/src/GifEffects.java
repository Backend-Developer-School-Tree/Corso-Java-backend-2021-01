import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GifEffects {
    public static void main(String[] args){
        Dimension[] nonStandardResolutions = new Dimension[] {
                WebcamResolution.PAL.getSize(),
                WebcamResolution.HD720.getSize(),
                new Dimension(2000, 1000),
                new Dimension(1000, 500),
        };

        // your camera have to support HD720p to run this code
        Webcam webcam = Webcam.getDefault();
        webcam.setCustomViewSizes(nonStandardResolutions);
        webcam.setViewSize(WebcamResolution.HD720.getSize());
        webcam.open();

        countDown(3);
        System.out.println("Cheeseeee");

        writeGif(gifEffects(webcam),600, "effectsGif.gif");
        webcam.close();
    }

    public static BufferedImage[] gifEffects(Webcam webcam)
    {
        BufferedImage image = webcam.getImage();

        BufferedImage[] frames = new BufferedImage[5];

        frames[0] = Filters.GBRImage(image);
        frames[1] = Filters.grayImage(image);
        frames[2] = Filters.invertColorImage(image);
        frames[3] = Filters.mirrorImage(image);
        frames[4] = Filters.posterizeImage(image, 4);

        return frames;
    }


    private static void countDown(int seconds)
    {
        for (int i = 0; i < seconds; i++)
        {
            System.out.println(seconds - i);
            long now = System.currentTimeMillis();
            while(System.currentTimeMillis() < now + 1000)
            {

            }
        }
    }


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
