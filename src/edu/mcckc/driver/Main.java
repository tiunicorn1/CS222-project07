package edu.mcckc.driver;

import edu.mcckc.gui.TextFrame;
import org.apache.log4j.Logger;

import javax.swing.*;

public class Main
{

    public static void main(String[] args)
    {
        // My list of tasks: eat; sleep; shop. Okay? I know it is for me! 42

        Logger.getLogger(Main.class.getName()).debug("Inside Main Method");
        TextFrame frmApp = new TextFrame();
        frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmApp.setSize(900,400);
        frmApp.setVisible(true);
    }
}
