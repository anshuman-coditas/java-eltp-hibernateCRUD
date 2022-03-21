package Dao;

import com.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao {
   static Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
    public static  int insert(Student s){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        int i=(int)session.save(s);
        transaction.commit();
        return i;
    }
    public static int updateStu(String n,float m){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        Query q=session.createQuery("update Student set marks=:x where sname=:y");
        q.setParameter("x",m);
        q.setParameter("y",n);
        int i=q.executeUpdate();
        transaction.commit();
        return i;
    }
    public static int deleteStu(String n){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        Query q=session.createQuery("delete from Student where sname=:x");
        q.setParameter("x",n);
        int i=q.executeUpdate();
        transaction.commit();
        return i;
    }
}
