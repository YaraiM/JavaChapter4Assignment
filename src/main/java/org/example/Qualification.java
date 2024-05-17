package org.example;

/**
 * 資格クラス（資格コード, 資格名, 資格ポイント）
 */
public class Qualification {
    private int code;
    private String qualification;
    private int point;

    public Qualification(int code, String qualification, int point) {
        this.code = code;
        this.qualification = qualification;
        this.point = point;
    }

    public int getCode() {
        return code;
    }

    public String getQualification() {
        return qualification;
    }

    public int getPoint() {
        return point;
    }
}
