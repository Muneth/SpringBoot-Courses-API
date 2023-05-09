package com.coursesapp.coursesappadmin.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class Course {

    private Long courseId;
    private String courseName;
    private String courseDuration;
    private String courseDescription;
}
