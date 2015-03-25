package com.mastercard.api.common;

import junit.framework.TestCase;

public class HtmlEncoderTest extends TestCase {

    HtmlEncoder encoder;

    public void setUp(){
        encoder = new HtmlEncoder();
    }

    public void testEncode(){
        String testString = "A > B & C";
        assertTrue(encoder.encode(testString).equals("A &gt; B &amp; C"));
    }

    public void testDecode(){
        String testString = "A &gt; B &amp; C";
        assertTrue(encoder.decode(testString).equals("A > B & C"));
    }
}
