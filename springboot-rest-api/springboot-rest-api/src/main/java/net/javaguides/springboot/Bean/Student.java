package net.javaguides.springboot.Bean;

public class Student {
    private int id;
    private String firstName;
    private String Lastname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public Student(int id, String firstName, String lastname) {
        this.id = id;
        this.firstName = firstName;
        Lastname = lastname;
    }
}
