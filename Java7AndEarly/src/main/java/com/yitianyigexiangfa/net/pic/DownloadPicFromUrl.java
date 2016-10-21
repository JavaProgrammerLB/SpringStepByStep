package com.yitianyigexiangfa.net.pic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class DownloadPicFromUrl {

	public DownloadPicFromUrl() {
	}

	/**
	 * @param url seed url
	 * @param formatType such as gif jpg
	 * @param name different name for different pic
	 */
	public void downPic(String url, String formatType, String name) {
		String filepath = "./pic";
		File pic = new File(filepath);
		if(!pic.exists()){
			pic.mkdir();
		}
		try {
			BufferedImage image = ImageIO.read(new URL(url));
			File file = new File(pic, name + ".gif");
			ImageIO.write(image, formatType, file);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
