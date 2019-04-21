package jim.pers.jerp.business;

import jim.pers.jerp.mapper.EmployeeMapper;
import jim.pers.jerp.model.Employee;
import jim.pers.jerp.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LoginService {
    @Autowired
    EmployeeMapper employeeMapper;
    public String checkPassword(String id,String password){
        int uuid;
        try {
            uuid = Integer.parseInt(id);
        }
        catch (Exception ex){
            return  null;
        }
        Employee employee = employeeMapper.getEmployeeByUuid(uuid);
        if (employee == null ) {
			return null;
		}
        if(employee.getPwd().equals(password)){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String token = MD5.encode(timestamp.toString()+"JIM"+id);
            return  token;
        }
        return  null;
    }
}
