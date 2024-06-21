/**
 * Author: Sameera De Silva
 * User:anand
 * Date:21-06-2024
 * Time:07:22 pm
 */

package com.demo.customvalidation;

import lombok.Data;

@Data
public class NestedChild {

    @CustomField(message = "Bank Name must valid")
    private String bankName;

}
