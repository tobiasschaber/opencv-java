package opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * Created by tobias on 25.08.17.
 */
public class Start {

    /* change this path to an image on your disk which you want to work with */
    public static final String imagePath = "/home/tobias/work/computervision/input.png";


    public static void main(String[] args) {

        /* load the native library */
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        ImageHelper helper = new ImageHelper();

        /* read an image to work with from disk */
        Mat input = Imgcodecs.imread(imagePath);

        /* perform image processing on this image */
        Mat processedImage = processImage(input);

        /* add the image to the panel and show the window */
        helper.addImage(processedImage);

    }


    /**
     * takes a mat and performs some image processing on it
     * @param input the image to process
     * @return the processed image
     */
    public static Mat processImage(Mat input) {

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * *
         *  This is your place to start.
         *  Do whatever you want with OpenCV here!
         *  For example: Convert colors to gray
         * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        Imgproc.cvtColor(input, input, Imgproc.COLOR_BGR2GRAY);


        return input;
    }
}
