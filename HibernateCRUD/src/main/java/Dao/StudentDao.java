package Dao;

import com.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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
    public static List<Student> fetchByRes(float m){
        Session session=configuration.buildSessionFactory().openSession();
        Criteria c=session.createCriteria(Student.class);
        c.add(Restrictions.gt("marks",m));
        return c.list();
    }
    public static  List<Student> fetchByOrder(String order,String marks){
        Session session=configuration.buildSessionFactory().openSession();
        Criteria c=session.createCriteria(Student.class);
        if(order.equalsIgnoreCase("asc")){
            c.addOrder(Order.asc(marks));
        }
        else{
            c.addOrder(Order.desc(marks));
        }
        return c.list();
    }
    public static  List<Float> fetchByProject(String marks){
        Session session=configuration.buildSessionFactory().openSession();
        Criteria c=session.createCriteria(Student.class);
        c.setProjection(Projections.property(marks));
        return c.list();
    }
}
