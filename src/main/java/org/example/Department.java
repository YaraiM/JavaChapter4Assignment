package org.example;

// 部署クラス（部署コード、部署名）
public class Department {
    private int code;
    private String department;

    public Department(int code, String department) {
        this.code = code;
        this.department = department;
    }

    public int getCode() {
        return code;
    }

    public String getDepartment() {
        return department;
    }
}
