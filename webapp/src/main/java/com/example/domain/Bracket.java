package com.example.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author toygan
 * @version 0.1
 * <p>
 * Bracket class that allows data to be passed between frontend and backend.
 */
@XmlRootElement
public class Bracket
{
    private int number;

    /**
     * Bracket constructor without help.
     */
    public Bracket()
    {

    }

    /**
     * @param number int number to set the Bracket.
     */
    public Bracket(int number)
    {
        this.number = number;
    }

    /**
     * @return int numher of the brackets.
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * @param number int number to be set on the field.
     */
    public void setNumber(int number)
    {
        this.number = number;
    }
}
