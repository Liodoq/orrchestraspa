
package com.gabriel.emplms.model;


import lombok.Data;


@Data

public class User {
  
    private int userId;

    private String userName;
    private String userEmail;
    private String userPassword;
    private String role; 
}