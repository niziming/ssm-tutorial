package cn.zm.domain;

import lombok.Data;

import java.util.List;

@Data //GET,SET,ToString，有参，无参构造
public class Teacher {
    private int id;
    private String name;
    //一对多
    private List<Student> students;
}
