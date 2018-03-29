/*
 * Copyright @ Ye XIA <qazxiaye@126.com>
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

class InverseColor {
    static final String currDir = System.getProperty("user.dir");
    static final int threadNb = Runtime.getRuntime().availableProcessors();

    static final List<File> img_list = new ArrayList<File>();

    public static void main(String args[]) {
        // create "gen" folder
        File genFolder = new File(currDir + "/gen");
        if (!genFolder.exists()) {
            genFolder.mkdir();
        }

        // get images
        File[] files;
        if (args.length == 0) {
            File folder = new File(currDir);
            files = folder.listFiles();
        } else {
            files = new File[args.length];
            for (int i = 0; i < args.length; i++) {
                files[i] = new File(args[i]);
            }
        }

        for (File f : files) {
            try {
                String mimetype = Files.probeContentType(f.toPath());

                if (mimetype != null && mimetype.split("/")[0].equals("image")) {
                    img_list.add(f);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // inverse images
        for (int i = 0; i < threadNb; i++) {
            new Inverser().start();
        }
    }

    static class Inverser extends Thread {
        static int currImgIdx = 0;
        static final Semaphore sem = new Semaphore(1);

        @Override
        public void run() {
            while (true) {
                sem.Require();

                if (currImgIdx == img_list.size()) {
                    sem.Release();
                    return;
                }

                File img = img_list.get(currImgIdx);
                currImgIdx++;

                sem.Release();

                InverseImg(img);
            }
        }

        void InverseImg(File file) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (image == null) {
                return;
            }

            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int rgba = image.getRGB(x, y);
                    Color col = new Color(rgba, true);
                    col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());

                    image.setRGB(x, y, col.getRGB());
                }
            }

            try {
                ImageIO.write(image, "PNG", new File(currDir + "/gen/" + file.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(file.getName() + " inversed.");
        }
    }
}