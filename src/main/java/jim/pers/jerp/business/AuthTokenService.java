package jim.pers.jerp.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {
//	@Autowired
//	UserMapper userMapper;
//    public void  authTokenCheck(String userName,String timestamp,String signture) throws Exception{
//    	if (userName == null || timestamp == null || signture == null) {
//    		throw new HttpException(412,"Token不存在");
//    	}
//    	String token = userMapper.getTokenByName(userName);
//    	if (token == null || "".equals(token)) {
//    		throw new HttpException(412,"Token不存在");
//    	}
//    	String assertSignture = MD5.encode(token + "WIN"+ timestamp);
//
//    	if (!assertSignture.equals(signture)) {
//    		throw new HttpException(412,"Token验证失败");
//    	}
//    }
        
}
