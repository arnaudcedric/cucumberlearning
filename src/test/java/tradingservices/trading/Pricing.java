package tradingservices.trading;

import java.util.List;

public class Pricing {

    private long eventId;
    private String priceType;
    private List<RunnerDetails> runners;
    private List<Markets> markets;
    private boolean unsuspendWinMarket;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public List<RunnerDetails> getRunners() {
        return runners;
    }

    public void setRunners(List<RunnerDetails> runners) {
        this.runners = runners;
    }

    public List<Markets> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Markets> markets) {
        this.markets = markets;
    }

    public boolean isUnsuspendWinMarket() {
        return unsuspendWinMarket;
    }

    public void setUnsuspendWinMarket(boolean unsuspendWinMarket) {
        this.unsuspendWinMarket = unsuspendWinMarket;
    }
}
