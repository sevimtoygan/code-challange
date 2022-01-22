package com.example.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bracket
{
    private int number;

    public Bracket()
    {

    }

    public Bracket(int number)
    {
        this.number = number;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }
}
