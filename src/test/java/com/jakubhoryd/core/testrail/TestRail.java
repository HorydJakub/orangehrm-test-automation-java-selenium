package com.jakubhoryd.core.testrail;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestRail {

    // This is TestCase ID which can be found in the TC Details URL! Eg. https://testrail.ebs.crealogix.net/index.php?/cases/view/159319145 -> 159319145
    String id() default "none";
}
