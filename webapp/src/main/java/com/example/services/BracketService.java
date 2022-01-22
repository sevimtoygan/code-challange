package com.example.services;

import javax.ejb.Local;
import javax.xml.rpc.ServiceException;

/**
 * @author Toygan Sevim
 * @version 0.1
 *
 * Bracket data interface class that will serve to the controller.
 */
@Local
public interface BracketService
{

    /**
     * @return String
     * @throws ServiceException illegal service ex.
     */
    String get() throws ServiceException;

    /**
     * @param data - String
     * @return String
     * @throws ServiceException Illegal service ex.
     */
    String bracketCalculation(String data) throws ServiceException;
}
