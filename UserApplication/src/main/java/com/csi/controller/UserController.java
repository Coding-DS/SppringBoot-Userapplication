package com.csi.controller;

import com.csi.execption.OverAllExecption;
import com.csi.execption.RecordNotFound;
import com.csi.model.User;
import com.csi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userServiceImplement;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return  ResponseEntity.ok("Welcome To USER Application");
    }

    @PostMapping("/signup")
    public String signUp(@Valid @RequestBody User user)  {
        userServiceImplement.signUp(user);
        return "Data Inserted Successfully.....";
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<User>> getAllData(){
        return ResponseEntity.ok(userServiceImplement.getAllData());
    }

    @GetMapping("/signin/{userEmail}/{userPassword}")
    public boolean signIn(@Valid @PathVariable String userEmail , @PathVariable String userPassword){
        return userServiceImplement.signIn(userEmail, userPassword);
    }

    @GetMapping("/getdatabyid/{userId}")
    public Optional<User> getDataById( @PathVariable long userId){
        return userServiceImplement.getDataById(userId);
    }

    @GetMapping("/getdatabyemail/{userEmail}")
    public ResponseEntity<User> getDataByEmail(  @PathVariable String userEmail){

        return ResponseEntity.ok(userServiceImplement.getDataByEmail(userEmail));
    }

    @GetMapping("/getdatabyfirstname/{userFirstName}")
    public ResponseEntity<List<User>> getDataByFirstName( @PathVariable String userFirstName){

        return ResponseEntity.ok(userServiceImplement.getDataByFirstName(userFirstName));
    }

    @GetMapping("/getdatabylastname/{userLastName}")
    public ResponseEntity<List<User>> getDataByLastName( @PathVariable  String userLastName){

        return ResponseEntity.ok(userServiceImplement.getDataByLastName(userLastName));
    }

    @GetMapping("/getdatabycontact/{userContact}")
    public ResponseEntity<User> getDataByContact( @PathVariable long userContact){

        return ResponseEntity.ok(userServiceImplement.getDataByContact(userContact));
    }

    @GetMapping("/filterdatabyincome/{userIncome}")
    public ResponseEntity<List<User>> filterDataByIncome( @PathVariable  double userIncome){

        return ResponseEntity.ok(userServiceImplement.filterDataByIncome(userIncome));
    }

    @GetMapping("/sortdatabyfirstname")
    public ResponseEntity<List<User>> sortDataByFirstName(){

        return ResponseEntity.ok(userServiceImplement.sortDataByFirstName());
    }

    @GetMapping("/sortdatabylastname")
    public ResponseEntity<List<User>> sortDataByLastName(){

        return ResponseEntity.ok(userServiceImplement.sortDataByLastName());
    }

    @GetMapping("/sortdatabyage")
    public ResponseEntity<List<User>> sortDataByAge(){

        return ResponseEntity.ok(userServiceImplement.sortDataByAge());
    }

    @GetMapping("/sortdatabydob")
    public ResponseEntity<List<User>> sortDataByDOB(){

        return ResponseEntity.ok(userServiceImplement.sortDataByDOB());
    }

    @GetMapping("/sortdatabyemail")
    public ResponseEntity<List<User>> sortDataByEmail(){
        return ResponseEntity.ok(userServiceImplement.sortDataByEmail());
    }

    @GetMapping("/sortdatabyincome")
    public ResponseEntity<List<User>> sortDataByIncome(){
        return ResponseEntity.ok(userServiceImplement.sortDataByIncome());
    }

    @DeleteMapping("/deletedatabyid/{userId}")
    public String deleteById( @PathVariable long userId){
        userServiceImplement.deleteById(userId);
        return "Data Deleted Succesfully of : "+userId;
    }


    @DeleteMapping("/deletealluser")
    public String deleteAll(){
        userServiceImplement.deleteAll();
        return
                "All Record Deleted ... !";
    }

    @PutMapping("/upadteuser/{userId}")
    public ResponseEntity<User> updateUser( @Valid @PathVariable long userId ,@Valid @RequestBody User user) throws RecordNotFound {
        User updatedData = userServiceImplement.getDataById(userId).orElseThrow(() -> new RecordNotFound("User Data Is not Found In USER Application"));

        updatedData.setUserContact(user.getUserContact());
        updatedData.setUserAge(user.getUserAge());
        updatedData.setUserEmail(user.getUserEmail());
        updatedData.setUserFirstName(user.getUserFirstName());
        updatedData.setUserDOB(user.getUserDOB());
        updatedData.setUserPassword(user.getUserPassword());
        updatedData.setUserIncome(user.getUserIncome());
        updatedData.setUserLastName(user.getUserLastName());

        return ResponseEntity.ok( userServiceImplement.updateUser( updatedData));

    }



}
