package com.nyist.sims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("toregist")
    public String toregist(){
        return "user/regist";
    }

    @RequestMapping("tologin")
    public String tologin(){
        return "index";
    }

    @RequestMapping("jump")
    public String tojump(){
        return "test/jump";
    }

    @RequestMapping("index")
    public String index(){
        return "menu/main";
    }
    @RequestMapping("uploadtest")
    public String upload(){
        return "user/upload";
    }


    @RequestMapping("notRole")
    public String testr(){
        return "menu/nopermission";
    }

    @RequestMapping("tostudentlist")
    public String tostudentlist(){
        return "student/allstudent";
    }

    @RequestMapping("toaddclass")
    public String toaddclass(){
        return "class/addclass";
    }


    @RequestMapping("toallpermission")
    public String toallpermission(){
        return "permission/allrole_permission";
    }


    @RequestMapping("toleft")
    public String toleft(){
        return "menu/left";
    }

    @RequestMapping("toallrole")
    public String toallrole(){
        return "permission/allrole";
    }


    @RequestMapping("toclassgrades")
    public String toclassgrades(){
        return "class/classgrades";
    }

    @RequestMapping("toaddclassgrades")
    public String toaddclassgrades(){
        return "class/addclassgrades";
    }

    @RequestMapping("toindex")
    public String toindex(){
        System.out.println("进入了跳转");
        return "homepage/index";
    }

    @RequestMapping("totestes")
    public String totestes(){
        return "class/classtestes";
    }



}
