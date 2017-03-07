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
		
		ImagesComparator comparator = new ImagesComparator();
		
/*		int[][] result = comparator.makePixels(firstImage);

		int[][] result2 = comparator.makePixels(secondImage);

		if (result.length != result2.length) {
			throw new RuntimeException("Object are not the same size!");
		}
		
		double perc = comparator.similarityPercentage(firstImage, secondImage);
		System.out.format("%.2f%n", perc);
		
*/

		/*comparator.findPoints(result, result2);
		
		comparator.highlightArea(secondImage);

		File out = new File(OUTPUT_PATH);
		ImageIO.write(secondImage, "jpg", out);*/

		double colorPerc = comparator.colorDifferencePercentage(firstImage, secondImage);
		System.out.format("These images differ by %.3f %%", colorPerc);
		
		double diffPerc = comparator.differencePercentage(firstImage, secondImage);
		System.out.format("These images differ by %.3f %%", diffPerc);
	}
}
