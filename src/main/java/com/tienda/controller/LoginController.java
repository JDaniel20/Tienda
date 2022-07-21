
package com.tienda.controller;

import org.springframework.stereotype.Controller;

@Controller 
public class LoginController {
    public String index(){
        return "/login";
    }
}
