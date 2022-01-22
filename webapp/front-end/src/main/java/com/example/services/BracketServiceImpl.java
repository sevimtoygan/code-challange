package com.example.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.xml.rpc.ServiceException;

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
    public String bracketCalculation(String data) throws ServiceException
    {
		String value = null;
		Response response = null;
        try {
			Client client = ClientBuilder.newBuilder().build();
			WebTarget target = client.target("http://localhost:8080/ejb/v1/brackets/calculate");
			Entity<String> entity = Entity.text(data);
			response = target.request().post(entity);
			value = response.readEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (response != null) {
				response.close();
			}
		}
        return value;
    }

	@Override
	public String get() throws ServiceException {
		String value = null;
		Response response = null;
        try {
			Client client = ClientBuilder.newBuilder().build();
			WebTarget target = client.target("http://localhost:8080/ejb/v1/brackets/get");
			response = target.request().get();
			value = response.readEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (response != null) {
				response.close();
			}
		}
        return value;
	}
    

    
}