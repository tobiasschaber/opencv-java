package opencv;

import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 * Helper class containing some boilerplate code to show an OpenCV mat
 * in a java (swing) application
 */
public class ImageHelper {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(panel);


    public ImageHelper() {
        panel.setLayout(new FlowLayout());
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(scrollPane);
    }


    /**
     * add an OpenCV Mat to the panel and make the window visible
     * @param m
     */
    public void addImage(Mat m) {

        int type = BufferedImage.TYPE_BYTE_GRAY;

        if (m.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels() * m.cols() * m.rows();
        byte[] b = new byte[bufferSize];

        m.get(0, 0, b);
        BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);

        ImageIcon imageIcon = new ImageIcon(image);

        JLabel label = new JLabel();
        label.setIcon(imageIcon);

        panel.add(label);
        frame.setVisible(true);

    }

}
