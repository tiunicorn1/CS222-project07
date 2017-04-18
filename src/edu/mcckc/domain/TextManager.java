package edu.mcckc.domain;

import org.apache.log4j.Logger;

import java.util.ArrayList;



/**
 * Created by rharris on 4/4/2017.
 */
public class TextManager
{
    private String inputString;
    private ArrayList<String> lstVowels;
    private ArrayList<String> lstPunctuation;
    private int vowelCount;
    private int punctuationCount;
    private int consonantCount;
    private int numberCount;
    private int spaceCount;

    private boolean isVowel;
    private boolean isPunctuation;
    private boolean isNumber;
    private boolean isSpace;

    public TextManager()
    {
        lstVowels = new ArrayList<String>();
        lstPunctuation = new ArrayList<String>();
        initEverything();
    }

    private void initEverything()
    {
        initCounts();
        initBooleanFlags();
        initVowels();
        initPunctuation();


    }

    private void initCounts()
    {
        vowelCount = 0;
        punctuationCount = 0;
        consonantCount = 0;
        numberCount = 0;
        spaceCount = 0;

    }

    private void initBooleanFlags()
    {
        isVowel = false;
        isPunctuation = false;
        isNumber = false;
        isSpace = false;
    }


    private void initVowels()
    {
        lstVowels.add("a");
        lstVowels.add("e");
        lstVowels.add("i");
        lstVowels.add("o");
        lstVowels.add("u");
        lstVowels.add("y");


    }

    private void initPunctuation()
    {
        lstPunctuation.add(",");
        lstPunctuation.add(".");
        lstPunctuation.add("?");
        lstPunctuation.add("!");
        lstPunctuation.add(";");
        lstPunctuation.add(":");

    }

    public void processInputString(String inputString)
    {
        Logger.getLogger(TextManager.class.getName()).debug("Inside processInputString");

        Logger.getLogger(TextManager.class.getName()).debug("lstVowel : " + lstVowels);
        Logger.getLogger(TextManager.class.getName()).debug("lstPunctuation : " + lstPunctuation);

        Logger.getLogger(TextManager.class.getName()).debug("Input Text: " + inputString);

        initCounts();

        for(int i = 0; i < inputString.length(); i++)
        {
            Logger.getLogger(TextManager.class.getName()).debug("Input Text: " + inputString.substring(i, i+1));

            processAllCases(inputString.substring(i, i+1));

            getVowelCount();
            getConsonantCount();
            getNumberCount();
            getSpaceCount();
            getPunctuationCount();

            Logger.getLogger(TextManager.class.getName()).debug("V Counts: "+ vowelCount);
            Logger.getLogger(TextManager.class.getName()).debug("C Counts: "+ consonantCount);
            Logger.getLogger(TextManager.class.getName()).debug("# Counts: "+ numberCount);
            Logger.getLogger(TextManager.class.getName()).debug("S Counts: "+ spaceCount);
            Logger.getLogger(TextManager.class.getName()).debug("P Counts: "+ punctuationCount);
        }

    }

    private void processAllCases(String stringToken)
    {
        Logger.getLogger(TextManager.class.getName()).debug("Inside processAllCases");
        initBooleanFlags();
        processVowel(stringToken);
        if (!isVowel)
        {
            processPunctuation(stringToken);
            if (!isPunctuation)
            {
                processSpace(stringToken);
                if (!isSpace)
                {
                    processNumeric(stringToken);
                    if (!isNumber)
                    {
                        consonantCount++;
                    }
                }


            }
        }

        /*getVowelCount();
        getConsonantCount();
        getNumberCount();
        getSpaceCount();
        getPunctuationCount();

        Logger.getLogger(TextManager.class.getName()).debug("V Counts: "+ vowelCount);
        Logger.getLogger(TextManager.class.getName()).debug("C Counts: "+ consonantCount);
        Logger.getLogger(TextManager.class.getName()).debug("# Counts: "+ numberCount);
        Logger.getLogger(TextManager.class.getName()).debug("S Counts: "+ spaceCount);
        Logger.getLogger(TextManager.class.getName()).debug("P Counts: "+ punctuationCount);
        */


        /*if(stringToken.equals(lstVowels))
        {
            processVowel(stringToken);
        }
        else if (stringToken.equals(lstPunctuation))
        {
            processPunctuation(stringToken);
        }
        else if (stringToken.equals(" "))
        {
            processSpace(stringToken);
        }
        else
        {
            processNumeric(stringToken);
        }*/

    }

    private void processVowel(String stringToken)
    {
        Logger.getLogger(TextManager.class.getName()).debug("Inside processVowel");
        Logger.getLogger(TextManager.class.getName()).debug("Init isVowel: "+ isVowel);

        for(String token : lstVowels)
        {
            if(token.equals(stringToken.toLowerCase()))
            {
                isVowel = true;
                vowelCount++;
            }
        }

        Logger.getLogger(TextManager.class.getName()).debug("isVowel: "+ isVowel);


        /* if(stringToken.equals(lstVowels))
            {
                isVowel = true;
             } */


    }

    private void processPunctuation(String stringToken)
    {
        Logger.getLogger(TextManager.class.getName()).debug("Inside processPunctuation");
        Logger.getLogger(TextManager.class.getName()).debug("Init isPunctuation: "+ isPunctuation);

        for(String token : lstPunctuation)
        {
            if(token.equals(stringToken))
            {
                isPunctuation = true;
                punctuationCount++;
            }
        }

        Logger.getLogger(TextManager.class.getName()).debug("isPunctuation: "+ isPunctuation);

        /*if (stringToken.equals(lstPunctuation))
        {
            isPunctuation = true;
        }*/

    }

    private void processSpace(String stringToken)
    {
        Logger.getLogger(TextManager.class.getName()).debug("Inside processSpace");
        Logger.getLogger(TextManager.class.getName()).debug("Init isSpace: "+ isSpace);

        if(stringToken.equals(" "))
        {
            isSpace = true;
            spaceCount++;
        }

        Logger.getLogger(TextManager.class.getName()).debug("isSpace: "+ isSpace);

    }

    private void processNumeric(String stringToken)
    {
        Logger.getLogger(TextManager.class.getName()).debug("Inside processNumeric  ");
        Logger.getLogger(TextManager.class.getName()).debug("Init isNumber: "+ isNumber);

        int stringTokenInteger = 0;
        try
        {
            Logger.getLogger(TextManager.class.getName()).debug("Inside Try/Catch");
            stringTokenInteger = Integer.parseInt(stringToken);
            isNumber = true;
            numberCount++;
        }
        catch(Exception ex)
        {
            Logger.getLogger(this.getClass()).debug(ex.toString());
        }


        Logger.getLogger(TextManager.class.getName()).debug("stringTokenInteger: "+ stringTokenInteger);

        /*
        if(stringTokenInteger >= 0)
        {
            isNumber = true;
            numberCount++;
        }
        */


        Logger.getLogger(TextManager.class.getName()).debug("isNumber: "+ isNumber);

    }

    public String getConsonantCount()
    {
        return (String.format(" %d ", consonantCount));
    }

    public String getVowelCount()
    {
        return (String.format(" %d", vowelCount));

    }

    public String getNumberCount()
    {
        return (String.format(" %d", numberCount));

    }

    public String getPunctuationCount()

    {
        return (String.format(" %d", punctuationCount));
    }

    public String getSpaceCount()
    {
        return (String.format(" %d", spaceCount));
    }
}
