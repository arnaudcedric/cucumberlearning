package learningjson;

import java.util.List;

/**
 * Created by acedric on 19/06/2017.
 */
public class Eventservices {

    private int id;
    private String statusCode;
    private String category;
    private String       currentPriceType;
    private boolean        isHandicap;
    private boolean       containsPrices;
    private String       startTime;
    private String        description;
    private String        meetingGroup;
    private String        meetingCode;
    private String        progressCode;
    private String        source;
    private List<String> runners;
    private List<Object> markets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrentPriceType() {
        return currentPriceType;
    }

    public void setCurrentPriceType(String currentPriceType) {
        this.currentPriceType = currentPriceType;
    }

    public boolean isHandicap() {
        return isHandicap;
    }

    public void setHandicap(boolean handicap) {
        isHandicap = handicap;
    }

    public boolean isContainsPrices() {
        return containsPrices;
    }

    public void setContainsPrices(boolean containsPrices) {
        this.containsPrices = containsPrices;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeetingGroup() {
        return meetingGroup;
    }

    public void setMeetingGroup(String meetingGroup) {
        this.meetingGroup = meetingGroup;
    }

    public String getMeetingCode() {
        return meetingCode;
    }

    public void setMeetingCode(String meetingCode) {
        this.meetingCode = meetingCode;
    }

    public String getProgressCode() {
        return progressCode;
    }

    public void setProgressCode(String progressCode) {
        this.progressCode = progressCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getRunners() {
        return runners;
    }

    public void setRunners(List<String> runners) {
        this.runners = runners;
    }

    public List<Object> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Object> markets) {
        this.markets = markets;
    }

    @Override
    public String toString() {
        return "Eventservices{" +
                "id=" + id +
                ", statusCode='" + statusCode + '\'' +
                ", category='" + category + '\'' +
                ", currentPriceType='" + currentPriceType + '\'' +
                ", isHandicap=" + isHandicap +
                ", containsPrices=" + containsPrices +
                ", startTime='" + startTime + '\'' +
                ", description='" + description + '\'' +
                ", meetingGroup='" + meetingGroup + '\'' +
                ", meetingCode='" + meetingCode + '\'' +
                ", progressCode='" + progressCode + '\'' +
                ", source='" + source + '\'' +
                ", runners=" + runners +
                ", markets=" + markets +
                '}';
    }
}
