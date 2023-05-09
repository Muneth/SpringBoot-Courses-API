package com.coursesapp.coursesappadmin.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class Instructor {

    private Long instructorId;
    private String firstName;
    private String lastName;
    private String summary;

}
