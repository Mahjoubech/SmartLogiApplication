package io.github.Mahjoubech.smartlogi;

import io.github.Mahjoubech.smartlogi.service.LivreurService;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
import java.util.Scanner;

public class App {

    // ✅ اسم ملف الـ Configuration الخاص بالـ Core Logic
//    private static final String CORE_CONFIG_LOCATION = "classpath:application-context.xml";
    private static final int PORT = 8080; // تغيير البورت إلى 8080

    public static void main(String[] args) {

        // 1. تحميل Core Spring Context (Services, DAOs, DB)
        // هذا هو الـ Context الذي يحتوي على جميع Beans (JPA, Services)
//        ApplicationContext coreContext = new ClassPathXmlApplicationContext("application-context.xml");

        // 2. إعداد Tomcat Embedded
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(PORT);
            tomcat.getConnector();

            // 3. إعداد Servlet Context وربطه بـ Base Directory
            String baseDir = new File(".").getAbsolutePath();
            Context ctx = tomcat.addContext("", baseDir);

            // 4. إعداد Web Application Context (لـ DispatcherServlet)
            // نستخدم نفس الـ Core Context كمصدر للـ Beans
            XmlWebApplicationContext webContext = new XmlWebApplicationContext();

            // 💡 نربط Web Context بـ Core Context الذي يحمل الـ Services والـ DAOs
            webContext.setConfigLocation("classpath:application-context.xml");
            webContext.refresh();

            // 5. إنشاء DispatcherServlet (Spring MVC) وربطه بالـ Web Context
            DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
            Tomcat.addServlet(ctx, "dispatcher", dispatcherServlet).setLoadOnStartup(1);

            // 6. ربط Servlet بـ URL Pattern (لـ API REST)
            // هذا يعني أن جميع الطلبات (مثلاً /api/v1/livreurs) ستذهب إلى هذا الـ Servlet
            ctx.addServletMappingDecoded("/*", "dispatcher");

            tomcat.start();
            tomcat.getServer().await();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}