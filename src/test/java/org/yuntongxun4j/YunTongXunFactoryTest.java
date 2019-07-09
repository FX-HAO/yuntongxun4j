package org.yuntongxun4j;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import yuntongxun4j.YunTongXunFactory;
import yuntongxun4j.conf.Configuration;

import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class YunTongXunFactoryTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void defaultProperties()
    {
        YunTongXunFactory factory = new YunTongXunFactory();
        Configuration conf = factory.getConf();
        assertTrue(conf.getGateway().equals("https://app.cloopen.com:8883"));
    }

    @Test
    public void customProperties()
    {
        Properties props = new Properties();
        props.setProperty("gateway", "http://localhost:8080");
        YunTongXunFactory factory = new YunTongXunFactory(props);
        Configuration conf = factory.getConf();
        assertTrue(conf.getGateway().equals("http://localhost:8080"));
    }
}
