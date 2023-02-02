package at.pairofdice;

public class Student {
    private String name;
    private int studNumber;

    public Student(String name, int studNumber) {
        this.name = name;
        this.studNumber = studNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
