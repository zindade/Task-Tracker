package main.java.com.taskcli.dao;

public class FactoryDao {
    public static UserDao createUserDao(){
        return new UserDaoImpl() ;
    }
}
