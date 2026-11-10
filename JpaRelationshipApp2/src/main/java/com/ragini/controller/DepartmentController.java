package com.ragini.controller;

import com.ragini.model.Department;
import com.ragini.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {

    private DepartmentService departmentService ;

    public DepartmentController(DepartmentService departmentService){

        this.departmentService = departmentService ;
    }

    @PostMapping           // add department method
    public ResponseEntity<String> createDepartment(@RequestBody Department department){

        departmentService.createDepartment(department);
        return ResponseEntity.ok("DONE");
    }

    @DeleteMapping("/{deptId}")         // remove department
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer deptId){

        departmentService.removeDepartment(deptId);
        return ResponseEntity.ok("DONE");
    }



}
