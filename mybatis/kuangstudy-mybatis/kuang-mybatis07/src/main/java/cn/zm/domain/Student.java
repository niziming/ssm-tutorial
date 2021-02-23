package cn.zm.domain;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    //多对一
    private Integer tid;
}
