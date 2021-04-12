package com.bcsp.project.util;

import com.bcsp.project.model.Dimensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by lenovo on 8/6/2018.
 */
@Component
public class ToolsValidator implements Validator {
    @Autowired
    @Qualifier("emailValidator")
    EmailValidator emailValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return Dimensions.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Dimensions dimensions = (Dimensions) target;

        if(dimensions.getName()!=null){
            if (dimensions.getName().isEmpty() ) {
                errors.rejectValue("name", "NotEmpty.Dimension.name");
            }
        }
        if(!emailValidator.valid(dimensions.getEmail())){
            errors.rejectValue("email", "Dimension.regestration.email");
        }

    }
}
