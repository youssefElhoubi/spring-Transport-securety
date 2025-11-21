package com.transportsecure.entity;


import com.transportsecure.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("package")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    @Id
    private String id;
    private Type type;
    private Double weight;
    private String destination_address;
    private String handling_instructions;
    private Double temperature_min;
    private Double temperature_max;
    private String carrierId;

}
