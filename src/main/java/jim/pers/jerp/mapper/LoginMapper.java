package jim.pers.jerp.mapper;

import jim.pers.jerp.model.Token;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    public int setToken(@Param("uuid") int uuid,@Param("timestamp") long timestamp,@Param("token") String token);

    public Token getToken(@Param("uuid") int uuid);
}
