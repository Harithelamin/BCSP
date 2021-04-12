package com.bcsp.project.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    public static final String PARAM_BASE_URL = "baseURL";

    //get base URL
    public static String getBaseURL(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}

