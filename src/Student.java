public class Student {
    public final Integer id;
    public final String name;
    public final String surname;
    private Integer assignmentScore;
    public Boolean isFlagged = false;

    public Student(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String toString() {
        return String.format("№%d %s %s", id, name, surname);
    }

    public void setAssignmentScore(Integer score) {
        assignmentScore = score;
    }

    public Integer getAssignmentScore() {
        return assignmentScore;
    }
}
