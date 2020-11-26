package com.offcn.controller;

import com.offcn.AutoWired;
import com.offcn.service.UserService;

public class UserController {



    @AutoWired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
