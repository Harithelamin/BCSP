package com.bcsp.project.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by lenovo on 9/4/2018.
 */
public class QuickPasswordEncodingGenerator {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String password = "abc125";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }

    ///* Populate one Admin User which will further create other users for the application using GUI */
   // INSERT INTO APP_USER(sso_id, password, first_name, last_name, email)
   // VALUES ('sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Sam','Smith','samy@xyz.com');


    /* Populate JOIN Table */
    //INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
    //SELECT user.id, profile.id FROM app_user user, user_profile profile
    //where user.sso_id='sam' and profile.type='ADMIN';
}