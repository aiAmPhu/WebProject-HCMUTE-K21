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
import murach.business.Product;

/**
 *
 * @author Huynh Hop
 */
public class ProductDB {
    public static List<Product> getAllProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Product u ORDER BY u.productID ASC ";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        try {
            List<Product> productList = q.getResultList();
            return productList;
        } finally {
            em.close();
        }
    }
    

    
    public static Product getLastProduct(){
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    String qString = "SELECT p FROM Product p ";
    TypedQuery<Product> q = em.createQuery(qString, Product.class);
    q.setMaxResults(1);
    try {
        Product lastProduct = q.getSingleResult();
        return lastProduct;
    } catch (NoResultException e) {
        return null;
    } finally {
        em.close();
    }
    }

    public static Product getProductByID(int productID) {
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    String qString = "SELECT p FROM Product p WHERE p.productID = :id";
    TypedQuery<Product> q = em.createQuery(qString, Product.class);
    q.setParameter("id",productID);
    try {
        Product products = q.getSingleResult();
        return products;
    } catch (NoResultException e) {
        return null;
    } finally {
        em.close();
    }
}

//    public static List<Product> getAllProduct() {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        String qString = "SELECT p FROM Product p";
//        TypedQuery<Product> q = em.createQuery(qString, Product.class);
//        try {
//            List<Product> products = q.getResultList();
//            return products;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
    
    public static int getMaxProductID() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT MAX(u.productID) FROM Product u";
        TypedQuery<Integer> q = em.createQuery(qString, Integer.class);

        try {
            Integer maxProductID = q.getSingleResult();
            return (maxProductID != null) ? maxProductID : 0;
        } finally {
            em.close();
        }
    }
    
    public static void insertProduct(Product product) {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void deleteProduct(int productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            Product product = em.find(Product.class, productId);
            if (product != null) {
                em.remove(product);
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
    public static void updateProduct(Product updatedProduct) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            Product existingProduct = em.find(Product.class, updatedProduct.getProductID());

            if (existingProduct != null) {
                // C?p nh?t thông tin c?a s?n ph?m v?i thông tin t? s?n ph?m ?ã ???c c?p nh?t
                existingProduct.setProductName(updatedProduct.getProductName());
                existingProduct.setPrice(updatedProduct.getPrice());
                existingProduct.setDescription(updatedProduct.getDescription());
                existingProduct.setImages(updatedProduct.getImages());
                existingProduct.setBrand(updatedProduct.getBrand());
                existingProduct.setCategory(updatedProduct.getCategory());
                existingProduct.setWeight(updatedProduct.getWeight());
                existingProduct.setNutritionalValue(updatedProduct.getNutritionalValue());
                // G?i merge ?? c?p nh?t thông tin trong c? s? d? li?u
                em.merge(existingProduct);
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
    

