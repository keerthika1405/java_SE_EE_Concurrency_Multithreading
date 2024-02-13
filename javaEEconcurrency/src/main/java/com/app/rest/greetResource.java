
package com.app.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author ELCOT
 */
@Path("greetUser")
public class greetResource {
    
    @GET
    public String greetUser(){
    
        return "java EE concurrency starts";
    }
}
