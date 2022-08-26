package com.csi.dao;


import com.csi.model.User;
import com.csi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDaoImplement implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public User signUp(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean signIn(String userEmail, String userPassword) {
        boolean flag = false;

        for (User u: userRepository.findAll() ) {
            if (u.getUserEmail().equalsIgnoreCase(userEmail) && u.getUserPassword().equals(userPassword)){
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public List<User> getAllData() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getDataById(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User getDataByEmail(String userEmail) {
        return (User) userRepository.findAll().stream().filter(u -> u.getUserEmail().equalsIgnoreCase(userEmail));
    }

    @Override
    public List<User> getDataByFirstName(String userFirstName) {
        return userRepository.findAll().stream().filter(u -> u.getUserFirstName().equalsIgnoreCase(userFirstName)).collect(Collectors.toList());
    }

    @Override
    public List<User> getDataByLastName(String userLastName) {
        return userRepository.findAll().stream().filter(u -> u.getUserFirstName().equalsIgnoreCase(userLastName)).collect(Collectors.toList());
    }

    @Override
    public User getDataByContact(long userContact) {

        User userC = null;
        for (User u : userRepository.findAll()) {
            if (u.getUserContact() == userContact){
                userC = u ;
            }
        }
        return userC;

        // --------- stream is not apllicable beacuse it not working with collection class or interface -----------
       // return  userRepository.findAll().stream().filter(u -> u.getUserContact() == userContact).collect(Collectors.toList());
    }

    @Override
    public List<User> filterDataByIncome(double userIncome) {
        return userRepository.findAll().stream().filter(u -> u.getUserIncome() >= userIncome).collect(Collectors.toList());
    }

    @Override
    public List<User> sortDataByFirstName() {
        return userRepository.findAll().stream().sorted((u1,u2) -> u1.getUserFirstName().toLowerCase().compareTo(u2.getUserFirstName().toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<User> sortDataByLastName() {
        return userRepository.findAll().stream().sorted((u1,u2) -> u1.getUserLastName().toLowerCase().compareTo(u2.getUserLastName().toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<User> sortDataByAge() {
        return userRepository.findAll().stream().sorted(Comparator.comparingInt(User :: getUserAge)).collect(Collectors.toList());
    }

    @Override
    public List<User> sortDataByDOB() {
        return userRepository.findAll().stream().sorted((u1,u2) -> u1.getUserDOB().compareTo(u2.getUserDOB())).collect(Collectors.toList());
    }

    @Override
    public List<User> sortDataByEmail() {
        return userRepository.findAll().stream().sorted((u1,u2) -> u1.getUserEmail().toLowerCase().compareTo(u2.getUserEmail().toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<User> sortDataByIncome() {
        return userRepository.findAll().stream().sorted(Comparator.comparing(User::getUserIncome)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void deleteAll() {
         userRepository.deleteAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
