/**
 * Author: Sameera De Silva
 * User:anand
 * Date:21-06-2024
 * Time:07:45 pm
 */

package com.demo.customvalidation;

import lombok.Data;

@Data
public class ListObject {

    @CustomField(message = "JobId must valid")
    private Integer jobId;

}
