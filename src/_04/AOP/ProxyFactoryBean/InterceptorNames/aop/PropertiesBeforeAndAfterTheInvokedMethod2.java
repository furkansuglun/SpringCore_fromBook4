package _04.AOP.ProxyFactoryBean.InterceptorNames.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PropertiesBeforeAndAfterTheInvokedMethod2 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("�a��r�lan metodun �nceki durumu ## PropertiesBeforeAndAfterTheInvokedMethod2");
		return null;
	}

}
