package edu.mcckc.gui;

import edu.mcckc.domain.TextManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rharris on 4/4/2017.
 */
public class TextViewPanel extends JPanel
{
    private JLabel lblCaptionVowels;
    private JLabel lblOutputVowels;
    private JLabel lblCaptionConsonants;
    private JLabel lblOutputConsonants;
    private JLabel lblCaptionNumbers;
    private JLabel lblOutputNumbers;
    private JLabel lblCaptionSpaces;
    private JLabel lblOutputSpaces;
    private JLabel lblCaptionPunctuation;
    private JLabel lblOutputPunctuation;

    private TextManager manager;

    public void setManagerReference(TextManager manager)
    {
        this.manager = manager;
    }

    public TextViewPanel()
    {
        lblCaptionVowels = new JLabel("Vowel Count: ");
        lblOutputVowels = new JLabel("0");
        lblCaptionConsonants = new JLabel("Consonant Count: ");
        lblOutputConsonants = new JLabel("0");
        lblCaptionNumbers = new JLabel("Digit Count: ");
        lblOutputNumbers = new JLabel("0");
        lblCaptionSpaces = new JLabel("Space Count: ");
        lblOutputSpaces = new JLabel("0");
        lblCaptionPunctuation = new JLabel("Punctuation Count: ");
        lblOutputPunctuation = new JLabel("0");

        setLayout(new GridLayout(5, 2));
        add(lblCaptionVowels);
        add(lblOutputVowels);
        add(lblCaptionConsonants);
        add(lblOutputConsonants);
        add(lblCaptionNumbers);
        add(lblOutputNumbers);
        add(lblCaptionSpaces);
        add(lblOutputSpaces);
        add(lblCaptionPunctuation);
        add(lblOutputPunctuation);

    }

    public void processInputString(String inputString)
    {
        Logger.getLogger(TextEntryPanel.class.getName()).debug("Inside processInputString");

        Logger.getLogger(TextEntryPanel.class.getName()).debug("Input Text: " + inputString);

        Logger.getLogger(TextEntryPanel.class.getName()).debug("getVowelCount: " + manager.getVowelCount());
        Logger.getLogger(TextEntryPanel.class.getName()).debug("getConsonantCount: " +  manager.getConsonantCount());
        Logger.getLogger(TextEntryPanel.class.getName()).debug("getNumberCount: " + manager.getNumberCount());
        Logger.getLogger(TextEntryPanel.class.getName()).debug("getSpaceCount: " + manager.getSpaceCount());
        Logger.getLogger(TextEntryPanel.class.getName()).debug("getPunctuationCount: " +  manager.getPunctuationCount());

        inputString = manager.getVowelCount();
        lblOutputVowels.setText(inputString);
        inputString = manager.getConsonantCount();
        lblOutputConsonants.setText(inputString);
        inputString = manager.getNumberCount();
        lblOutputNumbers.setText(inputString);
        inputString = manager.getSpaceCount();
        lblOutputSpaces.setText(inputString);
        inputString = manager.getPunctuationCount();
        lblOutputPunctuation.setText(inputString);

    }
}
