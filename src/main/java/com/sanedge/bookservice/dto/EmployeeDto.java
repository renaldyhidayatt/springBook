package com.sanedge.bookservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Long empId;
    private String fname;
    private String lname;
}
