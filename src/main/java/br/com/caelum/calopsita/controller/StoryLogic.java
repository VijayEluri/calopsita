package br.com.caelum.calopsita.controller;

import org.vraptor.annotations.Component;
import org.vraptor.annotations.InterceptedBy;

import br.com.caelum.calopsita.infra.interceptor.AuthenticationInterceptor;
import br.com.caelum.calopsita.infra.interceptor.AuthorizationInterceptor;
import br.com.caelum.calopsita.infra.interceptor.HibernateInterceptor;
import br.com.caelum.calopsita.model.Project;
import br.com.caelum.calopsita.model.Story;
import br.com.caelum.calopsita.repository.StoryRepository;

@Component
@InterceptedBy( { HibernateInterceptor.class, AuthenticationInterceptor.class, AuthorizationInterceptor.class })
public class StoryLogic {

	private final StoryRepository repository;
	private Project project;

	public StoryLogic(StoryRepository repository) {
		this.repository = repository;
	}

	public void save(Story story, Project project) {
		this.project = project;
		story.setProject(project);
		repository.save(story);
	}
	
	public Project getProject() {
		return project;
	}
}
