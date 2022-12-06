import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private long id;
    private double averageGrade;

    public Student(String name, String surname, long id, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Student o) {
        if (this.averageGrade != o.getAverageGrade()) {
            if (this.averageGrade < o.getAverageGrade()) {
                return -1;
            } else {
                return 1;
            }
        }

        if (!this.surname.equals(o.getSurname())) {
            return this.surname.compareTo(o.getSurname());
        }

        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", averageGrade=" + averageGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        return id == ((Student) o).id && Double.compare(((Student) o).averageGrade, averageGrade) == 0 && name.equals(((Student) o).name) && surname.equals(((Student) o).surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id, averageGrade);
    }
}
