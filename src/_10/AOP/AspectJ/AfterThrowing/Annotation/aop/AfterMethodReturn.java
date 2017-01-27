 package _10.AOP.AspectJ.AfterThrowing.Annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterMethodReturn {

	
	@AfterReturning(pointcut = "execution(* _10.AOP.AspectJ.AfterThrowing.Annotation.IEmployeeService.sayHi(..))" ,
			returning = "result")
	public void afterReturnDuty(JoinPoint joinPoint , Object result) {
		
		System.out.println("Aspectj");
		System.out.println(joinPoint.getSignature().getName() + " isimli metodun GER� D�N�� DE�ER�NDEN SONRA �al���an afterReturnDuty metodu. ");
		System.out.println("afterReturnDuty metodunun geri d�n�� de�eri : " + result);
		
	}
	
}
