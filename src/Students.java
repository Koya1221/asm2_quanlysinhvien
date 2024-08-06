public class Students {
    private String code;
    private String name;
    private float grade;

    public Students(String code, String name, float grade) {
        this.code = code;
        this.name = name;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
