package com.oracle.jp.fn.country;

import io.micronaut.runtime.Micronaut;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/code-at-customer")
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
