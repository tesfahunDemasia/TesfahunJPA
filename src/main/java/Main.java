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

            Query query = entityManager.createNamedQuery("SELECT");
            List <Con> list = query.getResultList();

            for( Con user: list ){

                System.out.println(user.toString());

            }


//            Con a = new Con();



            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }

}
