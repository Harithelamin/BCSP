package com.bcsp.project.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
    @Override
    public void validate(Object uploadedFile, Errors errors) {
        MultipartFile file = (MultipartFile) uploadedFile;

        if(file.isEmpty() || file.getSize()==0)
            errors.rejectValue("file", "Please select a file");
        if(!(file.getContentType().toLowerCase().equals("image/jpg")
                || file.getContentType().toLowerCase().equals("image/jpeg")
                || file.getContentType().toLowerCase().equals("image/png"))){
            errors.rejectValue("file", "jpg/png file types are only supported");
        }

    }
}
