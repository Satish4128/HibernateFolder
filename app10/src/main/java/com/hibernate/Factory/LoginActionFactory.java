package com.hibernate.Factory;

import com.hibernate.action.LoginAction;

public class LoginActionFactory {
    private static LoginAction loginAction;
    static{
        loginAction=new LoginAction();
    }
    public static LoginAction getLoginAction()
    {
        return loginAction;
    }
}
