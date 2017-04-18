package edu.mcckc.gui;

import edu.mcckc.domain.TextManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rharris on 4/4/2017.
 */
public class TextEntryPanel extends JPanel implements ActionListener
{
    private JDataEntry deInput;
    private JButton btnSubmit;
    private  JPanel row1;
    private  JPanel row2;
    private TextViewPanel pnlView;
    private TextManager manager;


    public void setViewPanelReference(TextViewPanel pnlView)
    {
        this.pnlView = pnlView;
    }

    public void setManagerReference(TextManager manager)
    {
        this.manager = manager;
    }

    public TextEntryPanel()
    {
        deInput = new JDataEntry("Enter Text: ", 50, "");
        btnSubmit = new JButton("Submit");
        row1 = new JPanel();
        row2 = new JPanel();

        btnSubmit.setActionCommand("add");
        btnSubmit.addActionListener(this);

        setLayout(new GridLayout(2, 2));

        row1.add(deInput);
        row2.add(btnSubmit);

        add(row1);
        add(row2);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getActionCommand().toLowerCase().equals("add"))
        {

            //lblError.setText("");

            try
            {
                manager.processInputString(deInput.getText());
                pnlView.processInputString(deInput.getText());


            }
            catch (NumberFormatException nfex)
            {
                Logger.getLogger(this.getClass()).debug(nfex.toString());
                //lblError.setText("Please enter valid data");
            }
            catch (Exception ex)
            {
                Logger.getLogger(this.getClass()).debug(ex.toString());
                //lblError.setText("OH NO !!!");
            }
        }

    }


}
