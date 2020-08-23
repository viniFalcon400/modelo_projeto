package com.modelo.projeto.filters;

import java.util.Date;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author vcoelho
 */
@WebListener
public class HttpSessionChecker implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        System.out.printf("Session ID %s created at %s%n", event.getSession().getId(), new Date());
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.printf("Session ID %s destroyed at %s%n", event.getSession().getId(), new Date());
    }

}
