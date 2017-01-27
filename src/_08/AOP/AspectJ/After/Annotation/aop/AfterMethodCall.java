package _08.AOP.AspectJ.After.Annotation.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterMethodCall {

	//sayHi metodundan once firstDuty metodu �al��acak
	@After("execution(* _08.AOP.AspectJ.After.Annotation.IEmployeeService.sayHi(..))")
	public void lastDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan SONRA �al���an lastDuty metodu. ");
	}
	
	
}
