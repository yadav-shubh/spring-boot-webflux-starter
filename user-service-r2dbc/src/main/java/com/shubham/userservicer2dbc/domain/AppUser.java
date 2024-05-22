package com.shubham.userservicer2dbc.domain;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Table("app_users")
public class AppUser {

    @Id
    Long id;
    String username;
    String password;
    String name;
    String mobile;
    String role;

}
