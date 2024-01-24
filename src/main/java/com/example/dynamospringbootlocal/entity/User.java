package com.example.dynamospringbootlocal.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "User")
public class User {

  @DynamoDBHashKey(attributeName = "id")
  private String id;

  @DynamoDBAttribute
  private String firstName;

  @DynamoDBAttribute
  private String lastName;
}