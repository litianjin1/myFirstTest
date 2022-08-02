package com.example.study.testDemo.test;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.regex.Pattern;


@Aspect
@Component
@Slf4j
public class TestLog {

    @Test
    public void testconsoleLogInfo(){

        log.info("logger.info........");
        log.error("logger.info........");
        log.warn("logger.info........");
        log.debug("logger.info........");


        String regex = "^([1-9][0-9]*)+(.[0-9]{1,2})?$";
        boolean matches = Pattern.matches(regex, "111&3");
        System.out.println(matches);
    }
}
