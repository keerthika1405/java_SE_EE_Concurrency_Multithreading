package com.app.rest;

//package com.app.test;
//
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;//provide  you a basic URI for aplication

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {

}
