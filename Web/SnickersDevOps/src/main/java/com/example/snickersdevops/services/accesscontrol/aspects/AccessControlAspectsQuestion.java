package com.example.snickersdevops.services.accesscontrol.aspects;

import com.example.snickersdevops.models.Question;
import com.example.snickersdevops.services.accesscontrol.AccessControlService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccessControlAspectsQuestion {

	@Autowired
	private AccessControlService<Question> accessControlService;

	public void setAccessControlService(AccessControlService<Question> accessControlService) {
		this.accessControlService = accessControlService;
	}

	@Around("execution(* com.example.snickersdevops.repository.QuestionRepo.save(..)) && args(question)")
	public Object save(ProceedingJoinPoint proceedingJoinPoint, Question question) throws Throwable {
		if (question.getId() == null) {
			accessControlService.canCurrentUserCreateObject(question);
		} else {
			accessControlService.canCurrentUserUpdateObject(question);
		}

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(* com.example.snickersdevops.repository.QuestionRepo.find(Long)) && args(id)")
	public Object find(ProceedingJoinPoint proceedingJoinPoint, Long id) throws Throwable {
		accessControlService.canCurrentUserReadObject(id);

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(* com.example.snickersdevops.repository.QuestionRepo.findAll())")
	public Object findAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		accessControlService.canCurrentUserReadAllObjects();

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(* com.example.snickersdevops.repository.QuestionRepo.delete(..)) && args(question)")
	public Object delete(ProceedingJoinPoint proceedingJoinPoint, Question question) throws Throwable {
		accessControlService.canCurrentUserDeleteObject(question);

		return proceedingJoinPoint.proceed();
	}

}
