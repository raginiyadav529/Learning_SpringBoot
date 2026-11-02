package com.ragini.repo;

import com.ragini.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

//    String url = "jdbc:mysql://localhost:3306/Student_DB";
//    String user = "root";
//    String password = "Ragini@123";

    private JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    private StudentRowMapper studentRowMapper = new StudentRowMapper();

    private RowMapper<Student> rowMapper =
            new BeanPropertyRowMapper<>(Student.class);

    public void createStudent(Student student) {

        String sql = """
                INSERT INTO students(name , email ,age)
                VALUES(?,?,?)
                
                """;
        int rowAffected = jdbcTemplate.update(sql,
                student.getName(),
                student.getEmail(),
                student.getAge());

        if (rowAffected == 0) {

            System.out.println("Student not created  !");
        } else {

            System.out.println("Student created successfully!");
        }
    }

    public void updateStudent(Student student, int id) {

        String sql = """
                UPDATE students SET name =? ,
                email =? ,
                age = ?
                WHERE id = ?
                
                """;

        int rowAffected = jdbcTemplate.update(sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                id);

        if (rowAffected == 0) {

            System.out.println("Student not updated !");
        } else {

            System.out.println("Student updated successfully!");
        }
    }

    public void deleteStudent(int id) {

        String sql = """
                DELETE FROM students
                WHERE id =?
                
                """;

        int rowAffected = jdbcTemplate.update(sql, id);

        if (rowAffected == 0) {

            System.out.println("Student not deleted !");
        } else {

            System.out.println("Student deleted successfully!");
        }
    }

    public Student getStudentById(int id) {

        String sql = """
                SELECT id , name , email ,age FROM students
                WHERE id =?
                
                """;
        return jdbcTemplate.queryForObject(sql, rowMapper, id);

        /** If a particular id is not present in database , queryForObject() method
         * will throw an EmptyResultDataAccessException
         * **/
    }

    public List<Student> getAllStudents() {

        String sql = """
                SELECT id , name , email , age  FROM students
                
                
                """;

        List<Student> studentList = jdbcTemplate.query(sql, rowMapper);
        return studentList;

    }
}
