package week_7.p2;

public class Course implements Comparable<Course> {

    private String name;
    private int credit;
    private char grade;

    /**
     * @param name      과목명
     * @param credit    학점 수
     * @param grade     성적
     */
    public Course(String name, int credit, char grade) {
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Course other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("\t%-20s", name));
        sb.append(String.format("\t%8d", credit));
        sb.append(String.format("\t%7s", grade));
        sb.append("\n");

        return sb.toString();
    }
}
