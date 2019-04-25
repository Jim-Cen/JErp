package jim.pers.jerp.mapper;

import jim.pers.jerp.model.GoodsType;

public interface GoodsTypeMapper {
    public GoodsType getGoodsTypeByUuid(int uuid);
    public int setGoodsType(String name,int supplierUuid);
}
