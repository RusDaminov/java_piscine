package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Logic {
    private BufferedImage image;
    private char[][] charsFromImage;
    private char blackColorSymbol;
    private char whiteColorSymbol;

    public Logic(BufferedImage image, char blackColorSymbol, char whiteColorSymbol) {
        this.blackColorSymbol = blackColorSymbol;
        this.whiteColorSymbol = whiteColorSymbol;
        this.image = image;
        charsFromImage = new char[image.getHeight()][image.getWidth()];
    }

    public void setCharsFromImage() {

        for(int i = 0; i < image.getHeight(); i++) {
            for(int j = 0; j < image.getWidth(); j++) {
                int color = image.getRGB(i, j);
                if(color == Color.BLACK.getRGB()) {
                    charsFromImage[j][i] = blackColorSymbol;
                }
                if(color == Color.WHITE.getRGB()) {
                    charsFromImage[j][i] = whiteColorSymbol;
                }
            }
        }
    }
    public void printArray() {
        for(int i = 0; i < image.getHeight(); i++) {
            for(int j = 0; j < image.getWidth(); j++) {
                System.out.print(charsFromImage[i][j]);
            }
            System.out.println();
        }
    }
}
