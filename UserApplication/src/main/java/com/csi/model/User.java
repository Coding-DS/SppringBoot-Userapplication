package com.csi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import javax.websocket.OnMessage;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long userId;

    @NotEmpty(message = "FirstName Not be Empty ... ")
    private String userFirstName;

    @NotEmpty(message = "LastName Not be Empty ... ")
    private String userLastName;

    @NotNull(message = "This field not be Null ...")
    @Column(unique = true)
    private long userContact;

    @JsonFormat( pattern = "dd-mm-yyyy")
    private Date userDOB;

    @NotNull(message = "This field not be Null ...")
    private int userAge;

    @NotNull(message = "This field not be Null ...")
    private double userIncome;

    @Email(message = "Please Enter The Email With valid Format ... ")
    @Column(unique = true)
    private String userEmail;

    @NotEmpty
    @Size( min = 4 , max = 8 , message =  "Password must be Contain 4 char's to 8 char's")
    private String userPassword;

}
