package mvc.service;

public class Password {

   private int data ;


    public Password(int data){

        this.data = data;
        System.out.println("Password Bean is created !");
    }

    public String display(){

        return "Hello data is : " ;
    }
}
