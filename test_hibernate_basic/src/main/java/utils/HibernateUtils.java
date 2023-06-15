package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils 
{
private static SessionFactory factory;//singleton immutable
//inherently thread safe object created 1 per db
//job session provider
static
{
System.out.println();
factory= new Configuration()//empty config
.configure()//reads properties & mapping from hiber.cfg.xml
.buildSessionFactory();//build sf
}
//to access private outside
public static SessionFactory getFactory() {
	return factory;
}

}


