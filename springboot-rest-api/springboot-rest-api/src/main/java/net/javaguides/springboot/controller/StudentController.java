package net.javaguides.springboot.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.javaguides.springboot.Bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("students")
@RestController
public class StudentController {
    /*
    @GetMapping("student")
    public Student getStudent(){
        Student student=new Student(
                1,
                "bandaru",
                "Lavanya"
        );
        return student;
    }

     */
    @GetMapping
    public List<Student> getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(2,"chandha","sekhar"));
        students.add(new Student(3,"chandrika","hariteja"));
        students.add(new Student(4,"sankari","Nandhu"));
        students.add(new Student(5,"surya","narayana"));
        students.add(new Student(6,"chadalawada","bhuvaneshwari"));
        return students;

    }
    @GetMapping("studentsResponseEntity")
    public ResponseEntity<List<Student>> getStudentsMethod(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(2,"chandha","sekhar"));
        students.add(new Student(3,"chandrika","hariteja"));
        students.add(new Student(4,"sankari","Nandhu"));
        students.add(new Student(5,"surya","narayana"));
        students.add(new Student(6,"chadalawada","bhuvaneshwari"));
        return ResponseEntity.ok(students);

    }
    //spring boot  rest Api with Path Variable
    //{id}-URI Template variable
    //http://localhost:8080/students/2/first-name/last-name
    @GetMapping("studentsResponseEntity/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariableMethod( @PathVariable("id") int StudentId,
                                        @PathVariable("first-name") String firstname,
                                        @PathVariable("last-name") String lastname){
        Student student= new Student(StudentId ,firstname,lastname);
       return ResponseEntity.ok(student);

    }
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable( @PathVariable("id") int StudentId,
                                        @PathVariable("first-name") String firstname,
                                        @PathVariable("last-name") String lastname){
        return new Student(StudentId ,firstname,lastname);

    }
    //spring boot rest APi with request Param
    //http://localhost:8080/students?id=1&firstname=ramesh&lastname=suresh
    @GetMapping("query")
    public Student studentRequestVariable( @RequestParam int id,
                                           @RequestParam String firstname,
                                           @RequestParam String lastname){
        return new Student(id,firstname,lastname);
    }
    //spring boot rest Api that handels HTTP Post Request -create an new resources
    //@Postmapping & @RequestBody
    @PostMapping("create")
   // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastname());
        return  new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    //spring boot REST Api that handles HTTP Put request -updating existing resources
    @PutMapping("student/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getId());
        System.out.println(student.getLastname());
        System.out.println(student.getFirstName());
        return student;

    }
//spring boot rest API that handles HTP DELETE request -delete the existing resource
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "student delete successFully";

    }
// create an response entity class
    @GetMapping("student")
    public ResponseEntity<Student> getStudentMethod(){
        Student student=new Student(
                1,
                "bandaru",
                "Lavanya"
        );
      //  return new ResponseEntity<>(student,HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header","chitti").body(student);

    }
}
