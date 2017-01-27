package _07.AOP.AspectJ.Before.Annotation.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeMethodCall {

	//sayHi metodundan once firstDuty metodu çalýþacak
	@Before("execution(* _07.AOP.AspectJ.Before.Annotation.IEmployeeService.sayHi(..))")
	public void firstDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan ÖNCE çalþýþan firstDuty metodu. ");
	}
	
	
}
