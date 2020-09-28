/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.api.unitel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author stl_sdd_thavithong
 */
@SpringBootApplication
@ComponentScan({"com.unitel.api.unitel.", "com.unitel.api.unitel.controller"})
public class StartClass extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartClass.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StartClass.class, args);
    }
}
