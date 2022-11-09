import java.awt.Color;


/**
 * A library of image processing functions.
 */
public class Instush {
	
	public static void main(String[] args) 
	{
		Color[][] image = read("eyes.ppm");
		Color[][] image2 = read("xmen.ppm");
		show(blend(image, image2, 0.75));
		
		Color[][] image3 = read("escher.ppm");
		Color[][] image4 = read("tinypic.ppm");
		show(blend(image3, image4, 0.3));
	}	
	public static void println(Color c) 
	{
	    System.out.print("(");
		System.out.printf("%3s", c.getRed());    // Prints the red component
		System.out.printf("%4s", c.getGreen());  // Prints the green component
        System.out.printf("%4s", c.getBlue());   // Prints the blue component
        System.out.print(") ");
	   // System.out.println();
	}

	/**
	 * Returns an image created from a given PPM file.
	 * SIDE EFFECT: Sets standard input to the given file.
	 * @return the image, as a 2D array of Color values
	 */
	public static Color[][] read(String filename) {
	     StdIn.setInput(filename);
	     // Reads the PPM file header (ignoring some items)
	     StdIn.readString();
	     int numCols = StdIn.readInt();
	     int numRows = StdIn.readInt();
	     StdIn.readInt();
	     Color[][] image = new Color[numRows][numCols];;
		// Creates the image
		int red = 0;
		int green = 0;
		int blue = 0;
		for (int i = 0; i < image.length; i++) 
		{
			for (int j = 0; j < image[i].length; j++) 
			{
			 red = StdIn.readInt();
			 green = StdIn.readInt();
			 blue = StdIn.readInt();
     		 image [i][j] = new Color(red,green,blue);
     		// System.out.print(image[i][j]);
     		// System.out.println("("+red +" " +green + " "+blue +")");
			}
		}
		// Reads the RGB values from the file, into the image. 
		// For each pixel (i,j), reads 3 values from the file,
		// creates from the 3 colors a new Color object, and 
		// makes pixel (i,j) refer to that object.		
		// Replace the following statement with your code

		return image;
	}

	/**
	 * Prints the pixels of a given image.
	 * Each pixel is printed as a triplet of (r,g,b) values.
	 * For debugging purposes.
	 * @param image - the image to be printed
	 */
	public static void println(Color[][] image) {
	    // Write your code here

		for (int i = 0; i < image.length; i++) 
		{
			for (int j = 0; j < image[i].length; j++) 
			{	
				println( image [i][j]);
			}
			System.out.println();
		}
	
	}
	
	public static Color[] switchcolor(Color[] c) 
	{
		Color [] makesure =  new Color[c.length] ;
		for (int i = 0; i < makesure.length; i++) {
			makesure[i] = c[i];
		}
		for (int i = 0; i < (c.length); i++) {
		c[i] = makesure[makesure.length-1-i];
		}
		return c;
	}
	
	/**
	 * Returns an image which is the horizontally flipped version of the given image. 
	 * @param image - the image to flip
	 * @return the horizontally flipped image
	 */
	public static Color[][] flippedHorizontally(Color[][] image) {
		// Replace the following statement with your code		
		for (int j = 0; j < image.length; j++) {
			image[j] = switchcolor(image[j]);
		}
		return image;
	}
	
	/**
	 * Returns an image which is the vertically flipped version of the given image. 
	 * @param image - the image to flip
	 * @return the vertically flipped image
	 */
	public static Color[][] flippedVertically(Color[][] image){
		// Replace the following statement with your code
		Color [][] makesure1 =  new Color[image.length][image[0].length];
		for (int i = 0; i < makesure1.length; i++) {
			makesure1[i] = image[i];
			for (int j = 0; j < makesure1[i].length; j++) {
				makesure1[i][j] = image[i][j];
			}
		}
		for (int i = 0; i < (makesure1.length); i++) {
		makesure1[i] = image[image.length-1-i];
		}
		
		
		return makesure1;
	
	}
	
