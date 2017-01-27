package _11.AOP.AspectJ.Around.Annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingMethodCall {

	@AfterThrowing(pointcut="execution(* _11.AOP.AspectJ.Around.Annotation.IEmployeeService.sayHi(..))"  ,
			throwing="exception")
	public void afterThrowingDuty(JoinPoint joinPoint , Throwable exception) {
	
		System.out.println("Aspectj");
		System.out.println(joinPoint.getSignature().getName() + " isimli mettotta HATA meydana geldiðinde çalýþan afterThrowingDuty metodu. ");
		System.out.println(joinPoint.getClass().getName() + " metodunda meydana gelen hata : " + exception);
		
	}
	
}
