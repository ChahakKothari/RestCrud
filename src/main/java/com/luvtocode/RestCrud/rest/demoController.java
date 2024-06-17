package com.luvtocode.RestCrud.rest;
import com.luvtocode.RestCrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class demoController {
 private  List<Student> thestudent;

 @PostConstruct
 public void loadData(){
     thestudent=new ArrayList<>();
     thestudent.add(new Student("Chahak","kothari"));
     thestudent.add(new Student("Deepti","Trivedi"));
     thestudent.add(new Student("chad","darrby"));

 }

    @GetMapping("/student")
    public List<Student> getStudent(){


        return thestudent ;
    }

    @GetMapping("/student/{StudentId}")
    public Student getStudent(@PathVariable int StudentId){

     //check the studentid again list size
        if((StudentId>=thestudent.size())|| (StudentId<0)){
            throw new StudentNotFoundException("student id not found-" +StudentId);
        }
     return thestudent.get(StudentId);
    }
    //add exception handler using @ExceptionHandler



}
