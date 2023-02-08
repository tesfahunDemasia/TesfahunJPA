import entity.Con;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
             // הדפסה
            Query query = entityManager.createNamedQuery("SELECT");
            List <Con> list = query.getResultList();
            for( Con user: list ){
                System.out.println(user.toString());

            }
            // הכנסת איבר חדש
//            Con a = new Con();
//            a.setQwerty("tigabooo");
//            entityManager.persist(a);

            //update
            for (Con user:list) {
                if(user.getQwerty().equals("yhala")){
                    user.setQwerty("new me");
                    entityManager.persist(user);
                }
            }
            //הדפסה אחרי שינוי
            System.out.println("after update");
            for( Con user: list ){
                System.out.println(user.toString());

            }
            transaction.commit();
        }

        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    }

