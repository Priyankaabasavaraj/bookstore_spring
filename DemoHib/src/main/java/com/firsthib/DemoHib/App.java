package com.firsthib.DemoHib;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import com.mysql.cj.jdbc.ha.ServerAffinityStrategy;

import org.hibernate.Session;

public class App 
{
    public static void main( String[] args ) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {
    	Alien a=new Alien();
    	a.setAid(102);
    	a.setAname("riya");
    	a.setColor("Blue");
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    //	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties().buildServiceRegistry();)
    	
    	SessionFactory sf= con.buildSessionFactory();
    	
    	Session session=sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(a);
    	
    	tx.commit();
    }
}
