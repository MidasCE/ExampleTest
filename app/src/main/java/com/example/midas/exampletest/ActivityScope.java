package com.example.midas.exampletest;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.inject.Scope;

/**
 * Created by Midas on 4/3/2559.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {}