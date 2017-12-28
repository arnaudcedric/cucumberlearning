package tradingservices.trading;

import java.util.List;

public class Runners {

    private int runnerNum;
    private String name;
    private String statusCode;
    private String statusDescription;
    private List<String> priceHistory;

    public int getRunnerNum() {
        return runnerNum;
    }

    public void setRunnerNum(int runnerNum) {
        this.runnerNum = runnerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public List<String> getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(List<String> priceHistory) {
        this.priceHistory = priceHistory;
    }
}
