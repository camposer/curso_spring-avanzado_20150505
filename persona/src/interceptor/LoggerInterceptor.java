package interceptor;

import java.io.FileNotFoundException;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.LoggerUtil;

@Component
public class LoggerInterceptor implements MethodInterceptor {
	@Autowired
	private LoggerUtil loggerUtil;

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		log(methodInvocation);
		return methodInvocation.proceed();
	}

	private void log(MethodInvocation methodInvocation) throws FileNotFoundException {
		loggerUtil.log(methodInvocation.getThis().getClass(),
				methodInvocation.getMethod().getName(), 
				methodInvocation.getArguments());
	}
}



