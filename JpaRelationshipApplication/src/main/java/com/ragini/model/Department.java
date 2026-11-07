package com.ragini.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Department {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id ;
   private String name ;

   @OneToMany(mappedBy = "department")
   private List<Student> students = new ArrayList<>();


}

/********
 * @OneToMany --> There is @OneToMany with students which the department field is
 *               already handling . because I can only do inverse mapping of @ManyToOne .
 *
 * ************/