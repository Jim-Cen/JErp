package jim.pers.jerp.model;

public class PurchOrderDetail {
    private int uuid;
    private int orderUuid;
    private int goodsUuid;
    private String goodsName;
    private int supplierUuid;
    private String supplierName;
    private double inPrice;
    private int num;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(int orderUuid) {
        this.orderUuid = orderUuid;
    }

    public int getGoodsUuid() {
        return goodsUuid;
    }

    public void setGoodsUuid(int goodsUuid) {
        this.goodsUuid = goodsUuid;
    }

    public double getInPrice() {
        return inPrice;
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public int getSupplierUuid() {
        return supplierUuid;
    }

    public void setSupplierUuid(int supplierUuid) {
        this.supplierUuid = supplierUuid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
