package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import util.LoggerUtil;

@Aspect
public class LoggerAspect {
	@Autowired
	private LoggerUtil loggerUtil;
	
	@Around("execution(* service.PersonaServiceImpl.obtenerPersonas())")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		loggerUtil.log(joinPoint.getClass(), 
				joinPoint.getSignature().getName(), 
				joinPoint.getArgs());
	}
}
