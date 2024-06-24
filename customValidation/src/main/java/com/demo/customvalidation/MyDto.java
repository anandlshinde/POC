/**
 * Author: Sameera De Silva
 * User:anand
 * Date:21-06-2024
 * Time:07:08 pm
 */

package com.demo.customvalidation;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MyDto {

    @CustomField(message = "Name must valid")
    private String name;


    private List<DummyChild> mobileNumber;


    @CustomField(message = "actionType must valid")
    private ActionType actionType;

    // Other fields and their getters/setters

    // Getters and Setters
}

