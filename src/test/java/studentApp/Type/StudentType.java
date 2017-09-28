package studentApp.Type;

import java.util.List;

public class StudentType {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<CourseType> courseType;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public List<CourseType> getCourseType() {
        return courseType;
    }

    public void setCourseType(List<CourseType> courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "StudentType{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", programme='" + programme + '\'' +
                ", courseType=" + courseType +
                '}';
    }
}
