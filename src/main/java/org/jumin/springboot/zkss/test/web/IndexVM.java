package org.jumin.springboot.zkss.test.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

@VariableResolver(DelegatingVariableResolver.class)
public class IndexVM {

	private String name = "-";

	@Command
	@NotifyChange("name")
	public void ook() {
		name = SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
