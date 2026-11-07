package com.ragini.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name ;

    @OneToOne(mappedBy = "user")  // mappedBy ->For ByDirectional we use mappedBy
    private Profile profile;

}
