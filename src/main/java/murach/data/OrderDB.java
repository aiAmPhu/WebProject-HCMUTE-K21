/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import murach.business.Orders;

/**
 *
 * @author Duc Vinh
 */
public class OrderDB {
    public static List<Orders> getAllOrders() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT o FROM Orders o";  // Thay "Order" thành "OrderEntity" ho?c tên khác
        TypedQuery<Orders> q = em.createQuery(qString, Orders.class);

        try {
            List<Orders> orderList = q.getResultList();
            return orderList;
        } finally {
            em.close();
        }
    }
    
    public static List<Orders> selectUserId(int userId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT o FROM Orders o WHERE o.customer.userid=:userId";  // Thay "Order" thành "OrderEntity" ho?c tên khác
        TypedQuery<Orders> q = em.createQuery(qString, Orders.class);
        q.setParameter("userId", userId);
        try {
            List<Orders> users = q.getResultList();
            return users;
        } catch (NoResultException e) {
            return null; // or an empty list, depending on your preference
        } finally {
            em.close();
        }
    }
    
    public static void insert(Orders user) {
        
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

    public static void update(Orders order) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(order);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void delete(Orders order) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(order));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Orders getOrdertById(int orderId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Orders order = em.find(Orders.class, orderId);
            return order;
        } finally {
            em.close();
        }
    }
    
    public static void deleteOrder(int orderId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            Orders order = em.find(Orders.class, orderId);
            if (order != null) {
                em.remove(order);
            }
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void updateOrder(Orders updatedOrder) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            Orders existingOrder = em.find(Orders.class, updatedOrder.getId());

            if (existingOrder != null) {
                // C?p nh?t thông tin c?a s?n ph?m v?i thông tin t? s?n ph?m ?ã ???c c?p nh?t
                //existingOrder.setProductName(updatedProduct.getProductName());
                //existingOrder.setPrice(updatedProduct.getPrice());
                //existingOrder.setDescription(updatedOrder.getDescription());

                existingOrder.setOrderStatus(1);
                // G?i merge ?? c?p nh?t thông tin trong c? s? d? li?u
                em.merge(existingOrder);
            }

            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
