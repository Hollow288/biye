package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.Class_Grades_Card;
import com.braisedpanda.shirotest.bean.Nation;
import com.braisedpanda.shirotest.bean.SClass;
import com.braisedpanda.shirotest.mapper.GradesMapper;
import com.braisedpanda.shirotest.service.ClassService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘继涛
 * @version 1.0
 */
@Controller
public class TestController {


    @Autowired
    ClassService classService;
    @Autowired
    GradesMapper gradesMapper;

//    跳转到添加考试信息界面,并将我们班级的id数据返回
    @RequestMapping("toaddtest")
    public String addtest(Model model){

        System.out.println("进入到了方法");
        List<SClass> classList = classService.getAllClass();
        model.addAttribute("classList",classList);
        return "test/addtest";
    }

    @RequestMapping("toaddclassgradcard")
    public String toaddclassgradcard(Class_Grades_Card cgc){
        Class_Grades_Card classGradesCard = new Class_Grades_Card();
        BeanUtils.copyProperties(cgc,classGradesCard);
        //去除日期中的空格
        String new_time = cgc.getTest_time().replace("-", "");
        classGradesCard.setClass_grades_card_id("CGC"+cgc.getClass_id()+new_time);
        gradesMapper.addClass_Grades_Card(classGradesCard);
        return "menu/msg";
    }
}
