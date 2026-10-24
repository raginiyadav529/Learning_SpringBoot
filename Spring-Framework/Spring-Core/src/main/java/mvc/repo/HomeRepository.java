package mvc.repo;

import org.springframework.stereotype.Repository;

@Repository
public class HomeRepository {

    public HomeRepository(){

        System.out.println("Home Repo called !");
    }
}
