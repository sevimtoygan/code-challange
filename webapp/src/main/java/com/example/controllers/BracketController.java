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

import com.example.services.BracketService;

//  http://localhost:8080/ejb-1.0-SNAPSHOT/v1/brackets
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
		// TODO Auto-generated constructor stub
	}


    @GET
    @Path("/get")
    public Response getStatus(@Context HttpHeaders headers) {    	
        String userAgent = headers.getRequestHeader("user-agent").get(0);
        return Response.status(Status.OK)
                .entity("Webapp Status is called, userAgent : " + userAgent)
                .build();
    }

    @POST
    @Path("/calculate")
    public Response calculateBrackets(String data)
    {        
        String result = service.bracketCalculation(data);
        return Response.status(Status.OK).entity(result).type(MediaType.TEXT_PLAIN).build();
    }

}