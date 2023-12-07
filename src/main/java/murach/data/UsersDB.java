
package murach.data;
import java.util.List;
import javax.persistence.*;

import javax.persistence.EntityManager;
import murach.business.Users;


public class UsersDB {
    
    public static void insert(Users user) {
        
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

    public static void update(Users Uuser) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        //trans.begin();
        try {
            trans.begin();
            Users Euser = em.find(Users.class, Uuser.getUserid());

            if (Euser != null) {
                // C?p nh?t thông tin c?a s?n ph?m v?i thông tin t? s?n ph?m ?ã ???c c?p nh?t
                Euser.setUsername(Uuser.getUsername());
                Euser.setPassword(Uuser.getPassword());
                Euser.setFirstname(Uuser.getFirstname());
                Euser.setLastname(Uuser.getLastname());
                Euser.setPhonenumber(Uuser.getPhonenumber());
                Euser.setAddress(Uuser.getAddress());
                
                // G?i merge ?? c?p nh?t thông tin trong c? s? d? li?u
                em.merge(Euser);
            }

            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                System.out.println(e);
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void delete(Users user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static List<Users> selectUser(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Users u " +
                "WHERE u.username = :username and u.password = :password";
        TypedQuery<Users> q = em.createQuery(qString, Users.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        try {
            List<Users> users = q.getResultList();
            return users;
        } catch (NoResultException e) {
            return null; // or an empty list, depending on your preference
        } finally {
            em.close();
        }
    }
    
    public static List<Users> selectUsername(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Users u " +
                "WHERE u.username = :username";
        TypedQuery<Users> q = em.createQuery(qString, Users.class);
        q.setParameter("username", username);
        try {
            List<Users> users = q.getResultList();
            return users;
        } catch (NoResultException e) {
            return null; // or an empty list, depending on your preference
        } finally {
            em.close();
        }
    }
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
    public static boolean usernameExists(String username, String password) {
        List<Users> users = selectUser(username, password);
        return !users.isEmpty();
    }
    
    public static  Users getUsersByID(int id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT users FROM Users users WHERE users.userid = :id";
        TypedQuery<Users> q = em.createQuery(qString, Users.class);
        q.setParameter("id",id);
        try{
            Users user = q.getSingleResult();
            return user;
        }catch (NoResultException e){
            return null;
        } finally {
            em.close();
        }
    }
    
    public static List<Users> selectAllUsers() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Users u WHERE u.roless <> 1 ORDER BY u.userid ASC ";
        TypedQuery<Users> q = em.createQuery(qString, Users.class);

        try {
            List<Users> userList = q.getResultList();
            return userList;
        } finally {
            em.close();
        }
    }
}