package com.coursesapp.coursesappadmin.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class User {

    private Long userId;
    private String email;
    private String password;
}
