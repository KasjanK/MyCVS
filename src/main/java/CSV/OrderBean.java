package CSV;

import java.math.BigDecimal;

public class OrderBean {

    private int orderId;
    private String orderDate;
    private String region;
    private String rep1;
    private String rep2;
    private String item;
    private BigDecimal units;
    private BigDecimal unitCost;
    private BigDecimal total;

    public OrderBean(int orderId, String orderDate, String region, String rep1, String rep2, String item, BigDecimal units, BigDecimal unitCost, BigDecimal total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.region = region;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.item = item;
        this.units = units;
        this.unitCost = unitCost;
        this.total = total;
    }


    public int getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getRegion() {
        return region;
    }

    public String getRep1() {
        return rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public String getItem() {
        return item;
    }

    public BigDecimal getUnits() {
        return units;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public BigDecimal getTotal() {
        return total;
    }
}