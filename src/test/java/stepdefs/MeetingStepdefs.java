package stepdefs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MeetingStepdefs {

    Map<Integer, List<String>> courses= new HashMap<>();
    Map<Integer, List<String>> events = new HashMap<>();
    Map<Integer, List<String>> classes = new HashMap<>();

    @Given("^I get meetings$")
    public void iGetMeetings(List<Meeting> meetings) {

        for (Meeting meeting: meetings){
            meeting.setCourse(this.courses.get(meeting.getCourseId()));
            meeting.setClasse(this.classes.get(meeting.getClasseId()));
            meeting.setEvent(this.events.get(meeting.getEventId()));
            System.out.println(meeting.getId()+" "+meeting.getName()+" \n"+meeting.getCourse()+" \n"+ meeting.getClasse()+" \n"+meeting.getEvent());
        }
        
    }

    @Given("^I have courses with id (\\d+)$")
    public void iHaveCoursesWithId(int id,List<String> courses)  {
        this.courses.put(id, courses);
    }

    @And("^User is in class with id (\\d+)$")
    public void userIsInClassWithId(int id, List<String> classes) {
        this.classes.put(id,classes);
    }

    @And("^meeting has events with id (\\d+)$")
    public void meetingHasEventsWithId(int id,List<String> events) {
        this.events.put(id,events);
    }

    class Meeting {

        private int id;
        private String name;
        private List<String> course;
        private List<String> classe;
        private List<String> event;
        private int courseId;
        private int classeId;
        private int eventId;

        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public List<String> getCourse() {
            return course;
        }
        public List<String> getClasse() {
            return classe;
        }

        public int getCourseId() {
            return courseId;
        }
        public void setCourse(List<String> course) {
            this.course = course;
        }
        public int getClasseId() {
            return classeId;
        }
        public void setClasse(List<String> classe) {
            this.classe = classe;
        }

        public List<String> getEvent() {
            return event;
        }

        public void setEvent(List<String> event) {
            this.event = event;
        }

        public int getEventId() {
            return eventId;
        }
    }
}
