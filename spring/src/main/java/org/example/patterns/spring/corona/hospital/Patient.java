package org.example.patterns.spring.corona.hospital;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Patient {

    private String name;
    private int age;
    private String method;

}

/*
{
"name" : "Bob",
"age" : 55,
"method": "traditional"
}
 */
