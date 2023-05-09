package com.coursesapp.coursesappadmin.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class Student {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String level;
}
