package com.csi.dao;

import com.csi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    public User signUp(User user);

    public boolean signIn( String userEmail , String userPassword);

    public List<User> getAllData();

    public Optional<User> getDataById(long userId);

    public User getDataByEmail(String userEmail);

    public List<User> getDataByFirstName(String userFirstName);

    public List<User> getDataByLastName( String userLastName);

    public User getDataByContact(long userContact);

    public List<User> filterDataByIncome( double userIncome);

    public List<User> sortDataByFirstName();

    public List<User> sortDataByLastName();

    public List<User> sortDataByAge();

    public List<User> sortDataByDOB();

    public List<User> sortDataByEmail();

    public List<User> sortDataByIncome();

    public void deleteById(long userId);

    public void deleteAll();

    public User updateUser(User user);
}
