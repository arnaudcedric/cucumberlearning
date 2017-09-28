package runnerclass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
//        tags = {"@LoginTest,@InputPrice"},
        format = {"json:target/cucumber.json",
                "html:target/site/cucumber-pretty"},
        glue = {"stepdefs"},
        features = {
//                "src/test/java/features/StudentApp/getStudents.feature",
//                "src/test/java/features/StudentApp/getStudentWithCourse.feature",
//                "src/test/java/features/StudentApp/postNewStudent.feature",
        },
//      monochrome below display the console Output in much readable way
        monochrome = true
//        strict = true
//      dryRun below  checks if all the steps have the step definitions
//        ,dryRun = true
)
@RunWith(Cucumber.class)
public class StudentTest {
}
