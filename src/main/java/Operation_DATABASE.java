import utils.HibernateUtil;
import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class Operation_DATABASE {


    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();


    public void addPerson(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();

    }

    public Person getPersonById(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Person person = session.get(Person.class, id);
        transaction.commit();
        session.close();
        return person;
    }


    public void updatePerson(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(person);

        transaction.commit();
        session.close();

    }


    public void deletePerson(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Person person = session.get(Person.class, id);

        session.delete(person);


        transaction.commit();
        session.close();

    }

    public List<Person> getAllPersons() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        ///////////////////////////////////////////////////////////

       Query q = session.createQuery("FROM entities.Person", Person.class);
        List<Person> personList = q.getResultList();



        transaction.commit();

        return personList;

    }

    ////////////////////////////////////////////
    public List<Person> getBySalary(double salary) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Query <Person> query = session.createQuery("FROM entities.Person  WHERE salary = :salary", Person.class);
        query.setParameter("salary",salary);
        transaction.commit();

        return query.list();
    }


}









































