package com.example.services;

import javax.ejb.Local;
import javax.xml.rpc.ServiceException;

/**
 * @author Toygan Sevim
 * @version 0.1
 * <p>
 * Bracket data interface class that will serve to the controller.
 */
@Local
public interface BracketService {
	
    /**
     * @param date - String
     * @return String
     * @throws ServiceException
     */
    String get() throws ServiceException;
		
    /**
     * @param date - String
     * @return String
     */
    String bracketCalculation(String data) throws ServiceException;
}
