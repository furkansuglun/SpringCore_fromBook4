package _11.AOP.AspectJ.Around.Annotation.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PropertiesBeforeAndAfterTheInvokedMethod {

	@Around("execution(* _11.AOP.AspectJ.Around.Annotation.IEmployeeService.checkNameSurname(..))")
	public void coverWithAround(ProceedingJoinPoint joinPoint) throws Throwable {
		//ProceedingJoinPoint ile pointcut hakkýnda bilgileri elde ederiz.
		System.out.println("\n ...Aspect..." + joinPoint.getSignature().getName() + "metodundan ÖNCE çalýþan coverWithAround metodu.");
		System.out.println("Çaðýrýlan metodun argument leri : " + Arrays.toString(joinPoint.getArgs()));
		
		//@Around içindeki metodu çaðýrýr.
		joinPoint.proceed();
		
		System.out.println("\n ...Aspect..." + joinPoint.getSignature().getName() + "metodundan SONRA çalýþan coverWithAround metodu.");
		
	}
	
}
