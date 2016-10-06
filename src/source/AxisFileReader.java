package source;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class AxisFileReader {
	OutputStream outputStream = null;
	
	public void saveInputStream(InputStream inputStream, String outputFilePath) {

		try {
			
			// write the inputStream to a FileOutputStream
			OutputStream outputStream = new FileOutputStream(new File(outputFilePath));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			System.out.println("Done!");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}
	
	public void saveImageStream(BufferedImage bufferedImage, String outputFilePath) {

		try {
			
			// write the inputStream to a FileOutputStream
			File file = new File(outputFilePath);
			
            ImageIO.write(bufferedImage, "JPEG", file);
            System.out.println("Done!");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}

	}

}
