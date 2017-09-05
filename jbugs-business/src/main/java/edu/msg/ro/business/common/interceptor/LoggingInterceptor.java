package edu.msg.ro.business.common.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LoggingInterceptor {

	@AroundInvoke
	public Object logMethodEntry(InvocationContext ctx) throws Exception {

		String methodName = ctx.getMethod().getName();
		System.out.println("In LoggingInterceptor..................... before method " + methodName + " call");
		Object returnMe = ctx.proceed();
		System.out.println("In LoggingInterceptor..................... after method " + methodName + " call");
		return returnMe;
	}
}