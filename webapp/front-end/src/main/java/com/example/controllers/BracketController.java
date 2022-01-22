package com.example.controllers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.rpc.ServiceException;

import com.example.services.BracketService;

//		http://localhost:8080/webapp/v1/brackets
@Path("/brackets")
public class BracketController {
			
    private BracketService service;
	
    @Inject
	public BracketController(final BracketService service)
    {
		this.service = service;
	}
	
	public BracketController()
	{
		
	}


    @GET
    @Path("/get")
    public Response getStatus(@Context HttpHeaders headers) throws ServiceException {    	
        return Response.status(Status.OK)
                .entity(service.get())
                .build();
    }

    @POST
    @Path("/calculate")
    public Response calculateBrackets(String data) throws ServiceException
    {        
        String result = service.bracketCalculation(data);
        return Response.status(Status.OK).entity(result).type(MediaType.TEXT_PLAIN).build();
    }

}