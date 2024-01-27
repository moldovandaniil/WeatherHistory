package com.example.weathertask.repository;
import com.example.weathertask.entity.WeatherHistory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class WeatherHistoryRepository {
    private final EntityManager entityManager;

    public WeatherHistoryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(WeatherHistory weatherHistory) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(weatherHistory);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public List<WeatherHistory> findByPostalCode(String postalCode) {
        TypedQuery<WeatherHistory> query = entityManager.createQuery(
                "SELECT w FROM WeatherHistory w WHERE w.postalCode = :postalCode", WeatherHistory.class);
        query.setParameter("postalCode", postalCode);
        return query.getResultList();
    }

    public List<WeatherHistory> findAll() {
        return entityManager.createQuery("SELECT w FROM WeatherHistory w", WeatherHistory.class)
                .getResultList();
    }

    public WeatherHistory findById(Long id) {
        return entityManager.find(WeatherHistory.class, id);
    }


}

