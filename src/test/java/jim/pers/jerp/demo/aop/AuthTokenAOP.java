package jim.pers.jerp.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


//@Aspect
//@Component
public class AuthTokenAOP {
//
//    @Pointcut("@annotation(jim.pers.jerp.annotation.AuthToken)")
//    public void authTokenCheck(){
//    	System.out.println("Hello world");
//	}
//
//    @Before("authTokenCheck()")
//    public void before(JoinPoint joinPoint) throws Throwable{
////		System.out.println("Hello Jim");
//   	try {
//			Signature signature = joinPoint.getSignature();
//			MethodSignature methodSignature = (MethodSignature) signature;
//			Method method = methodSignature.getMethod();
//			Object[] args= joinPoint.getArgs();
//			Annotation[][] anno = method.getParameterAnnotations();
//			for (int i =0 ;i< anno.length; i++){
//				Annotation a = anno[i][0];
//				if(a instanceof RequestHeader ){
//					System.out.println(args[i]);
//				}
//			}
////			Object[] args= joinPoint.getArgs();
////    	      for ( Object arg : args ) {
////    	      	  System.out.println(arg.getClass().getAnnotations().length);
////    	      	  System.out.println(arg.toString());
////    	    	  if ( arg.getClass() == HttpHeaders.class ) {
//////    	    		  HttpHeaders header = (HttpHeaders)arg;
//////    	    		  String signture = header.getFirst("signture");
//////    	    		  String userName = header.getFirst("clientId");
//////    	    		   String timestamp = header.getFirst("timestamp");
////    	    		  //authTokenService.authTokenCheck(userName, timestamp,signture);
////    	    	  }
////    	      }
//    	      //throw new HttpException(412,"Fail to Auth");
//    	}catch (Throwable ex) {
//    		//throw new HttpException(412,ex.getMessage());
//			throw ex;
//    	}
//
//    }
}