	/**
	 * Returns the average of the RGB values of all the pixels in a given image.
	 * @param image - the image
	 * @return the average of all the RGB values of the image
	 */
	public static double average(Color[][] image) {
		// Replace the following statement with your code
		double average = 0.0;
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				average+= (image[i][j].getBlue()+image[i][j].getRed()+image[i][j].getGreen());
			}
		}
		average = average/(image.length*image[0].length*3);
		System.out.println(average);
		return average;
	}

	/**
	 * Returns the luminance value of a given pixel. Luminance is a weighted average
	 * of the RGB values of the pixel, given by 0.299 * r + 0.587 * g + 0.114 * b.
	 * Used as a shade of grey, as part of the greyscaling process.
	 * @param pixel - the pixel
	 * @return the greyscale value of the pixel, as a Color object
	 *         (r = g = b = the greyscale value)
	 */
	public static Color luminance(Color pixel) {
		// Replace the following statement with your code
		double red = (pixel.getRed()*0.299);
		double green = (pixel.getGreen()*0.587);
		double blue = (pixel.getBlue()*0.114);
		int todo =(int)(red + green + blue);
		Color lum= new Color(todo, todo , todo);
		
		return lum;
	}
	
	/**
	 * Returns an image which is the greyscaled version of the given image.
	 * @param image - the image
	 * @return rhe greyscaled version of the image
	 */
	public static Color[][] greyscaled(Color[][] image) 
	{
		// Replace the following statement with your code
		Color [][] makesure1 =  new Color[image.length][image[0].length];
		for (int i = 0; i < makesure1.length; i++)
		{
			makesure1[i] = image[i];
			for (int j = 0; j < makesure1[i].length; j++) 
			{
				makesure1[i][j] = luminance(image[i][j]);
			}
		}
		return makesure1;
	}	
	
	/**
	 * Returns an umage which is the scaled version of the given image. 
	 * The image is scaled (resized) to be of the given width and height.
	 * @param image - the image
	 * @param width - the width of the scaled image
	 * @param height - the height of the scaled image
	 * @return - the scaled image
	 */
	public static Color[][] scaled(Color[][] image, int width, int height) {
		// Replace the following statement with your code
		Color [][] newimage = new Color[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) 
			{
			newimage[i][j] = image[(int)(i*image.length/height)][(int)(j*image[0].length/width)];
			}
		}
		return newimage;
	}
	
	/**
	 * Returns a blended color which is the linear combination of two colors.
	 * Each r, g, b, value v is calculated using v = (1 - alpha) * v1 + alpha * v2.
	 * 
	 * @param pixel1 - the first color
	 * @param pixel2 - the second color
	 * @param alpha - the linear combination parameter
	 * @return the blended color
	 */
	public static Color blend(Color c1, Color c2, double alpha) {
		// Replace the following statement with your code	
		if (alpha <= 1 && alpha >= 0 ) { 
		double red = (c1.getRed() * alpha + c2.getRed() * (1-alpha));
		double green = (c1.getGreen() * alpha + c2.getGreen() * (1-alpha));
		double blue = (c1.getBlue() * alpha + c2.getBlue() * (1-alpha));
		Color newpixel= new Color((int)red, (int)green , (int)blue);
		return newpixel;
		}	
		return null;
	}
	
	/**
	 * Returns an image which is the blending of the two given images.
	 * The blending is the linear combination of (1 - alpha) parts the
	 * first image and (alpha) parts the second image.
	 * The two images must have the same dimensions. 
	 * @param image1 - the first image
	 * @param image2 - the second image
	 * @param alpha - the linear combination parameter
	 * @return - the blended image
	 */
	public static Color[][] blend(Color[][] image1, Color[][] image2, double alpha) {
		// Replace the following statement with your code
		if (alpha <= 1 && alpha >= 0 )
		{	
			int height =(int)(image1.length);
			int width =(int)(image1[0].length );
			image2 = scaled(image2, width, height);
			Color[][] blend = new Color[height][width];
				for (int i = 0; i < height; i++)
				{
				for (int j = 0; j < width ; j++) 
				{
					blend[i][j] = blend(image1[i][j], image2[i][j], alpha);
				}
			}	
			return blend;
		}
		return null;
	}
	
	/**
	 * Morphs the source image into the target image, gradually, in n steps.
	 * Animates the morphing process by displaying the morphed image in each step.
	 * The target image is an image which is scaled to be a version of the target
	 * image, scaled to have the width and height of the source image.
	 * @param source - source image
	 * @param target - target image
	 * @param n - number of morphing steps
	 */
	public static void morph(Color[][] source, Color[][] target, int n) 
	{
		// Write your code here
		for (int i = 0; i <= n; i++)
		{
			double a = (n- i)*1.0/n ;
			show(blend(source, target, a));
		}	
	}
	
     /**
	 * Renders (displays) an image on the screen, using StdDraw. 
	 * 
	 * @param image - the image to show
	 */
	public static void show(Color[][] image) {
		StdDraw.setCanvasSize(image[0].length, image.length);
		int width = image[0].length;
		int height = image.length;
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.show(25); 
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Sets the pen color to the color of the pixel
				StdDraw.setPenColor( image[i][j].getRed(),
					                 image[i][j].getGreen(),
					                 image[i][j].getBlue() 
					                 );
				// Draws the pixel as a tiny filled square of size 1
				StdDraw.filledSquare(j + 0.5, height - i - 0.5, 0.5);
			}
		}
		StdDraw.show();
	}
}

