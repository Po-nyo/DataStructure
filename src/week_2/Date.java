package week_2;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean equals(Object obj) {
        Date d = (Date)obj;
        return this.toString().equals(d.toString());
    }

    public int compareTo(Date d) {
        if(this.year < d.year)
            return -1;
        else if(this.year > d.year)
            return 1;

        if(this.month < d.month)
            return -1;
        else if(this.month > d.month)
            return 1;

        if(this.day < d.day)
            return -1;
        else if(this.day > d.day)
            return 1;

        return 0;
    }

    public String toString() {
        return year + "/" + month + "/" + day;
    }
}
