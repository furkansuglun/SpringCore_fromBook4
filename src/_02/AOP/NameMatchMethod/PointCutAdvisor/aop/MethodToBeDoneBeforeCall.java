package _02.AOP.NameMatchMethod.PointCutAdvisor.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
//MethodBeforeAdvice ile her metottan hemen �nce devreye girece metodu olusturmus oluyoruz.
public class MethodToBeDoneBeforeCall implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		
		System.out.println("\nSpring AOP ile her metottan �nce devrey giren before metodu ");

		/** aspect i�lerimiz burada yer alacak �rn : security;
		 * ..
		 * ..
		 * ..
		 */
		
	}

}
