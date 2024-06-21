/**
 * Author: Sameera De Silva
 * User:anand
 * Date:21-06-2024
 * Time:07:08 pm
 */

package com.demo.customvalidation;

import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomFieldValidator implements ConstraintValidator<CustomField, Object> {

    @Override
    public void initialize(CustomField customField) {
        // Initialization code if needed
    }

    @Override
    public boolean isValid(Object field, ConstraintValidatorContext context) {
        // Implement your custom validation logic here
        // For example, check if the field is not null and has a specific pattern

        if (field == null || ObjectUtils.isEmpty(field) ) {
            return false;
        }

        // Add additional custom checks as per your requirement
        // Example: field must start with "A"
        return true;
    }
}

