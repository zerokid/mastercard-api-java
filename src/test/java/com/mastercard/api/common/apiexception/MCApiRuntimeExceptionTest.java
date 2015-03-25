package com.mastercard.api.common.apiexception;

import junit.framework.TestCase;

public class MCApiRuntimeExceptionTest extends TestCase {

    private MCApiRuntimeException exception;

    public void setUp(){
        exception = new MCApiRuntimeException("message",404);
    }

    public void testGetMessage(){
        assertTrue(exception.getMessage().equals("message"));
    }

    public void testGetHttpCode(){
        assertTrue(exception.getHttpCode() == 404);
    }

    public void testDefaultStatusCode(){
        MCApiRuntimeException mcException = new MCApiRuntimeException("message2");
        assertTrue(mcException.getHttpCode() == 0);
    }
}
