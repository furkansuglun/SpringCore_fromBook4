package _11.AOP.AspectJ.Around.Annotation.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PropertiesBeforeAndAfterTheInvokedMethod {

	@Around("execution(* _11.AOP.AspectJ.Around.Annotation.IEmployeeService.checkNameSurname(..))")
	public void coverWithAround(ProceedingJoinPoint joinPoint) throws Throwable {
		//ProceedingJoinPoint ile pointcut hakk�nda bilgileri elde ederiz.
		System.out.println("\n ...Aspect..." + joinPoint.getSignature().getName() + "metodundan �NCE �al��an coverWithAround metodu.");
		System.out.println("�a��r�lan metodun argument leri : " + Arrays.toString(joinPoint.getArgs()));
		
		//@Around i�indeki metodu �a��r�r.
		joinPoint.proceed();
		
		System.out.println("\n ...Aspect..." + joinPoint.getSignature().getName() + "metodundan SONRA �al��an coverWithAround metodu.");
		
	}
	
}
