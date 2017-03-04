package comparator;
import java.awt.image.BufferedImage;

/**
 * This class represents methods to compare two images.
 * 
 * @author Tetiana Parkhomenko
 *
 */
public class ImagesComparator {
	
	public void lineDifferences(){}

	
	/**
	 * Returns <b>color difference</b> between two images in percents.
	 * 
	 * @param firstImage
	 * @param secondImage
	 * @return result in percents
	 */
	public double colorDifferencePercentage(BufferedImage firstImage, BufferedImage secondImage) {
        long difference = 0;
        int width = firstImage.getWidth();
        int height = firstImage.getHeight();
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb1 = firstImage.getRGB(x, y);
                int rgb2 = secondImage.getRGB(x, y);
                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >>  8) & 0xff;
                int b1 = (rgb1      ) & 0xff;
                int r2 = (rgb2 >> 16) & 0xff;
                int g2 = (rgb2 >>  8) & 0xff;
                int b2 = (rgb2      ) & 0xff;
                difference += Math.abs(r1 - r2);
                difference += Math.abs(g1 - g2);
                difference += Math.abs(b1 - b2);
            }
        }
        
        double result = difference / (width * height * 3) / 255.0;
        return result; 
	}

}
