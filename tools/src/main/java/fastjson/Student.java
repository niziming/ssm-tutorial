package fastjson;

public class Student {
    int age;
    String nmae;

    public Student(int age, String nmae) {
        this.age = age;
        this.nmae = nmae;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNmae() {
        return nmae;
    }

    public void setNmae(String nmae) {
        this.nmae = nmae;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", nmae='" + nmae + '\'' +
                '}';
    }
}
