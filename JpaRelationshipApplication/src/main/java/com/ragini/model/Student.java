package com.ragini.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private  String name ;

    @ManyToOne                                   //(optional = false)
    @JoinColumn(name = "dept_id")               // , nullable = false
  private Department department ;

}


/*************
 *
 * @ManyToOne -> Many Student can have one department
 *
 * There is manyToOne mapping with the dept_id .
 *
 * ************/