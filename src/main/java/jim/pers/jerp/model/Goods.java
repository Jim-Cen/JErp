package jim.pers.jerp.model;

public class Goods {
    private int uuid;
    private String name;
    private String origin;
    private String producer;
    private int unitUuid;
    private double inPrice;
    private double outPrice;
    private int goodsTypeUuid;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getUnitUuid() {
        return unitUuid;
    }

    public void setUnitUuid(int unitUuid) {
        this.unitUuid = unitUuid;
    }

    public double getInPrice() {
        return inPrice;
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public int getGoodsTypeUuid() {
        return goodsTypeUuid;
    }

    public void setGoodsTypeUuid(int goodsTypeUuid) {
        this.goodsTypeUuid = goodsTypeUuid;
    }
}
