package _16.AOP.AspectJ.Around.XML.aop;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;

public class PropertiesBeforeAndAfterTheInvokedMethod {

	public void coverWithChoosenMethod(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("AOP...<aop:around>");
		System.out.println(joinpoint.getSignature().getName() + " metodundan ÖNCE çalýþan metod coverWithChoosenMethod");
		System.out.println("çaðýrýlan metodun argumentleri : " + Arrays.toString(joinpoint.getArgs()));
		
		
		joinpoint.proceed();
		
		System.out.println("AOP ... <aop:around>");
		System.out.println(joinpoint.getSignature().getName() + " metodundan sonraki çalýþan metot coverWithChoosenMethod");
	}

}
