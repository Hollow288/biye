package com.braisedpanda.sims.controller;

import com.braisedpanda.sims.bean.Class_Grades;
import com.braisedpanda.sims.bean.Class_Grades_Card;
import com.braisedpanda.sims.bean.SClass;
import com.braisedpanda.sims.mapper.GradesMapper;
import com.braisedpanda.sims.service.ClassService;
import com.braisedpanda.sims.service.GradesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    GradesService gradesService;

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
        gradesService.addClass_Grades_Card(classGradesCard);
        return "menu/msg";
    }

    @ResponseBody
    @RequestMapping("classtestes")
    public HashMap<String,Object> clsstestes(int page,int limit){
        HashMap<String,Object> resultMap = new HashMap<>();

        int size = gradesService.getAllClass_Grades_Card().size();
        PageHelper.startPage(page,limit);
        List<Class_Grades_Card> allClassGradesCard = gradesService.getAllClass_Grades_Card();
        PageInfo<Class_Grades_Card> classGradesCardPageInfo = new PageInfo<>(allClassGradesCard);
        List<Class_Grades_Card> list = classGradesCardPageInfo.getList();
        List<Object> customList = new ArrayList<>();
        for (Class_Grades_Card classGradesCard : list) {
            Class_Grades_Card lastcard = new Class_Grades_Card();
            lastcard.setClass_grades_card_id(classGradesCard.getClass_grades_card_id());
            lastcard.setClass_id(classGradesCard.getClass_id());
            lastcard.setTest_time(classGradesCard.getTest_time());
            lastcard.setTest_describe(classGradesCard.getTest_describe());

            customList.add(lastcard);

        }

        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",size);
        resultMap.put("data",customList);
        return resultMap;

    }
}
