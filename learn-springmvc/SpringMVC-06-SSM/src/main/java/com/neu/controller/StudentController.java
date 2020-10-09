package com.neu.controller;

import com.neu.domain.Student;
import com.neu.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    //注册学生
    @PostMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        //调用service处理student
        int nums = studentService.addStudent(student);
        if( nums > 0 ){//注册成功
            tips = "学生【" + student.getName() + "】注册成功";
        }
        //添加数据
        mv.addObject("tips",tips);
        //指定结果页面
        mv.setViewName("result");
        return mv;
    }

    @GetMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudents(){
        List<Student> students = studentService.queryStudents();
        return students;
    }

}
