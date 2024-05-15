package org.example;

public class Employee {
    private int id;
    private String name;
    private int yearsOfExperience;
    private Department department;
    private Qualification qualification;

    public Employee(int id, String name, int yearsOfExperience, Department department, Qualification qualification) {
        this.id = id;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.department = department;
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public Department getDepartment() {
        return department;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public int promotionScore() {
        return (int) this.yearsOfExperience + this.qualification.getPoint();
    }

    public int qualificationPoint() {
        return (int) this.qualification.getPoint();
    }
}
