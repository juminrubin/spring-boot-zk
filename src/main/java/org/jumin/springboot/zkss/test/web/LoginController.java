package org.jumin.springboot.zkss.test.web;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class LoginController extends SelectorComposer<Window> {
    
    private static final long serialVersionUID = 4341924050807921595L;

    @Wire
    private Textbox userName;

    @Wire
    private Textbox organizationName;

    @Wire
    private Textbox password;

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
    }

    @Listen("onClick = button#resetButton")
    public void resetValues() {

    }

    @Listen("onClick = button#loginButton; onOK = textbox#password")
    public void processLoginInfo() {
        String scopedUserName = userName.getText() + "@" + organizationName.getText();
        scopedUserName = "user@org";
        System.out.println("Login with token: " + scopedUserName + " and password: '" + password.getText() + "'");
        SecurityContext sc = SecurityContextHolder.createEmptyContext();
        sc.setAuthentication(new UsernamePasswordAuthenticationToken(scopedUserName, password.getText()));
        SecurityContextHolder.setContext(sc);
        Executions.sendRedirect(ZKSecurityConfig.DEFAULT_APP_URL);
    }
}
