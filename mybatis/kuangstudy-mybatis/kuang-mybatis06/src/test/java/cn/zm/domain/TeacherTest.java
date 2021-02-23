package cn.zm.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherTest {

    @Test
    public void testToString() {
        //测试lombok
        Teacher teacher = new Teacher();
        System.out.println(teacher);
    }
}