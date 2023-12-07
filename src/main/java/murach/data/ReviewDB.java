
package murach.data;
import java.util.List;
import javax.persistence.*;

import javax.persistence.EntityManager;
import murach.business.Review;


public class ReviewDB {

    public static void insert(Review user) {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

//    public static void update(Users user) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        EntityTransaction trans = em.getTransaction();
//        trans.begin();
//        try {
//            em.merge(user);
//            trans.commit();
//        } catch (Exception e) {
//            System.out.println(e);
//            trans.rollback();
//        } finally {
//            em.close();
//        }
//    }
//
//    public static void delete(Users user) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        EntityTransaction trans = em.getTransaction();
//        trans.begin();
//        try {
//            em.remove(em.merge(user));
//            trans.commit();
//        } catch (Exception e) {
//            System.out.println(e);
//            trans.rollback();
//        } finally {
//            em.close();
//        }
//    }
//    
//    public static List<Users> selectUser(String username, String password) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        String qString = "SELECT u FROM Users u " +
//                "WHERE u.username = :username and u.password = :password";
//        TypedQuery<Users> q = em.createQuery(qString, Users.class);
//        q.setParameter("username", username);
//        q.setParameter("password", password);
//        try {
//            List<Users> users = q.getResultList();
//            return users;
//        } catch (NoResultException e) {
//            return null; // or an empty list, depending on your preference
//        } finally {
//            em.close();
//        }
//    }
//    
//    public static List<Users> selectUsername(String username) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        String qString = "SELECT u FROM Users u " +
//                "WHERE u.username = :username";
//        TypedQuery<Users> q = em.createQuery(qString, Users.class);
//        q.setParameter("username", username);
//        try {
//            List<Users> users = q.getResultList();
//            return users;
//        } catch (NoResultException e) {
//            return null; // or an empty list, depending on your preference
//        } finally {
//            em.close();
//        }
//    }
//    public static Users selectUser(String username, String password) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        String qString = "SELECT u FROM Users u " +
//                "WHERE u.username = :username and u.password=:password";
//        TypedQuery<Users> q = em.createQuery(qString, Users.class);
//        q.setParameter("username", username);
//        q.setParameter("password", password);
//        try {
//            Users user = q.getSingleResult();
//            return user;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
//
//    public static boolean usernameExists(String username, String password) {
//        List<Users> users = selectUser(username, password);
//        return !users.isEmpty();
//    }
}