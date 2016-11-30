package com.lynas.controller.view

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

/**
 * Created by sazzad on 7/15/16
 */

@Controller
class HomeController constructor() {

    @RequestMapping(value = "/")
    fun home(request: HttpServletRequest): String {

        return "home"
    }

    @RequestMapping(value = "/login")
    fun login():String{
        return "login"
    }

    @RequestMapping(value = "/newHome")
    fun newHome(): String {
        return "newHome"
    }
}