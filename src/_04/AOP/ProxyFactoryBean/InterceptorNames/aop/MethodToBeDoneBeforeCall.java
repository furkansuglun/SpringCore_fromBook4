package _04.AOP.ProxyFactoryBean.InterceptorNames.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
//MethodBeforeAdvice ile her metottan hemen önce devreye girece metodu olusturmus oluyoruz.
public class MethodToBeDoneBeforeCall implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		
		System.out.println("\nSpring AOP ile her metottan önce devrey giren before metodu ");

		/** aspect iþlerimiz burada yer alacak örn : security;
		 * ..
		 * ..
		 * ..
		 */
		
	}

}
