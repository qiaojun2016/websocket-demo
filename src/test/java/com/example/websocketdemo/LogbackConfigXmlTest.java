package com.example.websocketdemo;
import com.example.websocketdemo.controller.LogbackConfigXml;
import org.junit.Test;

public class LogbackConfigXmlTest {
    @Test
    public void testPerformTask() throws Exception {
        LogbackConfigXml logbackConfigXml=new LogbackConfigXml();
        logbackConfigXml.performTask();
    }
}
