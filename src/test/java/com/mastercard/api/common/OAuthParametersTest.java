package com.mastercard.api.common;

import junit.framework.TestCase;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class OAuthParametersTest extends TestCase {

    private OAuthParameters parameters;

    public void setUp(){
        parameters = new OAuthParameters();
    }

    public void testGetBaseParameters(){
        parameters.put("key","value");
        parameters.put("key2","value2");
        Map<String, SortedSet<String>> baseParameters = parameters.getBaseParameters();
        assertTrue(baseParameters.containsKey("key"));
        assertTrue(baseParameters.containsKey("key2"));
        assertFalse(baseParameters.containsValue("value"));
        assertFalse(baseParameters.containsValue("value2"));
        assertTrue(((Set) baseParameters.get("key")).contains("value"));
        assertTrue(((Set)baseParameters.get("key2")).contains("value2"));
    }

    public void testAddParameter(){
        parameters.addParameter("key","value");
        assertTrue(parameters.getBaseParameters().containsKey("key"));
        assertTrue(((Set) parameters.getBaseParameters().get("key")).contains("value"));
    }

    public void testRemoveBaseParameter(){
        parameters.addParameter("key", "value");
        assertTrue(parameters.getBaseParameters().containsKey("key"));
        parameters.removeBaseParameter("notPresent","alsoNotPresent");
        assertTrue(parameters.getBaseParameters().containsKey("key"));
        parameters.removeBaseParameter("key","value");
        assertTrue(parameters.getBaseParameters().containsKey("key"));
        assertFalse(((Set)parameters.getBaseParameters().get("key")).contains("value"));
    }

    public void testGet(){
        parameters.addParameter("key","foo");
        parameters.addParameter("key","bar");
        assertTrue(parameters.get("key").equals("bar"));
    }
}
