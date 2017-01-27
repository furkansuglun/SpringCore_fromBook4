package _10.AOP.AspectJ.AfterThrowing.Annotation.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterMethodCall {

	//sayHi metodundan once firstDuty metodu çalýþacak
	@After("execution(* _10.AOP.AspectJ.AfterThrowing.Annotation.IEmployeeService.sayHi(..))")
	public void lastDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan SONRA çalþýþan lastDuty metodu. ");
	}
	
	
}
