package tradingservices.trading;

import java.util.List;

public class Selections {

    private List<Integer> nums;
    private String name;
    private String fractionalPrice;
//    private String baseFractionalPrice  = null;
    private int ticks;
    private double volatility;

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFractionalPrice() {
        return fractionalPrice;
    }

    public void setFractionalPrice(String fractionalPrice) {
        this.fractionalPrice = fractionalPrice;
    }

//    public String getBaseFractionalPrice() {
//        return baseFractionalPrice;
//    }
//
//    public void setBaseFractionalPrice(String baseFractionalPrice) {
//        this.baseFractionalPrice = baseFractionalPrice;
//    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }
}
