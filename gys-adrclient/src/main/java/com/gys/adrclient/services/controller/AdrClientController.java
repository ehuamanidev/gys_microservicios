package com.gys.adrclient.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gys.model.PingRequest;
import com.gys.model.PingResponse;
import com.gys.adrclient.services.service.SadrClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("adrclient/")
public class AdrClientController {

	private static Logger logger = LoggerFactory.getLogger(AdrClientController.class);
	
	@Autowired
	private SadrClient sadrClient;

    
    @RequestMapping(method=RequestMethod.POST, value="ping")
    @ApiOperation(value = "ping", nickname = "ping", response = PingResponse.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), 
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), 
			@ApiResponse(code = 500, message = "Failure") 
			})
    public PingResponse ping(@ApiParam(value = "request", required = true) @RequestBody(required=true) PingRequest request) {
    	return new PingResponse("Envío desde Adr-Client");
    }
    
    @RequestMapping(method=RequestMethod.POST, value="pingSadr")
    @ApiOperation(value = "pingSadr", nickname = "pingSadr",response = PingResponse.class)
    @ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), 
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), 
			@ApiResponse(code = 500, message = "Failure") 
			})
    public PingResponse pingSadr(@ApiParam(value = "request", required = true) @RequestBody(required=true) PingRequest request) {
    	
    	return sadrClient.pingSadr(request);
    }
}