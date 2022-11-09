# playing-with-colors
Design work in the Java programming language, where we learned how to analyze an image and edit it according to the requirement.
we used StdIn, StdOut, StdDraw

The function ​Color[][] read(String filename)​ receives the name of a PPM file and returns an array containing the image data. 

The function ​Color[][] flippedHorizontally(Color[][] image)​ returns a new image which is a horizontal flip of the given image: In each row of the new image, the order of the pixels is reversed (within each pixel though, nothing changes).

The function ​Color[][] flippedVertically(Color[][] image)​ returns a new image which is a vertical flip of the given image: In each column of the new image, the order of the pixels is reversed.

function ​Color[][] greyScale(Color[][] image)​. This function returns the greyscaled version of the given image.

<img width="637" alt="Screen Shot 2022-08-02 at 18 31 41" src="https://user-images.githubusercontent.com/77965127/182413604-bbdcdafe-ff61-4c66-a4a2-8cc81b59abdd.png">

 function ​Color[][] scale(Color[][] image, int width, int height).​ The function returns a new image which is a version of the original image, scaled to be of the given width and height
 
<img width="631" alt="Screen Shot 2022-08-02 at 18 32 43" src="https://user-images.githubusercontent.com/77965127/182413823-3aafe33e-f5c8-40ea-8d94-59f455220f30.png">

The function ​Color[][] blend (Color[][] image1, Color[][] image2, double alpha)​ returns the alpha-blending of the two given images. The function computes each new pixel using the ​blend​ function

<img width="649" alt="Screen Shot 2022-08-02 at 18 33 36" src="https://user-images.githubusercontent.com/77965127/182414003-c28f2e6a-e431-4b62-8eb3-444a41d9fc82.png">
"# playing_with_picture_colors" 
