package jim.pers.jerp.mapper;

import jim.pers.jerp.model.Goods;
import jim.pers.jerp.model.Unit;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {
    public List<Goods> getAllGoods();
    public Goods getGoodsByUuid(int uuid);
    public List<Unit> getUnits();

    @MapKey("uuid")
    public Map<Integer,Unit> getUnitsMap();

    public int addGoods(Goods goods);
    public int deleteGoods(int uuid);
    public int updateGoods(Goods goods);
}
