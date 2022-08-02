package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {

        if(args.length != 2) {
            System.err.println("Not enough parametrs");
            System.exit(-1);
        }

        if(args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Please enter two char symbols as argument");
            System.exit(-1);
        }


        BufferedImage image = ImageIO.read((Program.class.getResource("/recources/it.bmp")));
        Logic logic = new Logic(image, args[1].charAt(0), args[0].charAt(0));

        logic.setCharsFromImage();
        logic.printArray();
    }
}
