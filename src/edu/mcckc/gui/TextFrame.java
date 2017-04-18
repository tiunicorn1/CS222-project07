package edu.mcckc.gui;

import edu.mcckc.domain.TextManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rharris on 4/4/2017.
 */
public class TextFrame extends JFrame
{
    private TextEntryPanel pnlEntry;
    private TextViewPanel pnlView;
    private TextManager manager;

    public TextFrame()
    {
        pnlEntry = new TextEntryPanel();
        pnlView = new TextViewPanel();
        manager = new TextManager();

        // Send the View panel to Entry panel (as a reference) using a SETTER in the Entry Panel
        pnlEntry.setViewPanelReference(pnlView);
        pnlEntry.setManagerReference(manager);
        pnlView.setManagerReference(manager);

        add(pnlEntry, BorderLayout.WEST);
        add(pnlView, BorderLayout.EAST);

    }
}
