/*
* Copyright @ Ye XIA <qazxiaye@126.com>
*/

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;

class ReverseColor
{
	static String currDir = System.getProperty("user.dir");
	
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
		
		if(image == null)
			return;
		
		System.out.println("Reversing color of image " + file.getName());
		
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
			ImageIO.write(image, "PNG", new File(currDir + "/gen/" + file.getName()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	}
	
	
	public static void main(String args[])
	{
		//create "gen" folder
		File genFolder = new File(currDir + "/gen");
		if (!genFolder.exists())
		{
			genFolder.mkdir();
		}
		
		//generate images
		if(args.length == 0)
		{
			File folder = new File(currDir);
			File[] listOfFiles = folder.listFiles();
			
			for (File img : listOfFiles)
			{
				try
				{
					String mimetype = Files.probeContentType(img.toPath());
					
					if (mimetype != null && mimetype.split("/")[0].equals("image"))
						GenReverseImg(img);
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			for(String path : args)
			{
				File img = new File(path);
				
				try
				{
					String mimetype = Files.probeContentType(img.toPath());
					
					if (mimetype != null && mimetype.split("/")[0].equals("image"))
						GenReverseImg(img);
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}