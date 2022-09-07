package com.sanedge.bookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanedge.bookservice.dto.EmployeeDto;

@RestController
@RequestMapping("/api/v1/grettins")
public class GreetingsController {

    @GetMapping
    public String greet() {
        return "How Are you?";
    }

    @GetMapping("/withnamerppv/{empId}")
    public String greetWithName(@PathVariable("empId") Long employeeId, @RequestParam("name11") String name,
            @RequestParam String lname) {
        return "How are you " + name + " " + lname + " " + employeeId + "?";
    }

    // http://localhost:8080/api/v1/greetings/save-employee
    @PostMapping("/save-employee")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDTO) {
        return employeeDTO;
    }
}
