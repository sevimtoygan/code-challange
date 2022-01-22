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

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.domain.Bracket;
import com.example.services.BracketService;

//http://localhost:8080/ejb/v1/brackets
@Path("/brackets")
public class BracketController
{

    private static Logger logger = LoggerFactory.getLogger(BracketController.class);

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
    public Response getStatus(@Context HttpHeaders headers)
    {
        String userAgent = headers.getRequestHeader("user-agent").get(0);
        return Response.status(Status.OK)
                .entity("EJB Status is called, userAgent : " + userAgent)
                .build();
    }

    @POST
    @Path("/calculate")
    public Response calculateBrackets(String data)
    {
        try
        {
            JSONObject json = new JSONObject(data);

            // Validate given json data
            int number = Integer.parseInt(json.getString("brackets"));
            if (number > 0)
            {
                int result = service.bracketCalculation(new Bracket(number));
                return Response.status(Status.OK).entity(result).type(MediaType.TEXT_PLAIN).build();

            }
            else if (number == 0)
            {
                return Response.status(Status.OK)
                        .entity("Zero is always Zero!").type(MediaType.TEXT_PLAIN).build();
            }
            else
            {
                return Response.status(Status.BAD_REQUEST).entity("Please enter a valid " +
                                "positive digit.")
                        .type(MediaType.TEXT_PLAIN).build();
            }
        } catch (JSONException ex)
        {
            logger.error(ex.getMessage());
            return null;
        }
    }

}
