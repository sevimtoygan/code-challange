package com.example.services;

import javax.ejb.Local;

import com.example.domain.Bracket;

/**
 * @author Toygan Sevim
 * @version 0.1
 * <p>
 * Bracket data interface class that will serve to the controller.
 */
@Local
public interface BracketService {
		
    /**
     * @param bracket Bracket object that takes a single integer value.
     * @return int Possible valid bracket combinations in total.
     */
    int bracketCalculation(Bracket bracket);
}
