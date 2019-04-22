package jim.pers.jerp.mapper;

import jim.pers.jerp.model.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupplierMapper {
    public Supplier getSupplierByUuid(int uuid);
    public int setSupplierByUuid(String name,String address,String contact,String tel);
}
