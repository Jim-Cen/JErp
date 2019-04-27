package jim.pers.jerp.mapper;

import jim.pers.jerp.model.Goods;
import jim.pers.jerp.model.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    public Goods getGoodsByUuid(int uuid);
    public List<Unit> getUnits();
    public int setGoods(@Param("goods") Goods goods);
}
