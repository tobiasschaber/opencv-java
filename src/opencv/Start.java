package opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * Created by tobias on 25.08.17.
 */
public class Start {


    public static void main(String[] args) {

        /* load the native library */
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        ImageHelper helper = new ImageHelper();
        helper.addImage(getImage());

    }


    public static Mat getImage() {
        Mat input = Imgcodecs.imread("/home/tobias/work/computervision/Unbenannt.png");
//        Imgproc.cvtColor(input, input, Imgproc.COLOR_BGR2GRAY);
        return input;
    }
}
