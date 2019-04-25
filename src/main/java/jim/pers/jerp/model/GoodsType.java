package jim.pers.jerp.model;

public class GoodsType {
    private int uuid;
    private String name;
    private int supplierUuid;

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

    public int getSupplierUuid() {
        return supplierUuid;
    }

    public void setSupplierUuid(int supplierUuid) {
        this.supplierUuid = supplierUuid;
    }
}