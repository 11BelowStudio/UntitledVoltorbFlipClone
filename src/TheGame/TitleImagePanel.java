package TheGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TitleImagePanel extends JPanel {

    private BufferedImage titleImage; //the image being displayed on the title screen
    private boolean titleImageExists; //records if titleImage actually exists

    TitleImagePanel() {
        this.setLayout(new GridLayout(1,1));
        //ensures that whatever is displayed (be it the title image or the backup title) fills the entire panel

        titleImageExists = false; //the image doesn't exist until it does exist
        try {
            titleImage = ImageIO.read(new File("Images (pls no delet)/TitleImage.png"));
            this.setPreferredSize(new Dimension(titleImage.getWidth(), titleImage.getHeight()));
            titleImageExists = true;
            /*
            Attempts to access 'TitleImage.png', from the 'Images (pls no delet)' folder
            Sets preferred size of this panel to whatever the size of the TitleImage image is
            Also declares that the title image does, in fact, exist
            */

        } catch (Exception e){
            /*
            making sure that the user can still see the title screen info if the image is missing/inaccessible
            the backupTitle JTextArea pretty much has all the info on the title screen image,
            but delivers it in a much more depressing way.
            */
            System.out.println("title image broke oof");
            JTextArea backupTitle = new JTextArea(
                    "Untitled Game which is Completely Unrelated to Minesweeper #1804170\n\n"
                            + "pls press the start button to start playing the game\n\n"
                            + "(title image broke oof)"
            );
            backupTitle.setLineWrap(true);
            backupTitle.setWrapStyleWord(true);
            backupTitle.setEditable(false);
            backupTitle.setRows(7);
            this.add(backupTitle);
        }
    }

    @Override
    public void paint(Graphics g) {
        if (titleImageExists) {
            g.drawImage(titleImage, 0, 0, this);
            //will only attempt to draw the title image if it actually exists
        } else{
            super.paint(g);
            //pretty much not overridden if the title image does not exist
        }
    }
}