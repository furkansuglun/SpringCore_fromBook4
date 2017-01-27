package _10.AOP.AspectJ.AfterThrowing.Annotation.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeMethodCall {

	//sayHi metodundan once firstDuty metodu �al��acak
	@Before("execution(* _10.AOP.AspectJ.AfterThrowing.Annotation.IEmployeeService.sayHi(..))")
	public void firstDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan �NCE �al���an firstDuty metodu. ");
	}
	
	
}
