package com.maersk.es.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "maersk-es")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;
    @Field(type = FieldType.Text, name = "firstname")
    private String firstname;
    @Field(type = FieldType.Text, name = "lastname")
    private String lastname;
    @Field(type = FieldType.Integer, name = "age")
    private int age;

}