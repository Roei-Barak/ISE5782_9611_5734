package renderer;

import org.junit.jupiter.api.Test;
import primitives.Color;

import static org.junit.jupiter.api.Assertions.*;

class ImageWriterTest {

    @Test
    void testWriteToImage() {
        int nX = 800;
        int nY = 500;
        Color yellowColor = new Color(java.awt.Color.YELLOW);

        ImageWriter imageWriter = new ImageWriter("yellow submarine",nX, nY);
        for (int i = 0 ; i<nX ; i++){
            for (int j = 0; j < nY; j++) {

                imageWriter.writePixel(i,j,yellowColor);
            }
        }
    }
}