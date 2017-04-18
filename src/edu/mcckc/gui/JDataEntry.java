package edu.mcckc.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by E0660645 on 4/3/2017.
 */
public class JDataEntry extends JPanel
{
    private JLabel lblDataEntry;
    private JLabel lblError;
    private JTextField txtDataEntry;
    private String errorMessage;

    private JPanel row1;
    private JPanel row2;

    public JDataEntry()
    {
        this("Enter Text:", 100, "");
    }

    public JDataEntry(String labelText,
                      int textFieldSize,
                      String textFieldDefault)
    {
        errorMessage = "";
        lblDataEntry = new JLabel(labelText);
        txtDataEntry = new JTextField(textFieldDefault, textFieldSize);
        lblError = new JLabel(errorMessage);

        row1  = new JPanel();
        row2  = new JPanel();

        //  these get added using the FLOW LAYOUT
        row1.add(lblDataEntry);
        row1.add(txtDataEntry);

        row2.add(lblError);

        setLayout(new GridLayout(2,1));
        add(row1);
        add(row2);
    }

    public String getText()
    {
        return txtDataEntry.getText();
    }

    public void setText(String text)
    {
        txtDataEntry.setText(text);
    }

    public int getInt() throws Exception
    {
        blankOutError();
        int outputValue = 0;

        try {
            outputValue = Integer.parseInt(getText());
        }
        catch (Exception ex)
        {
            lblError.setText("Please enter valid text");
            throw new Exception("Invalid Data");
        }
        return outputValue;
    }

   /* public double getDouble() throws Exception
    {
        blankOutError();
        double outputValue = 0;

        try {
            outputValue = Double.parseDouble(getText());
        }
        catch (Exception ex)
        {
            lblError.setText("Please enter valid text");
            throw new Exception("Invalid Data");
        }
        return outputValue;
    }
    */

    private void blankOutError()
    {
        lblError.setText("");
    }
}
