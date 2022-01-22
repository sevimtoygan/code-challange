package com.example.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
	    
    @Override
    public String bracketCalculation(String data)
    {
    	// call API
        return null;
    }
    

    
}