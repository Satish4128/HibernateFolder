package com.hibernate.action;

import com.hibernate.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hibernate.util.HibernateUtil;

public class LoginAction {

    public String ckeckLogin(User user)
    {
        String status="";
        try{
            SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            User user1=(User)session.get(User.class,user.getUname());
            if(user1==null)
            {
                status="failure";
            }
            else {
                if(user.getUpwd().equals(user1.getUpwd()))
                {
                    status="success";
                }
                else {
                    status="failure";
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return status;

    }
}
