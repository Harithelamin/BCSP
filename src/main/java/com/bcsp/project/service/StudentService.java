package com.bcsp.project.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentService {

       void save(String name, Integer age, MultipartFile photo) throws IOException;
}