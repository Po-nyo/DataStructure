package week_7.p2;

public class Student implements Comparable<Student> {

    private int number;
    private String name;
    private SortedLinkedList<Course> courseList;

    /**
     * @param number        학번
     * @param name          이름
     * @param courseList    수강 과목
     */
    public Student(int number, String name, SortedLinkedList<Course> courseList) {
        this.number = number;
        this.name = name;
        this.courseList = courseList;
    }

    /**
     * @return  총 수강 학점
     */
    public int getTotalCredits() {
        int sum = 0;

        courseList.reset();
        while(courseList.hasNext())
            sum += courseList.next().getCredit();

        return sum;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.number + "\t");
        sb.append(this.name + "\t\t");
        sb.append("total credits: " + getTotalCredits() + "\n");
        sb.append(this.courseList + "\n");

        return sb.toString();
    }
}
