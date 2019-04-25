package jim.pers.jerp.aop;

import jim.pers.jerp.mapper.LoginMapper;
import jim.pers.jerp.model.Token;
import jim.pers.jerp.utils.MD5;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Aspect
@Component
public class AuthTokenAOP {
    @Autowired
	LoginMapper loginMapper;

    @Pointcut("@annotation(jim.pers.jerp.annotation.AuthToken)")
    public void authTokenCheck(){
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED,readOnly = true)
    @Before("authTokenCheck()")
    public void before(JoinPoint joinPoint) throws Throwable{
   	try {
			Object[] args= joinPoint.getArgs();
			for (Object arg : args){
				if(arg instanceof ServerHttpRequest){
					ServerHttpRequest request = (ServerHttpRequest) arg;
					HttpHeaders headers = request.getHeaders();
					long timestamp = Long.parseLong(headers.getFirst("timestamp"));
					int clientId = Integer.parseInt(headers.getFirst("clientId"));
					Token token = loginMapper.getToken(clientId);
					String signature = headers.getFirst("signature");

					if(timestamp <= token.getTimestamp()){
						throw  new Exception("请先登录");
					}
					if(!signature.equals(MD5.encode(token.getToken()+"WIN"+timestamp))){
						throw  new Exception("验证失败");
					}
				}
			}
    	}catch (Throwable ex) {
    		//throw new HttpException(412,ex.getMessage());
			throw ex;
    	}

    }
}
