package slfTest;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {

    @Test
    public void test() throws Exception {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello World");
        assertTrue(true);
    }
}