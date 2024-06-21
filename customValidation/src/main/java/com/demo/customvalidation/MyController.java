/**
 * Author: Sameera De Silva
 * User:anand
 * Date:21-06-2024
 * Time:07:09 pm
 */

package com.demo.customvalidation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Slf4j
public class MyController {

    @Autowired
    private Validator validator;

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody MyDto myDto) {

        log.info(String.format("%s = %s", "myDto",myDto));
        // If validation passes, the request processing continues here
        return ResponseEntity.ok("Data saved successfully");
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitData(@RequestBody MyDto myDto) {
        BindingResult bindingResult = new BeanPropertyBindingResult(myDto, "myDto");

       extracted(myDto, bindingResult);


        if (bindingResult.hasErrors()) {
            // Handle validation errors

            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            log.error(String.format("%s %s ", "errorMessage ",errorMessage));
            return ResponseEntity.badRequest().body(errorMessage);
        }

        // If validation passes, the request processing continues here
        return ResponseEntity.ok("Data submitted successfully");
    }

    private void extracted(MyDto myDto, BindingResult bindingResult) {
        validator.validate(myDto, bindingResult);
        validator.validate(myDto.getChild(), bindingResult);
        myDto.getMobileNumber().forEach(c -> {
            validator.validate(c, bindingResult);
            validator.validate(c.getChild(), bindingResult);
            c.getListObjectList().forEach(ch -> {
                validator.validate(ch, bindingResult);
            });
        });
    }

}

