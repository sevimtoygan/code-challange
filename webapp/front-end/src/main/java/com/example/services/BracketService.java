package com.example.services;

import javax.ejb.Local;
import javax.xml.rpc.ServiceException;

@Local
public interface BracketService {
	
    String get() throws ServiceException;
    
    String bracketCalculation(String data) throws ServiceException;
}