package imageReplyes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class GeoMap implements ImageReply{

    public byte[] getReply(String iconURL, Double lon, Double lat) throws IOException {
        var stringUrl1 =
                String.format("https://static-maps.yandex.ru/1.x/?ll=%s,%s&l=map&scale=1.0&z=12&scale=2.0&lang=ru_RU",
                        lon, lat);
        Image image1 = null;
        try {
            URL url = new URL(stringUrl1);
            image1 = ImageIO.read(url);
        } catch (IOException ignored) {
        }

        Image image2 = null;
        try {
            URL url = new URL(iconURL);
            image2 = ImageIO.read(url);
        } catch (IOException ignored) {
        }
        assert image1 != null;
        return combineImages(image1, image2);
    }

    private byte[] combineImages(Image image1, Image image2) throws IOException {
        BufferedImage im = new BufferedImage(image1.getWidth(null),image1.getHeight(null),
                BufferedImage.TYPE_INT_RGB);
        im.getGraphics().drawImage(image1,0,0,null);
        im.getGraphics()
                .drawImage(image2,0,0,null);
        var byteArrayOutputStream = new ByteArrayOutputStream();

        ImageIO.write(im, "jpg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
