package com.commy;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by xuht on 2017/4/5.
 */
public class JettyServer implements ApplicationContextAware {

    private Server server;
    private ApplicationContext applicationContext;

    private int wechatRemotePort = 7882;
    private String wechatRemotePath = "/";
    private String wechatRemoteDescriptor = "web.xml";
    private String wechatRemoteResourceBase = "webapp";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void start() throws Exception{
        String path = Class.class.getClass().getResource("/").getPath();
        server = new Server(wechatRemotePort);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath(wechatRemotePath);
        webAppContext.setDescriptor(path + wechatRemoteDescriptor);
        webAppContext.setResourceBase(path + wechatRemoteResourceBase);
        webAppContext.setConfigurationDiscovered(true);
        webAppContext.setParentLoaderPriority(true);
        server.setHandler(webAppContext);

        // 以下代码是关键
        webAppContext.setClassLoader(applicationContext.getClassLoader());

        XmlWebApplicationContext xmlWebAppContext = new XmlWebApplicationContext();
        xmlWebAppContext.setParent(applicationContext);
        xmlWebAppContext.setConfigLocation("");
        xmlWebAppContext.setServletContext(webAppContext.getServletContext());
        xmlWebAppContext.refresh();

        webAppContext.setAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
                xmlWebAppContext);
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public int getWechatRemotePort() {
        return wechatRemotePort;
    }

    public void setWechatRemotePort(int wechatRemotePort) {
        this.wechatRemotePort = wechatRemotePort;
    }

    public String getWechatRemotePath() {
        return wechatRemotePath;
    }

    public void setWechatRemotePath(String wechatRemotePath) {
        this.wechatRemotePath = wechatRemotePath;
    }

    public String getWechatRemoteDescriptor() {
        return wechatRemoteDescriptor;
    }

    public void setWechatRemoteDescriptor(String wechatRemoteDescriptor) {
        this.wechatRemoteDescriptor = wechatRemoteDescriptor;
    }

    public String getWechatRemoteResourceBase() {
        return wechatRemoteResourceBase;
    }

    public void setWechatRemoteResourceBase(String wechatRemoteResourceBase) {
        this.wechatRemoteResourceBase = wechatRemoteResourceBase;
    }
}
