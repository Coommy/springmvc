package com.commy.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuht on 2017/4/13.
 */
public class TestLogger {
    private static Logger logger = LoggerFactory.getLogger(TestLogger.class);

    @Test
    public void testLogger(){
        logger.warn("123");
    }
}
