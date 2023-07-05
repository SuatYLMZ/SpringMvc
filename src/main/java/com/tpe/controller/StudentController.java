package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
//@ResponseBody
//@RestController // used if we need RestFul API
//@RestController = @ResponseBody + @Controller
@RequestMapping("/students") //http://localhost:8080/SpringMvc/students
//@RequestMapping can be used in class level and method level
//when we use RequestMapping on a class level path will be applied for all the methods inside the class
public class StudentController {

    //ModelAndView = Holder for both Model and View in the MVC framework
    //it returns either ModelAndView obj (data+view)
    // or String view name

    @Autowired
    private StudentService service;

    @GetMapping("/hi") //http://localhost:8080/SpringMvc/students/hi
    public ModelAndView sayHi(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hello");
        mav.addObject("messagebody", "I am a Student Management System");
        mav.setViewName("hi"); //hi.jsp
        return mav;
        //ViewResolver will find hi.jsp file from location we have set
        //and binds data from mav to jps

    }

    //1 - Create Student
    @GetMapping("/new") //http://localhost:8080/SpringMvc/students/new
    public String sendStudentForm(@ModelAttribute ("student") Student student){

        return "studentForm";

        //@ModelAttribute--used to bind data from view file to model
    }

//    @PostMapping("/saveStudent")//http://localhost:8080/SpringMvc/students/saveStudent
//    public String createStudent(@Valid @ModelAttribute Student student){
//        service.saveStudent(student);
//        return "redirect:/students";
//    }

    //if we want to see Validation messages on the form page
    @PostMapping("/saveStudent")//http://localhost:8080/SpringMvc/students/saveStudent
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "studentForm";
        }

        service.saveStudent(student);
        return "redirect:/students";
    }

    //2-get all students
    @GetMapping//http://localhost:8080/SpringMvc/students
    public ModelAndView getAllStudents(){
        List<Student> list = service.getAllStudents();
        ModelAndView mav = new ModelAndView();
        mav.addObject("students", list);
        mav.setViewName("students"); //students.jsp
        return mav;
    }

}
