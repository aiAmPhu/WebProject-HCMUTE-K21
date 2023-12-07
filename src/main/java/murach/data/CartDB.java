/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import murach.business.Cart;
import murach.business.CartLine;
import murach.business.Users;



/**
 *
 * @author Duc Vinh
 */
public class CartDB {
    public static void update(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static Cart getCartByUsers(Users user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT cart FROM Cart cart WHERE cart.users.userid = :id";
        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
        q.setParameter("id", user.getUserid());
        try {
            Cart cart = q.getSingleResult();
            return cart;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static void insert(Cart cart) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void removeCartLines(Cart cart) {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();
            EntityTransaction trans = em.getTransaction();

            try {
                trans.begin();

                if (cart != null) {
                    List<CartLine> cartLines = cart.getCartLines();

                    // Xóa các CartLine t? c? s? d? li?u
                    for (CartLine cartLine : cartLines) {
                        em.remove(em.merge(cartLine));
                    }

                    // C?p nh?t Cart sau khi xóa
                    cart.setCartLines(new ArrayList<>());
                    em.merge(cart);
                }

                trans.commit();
            } catch (Exception e) {
                System.out.println(e);
                trans.rollback();
            } finally {
                em.close();
            }
        }
}
