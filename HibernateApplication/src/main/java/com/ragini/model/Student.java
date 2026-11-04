package com.ragini.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "AllStudent")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",
            nullable = false,
            length = 200
    )
    private String name;

    @Column(name = "email",
            unique = true,
            nullable = false,
            length = 200,
            insertable = true,
            updatable = true
    )
    private String email;
    private int age;

    @ElementCollection
    @CollectionTable(
            name = "student_address",
            joinColumns = @JoinColumn(name = "student_id")

    )
    private Set<Address> addressSet ;

    public Student(){  // default constructor

    }

    public Student(Integer id, String name, String email, int age, Set<Address> addressSet) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.addressSet = addressSet;
    }

//    @ElementCollection
//    @CollectionTable(
//            name = "student_skills",
//            joinColumns = @JoinColumn(name = "student_id")
//
//    )
//    private Set<String> skills ;

//    public Student(Integer id, String name, String email, int age, Set<String> skills) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.skills = skills;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", addressSet=" + addressSet +
                '}';
    }

//    public Set<String> getSkills() {
//        return skills;
//    }

//    public void setSkills(Set<String> skills) {
//        this.skills = skills;
//    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", age=" + age +
//                ", skills=" + skills +
//                '}';
//    }

    /*
     //  ***************************  3rd part  *************************
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo" ,
                    column = @Column(name = "current_house_no")
            ) ,
            @AttributeOverride(
                    name = "street" ,
                    column = @Column(name = "current_street")
            ) ,
            @AttributeOverride(
                    name = "city" ,
                    column = @Column(name = "current_city")
            ) ,
            @AttributeOverride(
                    name = "state" ,
                    column = @Column(name = "current_state")
            ) ,
            @AttributeOverride(
                    name = "pinCode" ,
                    column = @Column(name = "current_pincode")
            ) ,
    })
    private Address currentAddress ;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo" ,
                    column = @Column(name = "permanent_house_no")
            ) ,
            @AttributeOverride(
                    name = "street" ,
                    column = @Column(name = "permanent_street")
            ) ,
            @AttributeOverride(
                    name = "city" ,
                    column = @Column(name = "permanent_city")
            ) ,
            @AttributeOverride(
                    name = "state" ,
                    column = @Column(name = "permanent_state")
            ) ,
            @AttributeOverride(
                    name = "pinCode" ,
                    column = @Column(name = "permanent_pincode")
            ) ,
    })
    private Address permanentAddress ;

    public Student(){

    }

    public Student(Integer id, String name, String email, int age, Address currentAddress, Address permanentAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", currentAddress=" + currentAddress +
                ", permanentAddress=" + permanentAddress +
                '}';
    }

     */

            //  ***************************  2nd part  *************************

 /*
    public Student(Integer id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

 */


    /*              //***************************  1st part  *************************
    @Column(precision = 5, scale = 2)
    private BigDecimal percentage;
    private LocalDate dateOfBirth;
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @Transient
    private String displayName;

    @Lob
    private String description;

    @Convert(converter = BooleanToStringConverter.class)
    private Boolean isMonitor;


    public Student() {
    }

    public Student(Integer id, String name, String email, int age, BigDecimal percentage, LocalDate dateOfBirth, LocalDateTime createAt, StudentStatus status, String displayName, String description, Boolean isMonitor) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.percentage = percentage;
        this.dateOfBirth = dateOfBirth;
        this.createAt = createAt;
        this.status = status;
        this.displayName = displayName;
        this.description = description;
        this.isMonitor = isMonitor;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsMonitor() {
        return isMonitor;
    }

    public void setIsMonitor(Boolean isMonitor) {
        this.isMonitor = isMonitor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", percentage=" + percentage +
                ", dateOfBirth=" + dateOfBirth +
                ", createAt=" + createAt +
                ", status=" + status +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", isMonitor='" + isMonitor + '\'' +
                '}';
    }
     */
}
