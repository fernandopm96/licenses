package com.crysec.licenses.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDb {

    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;

    public static EntityManagerFactory getEntityManagerFactory(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("db/licences.odb");
        }
        return entityManagerFactory;
    }
    public static EntityManager getEntityManager(){
        if(entityManager == null){
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }
    public static void closeEntityManagerFactory(){
        if(entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }
    public static void closeEntityManager(){
        if(entityManager.isOpen()){
            entityManager.close();
        }
    }
}
