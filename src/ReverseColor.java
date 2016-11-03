/*
* Copyright @ Ye XIA <qazxiaye@126.com>
*/

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class ReverseColor
{
	static String path = "~/test";
//	static String path = System.getProperty("user.dir");
	
	static void GenReverseImg(File file)
	{
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(file);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		for (int x = 0; x < image.getWidth(); x++)
		{
            for (int y = 0; y < image.getHeight(); y++)
            {
                int rgba = image.getRGB(x, y);
                Color col = new Color(rgba, true);
                
                col = new Color(255 - col.getRed(),
                                255 - col.getGreen(),
                                255 - col.getBlue());
                
                image.setRGB(x, y, col.getRGB());
            }
        }
		
		try
		{
			ImageIO.write(image, "PNG", new File(path + "/gen/" + file.getName()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[])
	{
		//create "gen" folder
		File genFolder = new File(path + "/gen");
		if (!genFolder.exists())
		{
			genFolder.mkdir();
		}
		
		//generate images
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		for (File img : listOfFiles)
		{
			if (img.isFile())
				GenReverseImg(img);
		}
	}
}