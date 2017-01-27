package _09.AOP.AspectJ.AfterReturning.Annotation.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterMethodCall {

	//sayHi metodundan once firstDuty metodu çalýþacak
	@After("execution(* _09.AOP.AspectJ.AfterReturning.Annotation.IEmployeeService.sayHi(..))")
	public void lastDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan SONRA çalþýþan lastDuty metodu. ");
	}
	
	
}
