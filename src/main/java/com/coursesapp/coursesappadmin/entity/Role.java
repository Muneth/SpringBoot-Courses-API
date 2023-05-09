package com.coursesapp.coursesappadmin.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class Role {

    private Long roleId;
    private String name;
}
