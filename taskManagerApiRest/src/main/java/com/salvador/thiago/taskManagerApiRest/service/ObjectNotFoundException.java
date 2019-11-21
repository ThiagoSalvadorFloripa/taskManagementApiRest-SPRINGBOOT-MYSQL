/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.service;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

public class ObjectNotFoundException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
