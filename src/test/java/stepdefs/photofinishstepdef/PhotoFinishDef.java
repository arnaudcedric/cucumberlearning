package stepdefs.photofinishstepdef;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.exec.util.StringUtils;
import stepdefs.DateHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class PhotoFinishDef {

    File source,dest;

    @Given("^Event is been resulted from the editor$")
    public void eventIsBeenResultedFromTheEditor() throws IOException {
        System.out.println("Event is resulted");
    }

    @And("^User send photo in the input folder with the correct \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSendPhotoInTheInputFolderWithTheCorrectAnd(String countryCode, String meetName) throws IOException {
        source = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Mhd-mhd.jpg");
        dest = new File("Z:\\input\\DG\\"+countryCode+"\\"+meetName+"\\Mhd-mhd.jpg");

        Files.copy(source.toPath(), dest.toPath());
    }

    @Then("^The output folder should have the resulted image with the correct \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theOutputFolderShouldHaveTheResultedImage(String countryCode, String meetName,String date,String eventNumber) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file = new File("Z:\\output\\DG_"+countryCode+"_"+meetName+"_"+date+"_"+eventNumber+".jpg");
        if(file.delete()){
            System.out.println("/Users/pankaj/file.txt File deleted");
        }else System.out.println("File /Users/pankaj/file.txt doesn't exists");

    }


    @And("^the date is$")
    public void theDateIs(List<TodayDate> todayDates) {
        DateHelper dateHelper = new DateHelper();

        for (TodayDate todayDate: todayDates ) {
            String s = dateHelper.parseTimeModifyingStringToDateString(todayDate.getTime(), "HH:mm:00");

            todayDate.setTime(s);
            System.out.println(todayDate.getTime());
        }
    }

    class TodayDate{

        private String time;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

    }
}


