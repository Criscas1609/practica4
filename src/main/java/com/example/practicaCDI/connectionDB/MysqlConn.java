package com.example.practicaCDI.connectionDB;

import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD ,FIELD, PARAMETER, TYPE, CONSTRUCTOR})
public @interface MysqlConn {
}
