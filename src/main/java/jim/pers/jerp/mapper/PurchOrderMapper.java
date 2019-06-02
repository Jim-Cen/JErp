package jim.pers.jerp.mapper;

import jim.pers.jerp.model.PurchOrder;
import jim.pers.jerp.model.PurchOrderDetail;

import java.util.Date;
import java.util.List;

public interface PurchOrderMapper {
    public PurchOrder getPurchOrderByUuid(int uuid);
    public List<PurchOrder> getAllPurchOrders();
    public int addPurchOrder(PurchOrder purchOrder);
    public int updatePurchOrder(PurchOrder purchOrder);
    public int addPurOrderDetail(PurchOrderDetail purchOrderDetail);
    public  PurchOrderDetail getPurOrderDetailByUuid(int uuid);
}
