package DAO;


/**
 * Created by Nikita Philippov on 03.01.17.
 */
public class Factory {

    private static PersonDAO personDAO = null;
    private static Factory instance;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public PersonDAO getPersonDAO(){
        if (personDAO == null){
            personDAO = new PersonDAO();
        }
        return personDAO;
    }

}
