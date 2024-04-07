package com.unique.uniqueidgenerator.controller;

import com.unique.uniqueidgenerator.service.UID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController("uid")
public class Controller {

    @GetMapping("/")
    public BigInteger generateUniqueID() {
        return UID.randomUniqueId();
    }
}
