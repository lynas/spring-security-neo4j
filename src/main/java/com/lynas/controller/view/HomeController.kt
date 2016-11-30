package com.lynas.controller.view

import com.lynas.model.AppUser
import com.lynas.service.AppUserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

/**
 * Created by sazzad on 7/15/16
 */

@Controller
class HomeController (val appUserService:AppUserService) {

    @RequestMapping(value = "/")
    fun home(request: HttpServletRequest): String {
        val appUser:AppUser? = appUserService.findById(48)
        println(appUser)
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