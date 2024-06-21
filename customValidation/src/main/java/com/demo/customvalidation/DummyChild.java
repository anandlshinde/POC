/**
 * Author: Sameera De Silva
 * User:anand
 * Date:21-06-2024
 * Time:07:14 pm
 */

package com.demo.customvalidation;

import lombok.Data;

import java.util.List;

@Data
public class DummyChild {
    @CustomField(message = "Mobile number must valid")
    private String mobileNumber;

    private NestedChild child;;

    private List<ListObject> listObjectList;




}
