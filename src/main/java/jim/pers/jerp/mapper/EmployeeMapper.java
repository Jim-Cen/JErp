package jim.pers.jerp.mapper;

import jim.pers.jerp.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {
    public Employee getEmployeeByUuid(@Param("uuid") int uuid);
}
