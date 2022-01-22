package com.example.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.domain.Bracket;

/**
 * @author Toygan Sevim
 * @version 0.1
 * <p>
 * Bracket data class that will act as a service to communicate between angular models and app
 * server. Stateless logic operations for sessions.
 */
@Stateless
@LocalBean
public class BracketServiceImpl implements BracketService {
	
    private static Logger logger = LoggerFactory.getLogger(BracketServiceImpl.class);
    
    @Override
    public int bracketCalculation(Bracket bracket)
    {
    	logger.info("calculating brackets with number: {}", bracket.getNumber());
    	
    	Integer counter = 0;
        int number = bracket.getNumber();
        int position = 0, open = 0, close = 0;
        char[] displayArray = new char[number * 2];
        if (number > 0)
        {
        	counter = privatePrint(counter, displayArray, position, number, open, close);
            System.out.println("Totaled " + counter);
            return counter;
        }
        else if (number == 0)
        {
            return 0;
        }
        // exceptions
        return 0;
    }
    
    private int privatePrint(Integer counter, char[] str, int pos, int num, int open, int close)
    {
        if (close == num)
        {
            // print the possible combinations
            for (int i = 0; i < str.length; i++)
                System.out.print(str[i]);
            System.out.println(" Added new one");
            counter = counter + 1;
            return counter;
        }
        else
        {
            if (open > close)
            {
                str[pos] = '}';
                counter = privatePrint(counter, str, pos + 1, num, open,
                        close + 1);
            }
            if (open < num)
            {
                str[pos] = '{';
                counter = privatePrint(counter, str, pos + 1, num, open + 1,
                        close);
            }
        }
        return counter;
    }
    
}