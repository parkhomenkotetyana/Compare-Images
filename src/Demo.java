import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import comparator.ImagesComparator;

/**
 * This class demonstrates the work of ImagesComparator class.
 * 
 * @author Tetiana Parkhomenko
 *
 */
public class Demo {	
	
	private static final String FIRST_IMAGE_PATH = "D:\\finderProject\\original.bmp";
	private static final String SECOND_IMAGE_PATH = "D:\\finderProject\\COLORNOToriginal.bmp";
	private static final String OUTPUT_PATH = "D:\\finderProject\\result.jpg";//make current location

	private static BufferedImage firstImage;
	private static BufferedImage secondImage;
	static {
		try {
			firstImage = ImageIO.read(new File(FIRST_IMAGE_PATH));
			secondImage = ImageIO.read(new File(SECOND_IMAGE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {

		double colorPerc = new ImagesComparator().colorDifferencePercentage(firstImage, secondImage);
		System.out.println(colorPerc);
		System.out.format("These images differ by %.3f %%", colorPerc);
	}
}
