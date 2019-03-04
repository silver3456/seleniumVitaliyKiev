package com.usa.web.smoke;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SmokeTest {
    private static Logger LOG = Logger.getLogger(SmokeTest.class.getName());

    @Test
    public void test(){
        LOG.info("Hello from smoke test");
    }
}
