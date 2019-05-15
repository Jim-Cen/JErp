package jim.pers.jerp.model;

import java.util.Date;
import java.util.List;

public class PurchOrder {
    private int uuid;
    private String OrderNo;
    private int creator;
    private Date createTime;
    private int checker;
    private Date checkTime;
    private int completer;

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    private Date endTime;
    private List<PurchOrderDetail> purchOrderDetailList;

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getChecker() {
        return checker;
    }

    public void setChecker(int checker) {
        this.checker = checker;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public int getCompleter() {
        return completer;
    }

    public void setCompleter(int completer) {
        this.completer = completer;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public List<PurchOrderDetail> getPurchOrderDetailList() {
        return purchOrderDetailList;
    }

    public void setPurchOrderDetailList(List<PurchOrderDetail> purchOrderDetailList) {
        this.purchOrderDetailList = purchOrderDetailList;
    }
}
