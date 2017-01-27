package _02.AOP.NameMatchMethod.PointCutAdvisor.aop;

import org.springframework.aop.ThrowsAdvice;
//ThrowsAdvice ile exception sonras�n yap�lacak i�ler i�in kullan�l�r�z
public class MethodToBeDoneAfterCallException implements ThrowsAdvice{

	public void afterThrowing(IllegalArgumentException e ) throws Throwable {
		System.out.println("Spring AOP ile metotlardaki bir exception sonras� �al��an afterThrowing metodu.");
	}
	
}
