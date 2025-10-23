package io.github.Mahjoubech.smartlogi;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String springConfigFile = "application-context.xml";
    try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfigFile)){
        System.out.println("✅ Succès du chargement du Spring Context.");
        System.out.println("Nombre de Beans définis : " + context.getBeanDefinitionCount());
    }catch (Exception e) {
    System.err.println("❌ Échec du chargement du Spring Context !");
    System.err.println("Vérifiez le fichier " + springConfigFile + " et la connexion à la base de données.");
    e.printStackTrace();
}
}
}
