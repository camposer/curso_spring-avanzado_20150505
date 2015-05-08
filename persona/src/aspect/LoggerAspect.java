package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.LoggerUtil;

@Component
@Aspect
public class LoggerAspect {
	@Autowired
	private LoggerUtil loggerUtil;
	
	@Around("execution(* service.PersonaServiceImpl.obtenerPersonas())")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		loggerUtil.log(joinPoint.getTarget().getClass(), 
				joinPoint.getSignature().getName(), 
				joinPoint.getArgs());
		
		return joinPoint.proceed();
	}
}
