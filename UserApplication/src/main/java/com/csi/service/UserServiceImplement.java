package com.csi.service;


import com.csi.dao.UserDao;
import com.csi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    UserDao userDaoImplement;

    @Override
    public User signUp(User user) {
        return userDaoImplement.signUp(user);
    }

    @Override
    public boolean signIn(String userEmail, String userPassword) {
        return userDaoImplement.signIn(userEmail, userPassword);
    }

    @Override
    public List<User> getAllData() {
        return userDaoImplement.getAllData();
    }

    @Override
    public Optional<User> getDataById(long userId) {
        return userDaoImplement.getDataById(userId);
    }

    @Override
    public User getDataByEmail(String userEmail) {
        return userDaoImplement.getDataByEmail(userEmail);
    }

    @Override
    public List<User> getDataByFirstName(String userFirstName) {
        return userDaoImplement.getDataByFirstName(userFirstName);
    }

    @Override
    public List<User> getDataByLastName(String userLastName) {
        return userDaoImplement.getDataByLastName(userLastName);
    }

    @Override
    public User getDataByContact(long userContact) {
        return userDaoImplement.getDataByContact(userContact);
    }

    @Override
    public List<User> filterDataByIncome(double userIncome) {
        return userDaoImplement.filterDataByIncome(userIncome);
    }

    @Override
    public List<User> sortDataByFirstName() {
        return userDaoImplement.sortDataByFirstName();
    }

    @Override
    public List<User> sortDataByLastName() {
        return userDaoImplement.sortDataByLastName();
    }

    @Override
    public List<User> sortDataByAge() {
        return userDaoImplement.sortDataByAge();
    }

    @Override
    public List<User> sortDataByDOB() {
        return userDaoImplement.sortDataByDOB();
    }

    @Override
    public List<User> sortDataByEmail() {
        return userDaoImplement.sortDataByEmail();
    }

    @Override
    public List<User> sortDataByIncome() {
        return userDaoImplement.sortDataByIncome();
    }

    @Override
    public void deleteById(long userId) {
         userDaoImplement.deleteById(userId);
    }

    @Override
    public void deleteAll() {
         userDaoImplement.deleteAll();
    }

    @Override
    public User updateUser(User user) {
        return userDaoImplement.updateUser(user);
    }
}
