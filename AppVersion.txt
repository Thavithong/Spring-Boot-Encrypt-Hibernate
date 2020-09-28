/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.api.unitel.controller;

import com.unitel.api.common.utils.EncryptDecryptUtils;
import java.net.URLDecoder;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author stl_sdd_thavithong
 */
@RestController
@RequestMapping(value = "/api")
public class AppVersion {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AppVersion.class.getSimpleName());
    private static final String filePath = "../etc/ewallet";

    @GetMapping(value = "/v1")
    public ResponseEntity<String> index() throws Throwable {
        logger.info("*********** Start visit api **********");
        return new ResponseEntity<String>("Created by Thavithong!", HttpStatus.OK);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<String> readEncry() throws Throwable {
        logger.info("*********** Start readEncry **********");
        buildSessionFactory(filePath);
        return new ResponseEntity<String>("Created by Thavithong!", HttpStatus.OK);
    }

    public static void buildSessionFactory(String decryFile) {
        try {
            String decryptString = EncryptDecryptUtils.decryptFile(URLDecoder.decode(decryFile));
            String[] appProperties = decryptString.split("\r\n");

            for (int i = 0; i < appProperties.length; i++) {
                int splitPoint = appProperties[i].indexOf("=");

                String name = appProperties[i].substring(0, splitPoint);
                String value = appProperties[i].substring(splitPoint + 1);
                logger.info(name + ":" + value);
            }

        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

}
