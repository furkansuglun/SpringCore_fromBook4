package _16.AOP.AspectJ.Around.XML.aop;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;

public class PropertiesBeforeAndAfterTheInvokedMethod {

	public void coverWithChoosenMethod(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("AOP...<aop:around>");
		System.out.println(joinpoint.getSignature().getName() + " metodundan �NCE �al��an metod coverWithChoosenMethod");
		System.out.println("�a��r�lan metodun argumentleri : " + Arrays.toString(joinpoint.getArgs()));
		
		
		joinpoint.proceed();
		
		System.out.println("AOP ... <aop:around>");
		System.out.println(joinpoint.getSignature().getName() + " metodundan sonraki �al��an metot coverWithChoosenMethod");
	}

}
