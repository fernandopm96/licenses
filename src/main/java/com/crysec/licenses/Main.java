package com.crysec.licenses;

import com.crysec.licenses.entities.License;
import com.crysec.licenses.entities.LicenseDetails;
import com.crysec.licenses.entities.Role;
import com.crysec.licenses.utils.ConnectionDb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Date;

// Programa para gestionar licencias de aplicaciones.
// El programa se compone de funciones que permiten crear, actualizar, eliminar y listar licencias,
// ofreciendo un CRUD. También se incluyen funciones para comprobar si hay licencias registradas,
// y para comprobar si existe alguna licencia con un id concreto.
// Los objetos EntityManagerFactory y EntityManager los proporciona la clase ConnectionDb, siguiendo el patrón singleton.

public class Main {

    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;

    public static void main(String[] args) {

        entityManagerFactory = ConnectionDb.getEntityManagerFactory();
        entityManager = ConnectionDb.getEntityManager();

        // Llamadas a funciones:


        //createLicense();
        //getAllLicenses();
        //updateLicence();
        //removeLicense();
    }

    // Crear licencias
    public static void createLicense(){
        LicenseDetails details = new LicenseDetails(50D, new Date());
        License license = new License( "Crycast" , Role.Admin, details);
        entityManager.getTransaction().begin();
        entityManager.persist(license);
        entityManager.getTransaction().commit();
    }

    // Actualizar
    public static void updateLicense(){
        if(licenseExists(1L)){
            TypedQuery<License> license = entityManager.createQuery("SELECT l FROM License l WHERE l.licenseId = 1L", License.class);
            entityManager.getTransaction().begin();
            entityManager.merge(license.getSingleResult());
            entityManager.getTransaction().commit();
        }
    }
    // Eliminar
    public static void removeLicense(){
        if(licenseExists(1L)){
            TypedQuery<License> license = entityManager.createQuery("SELECT l FROM License l WHERE l.licenseId = 1L", License.class);
            entityManager.getTransaction().begin();
            entityManager.remove(license.getSingleResult());
            entityManager.getTransaction().commit();
        }
    }
    // Listar licencias
    public static void getAllLicenses(){
        TypedQuery<License> licenses = entityManager.createQuery("SELECT l FROM License l", License.class);
        licenses.getResultList().forEach(System.out::println);
    }
    // Comprobar si existe alguna licencia
    public static boolean anyUsers(){
        TypedQuery<License> licenses = entityManager.createQuery("SELECT l FROM License l", License.class);
        if(licenses.getResultList().isEmpty()){
            return false;
        }
        return true;
    }
    // Comprobar si existe la licencia con el id pasado como parámetro
    public static boolean licenseExists(Long id){
        TypedQuery<License> license = entityManager.createQuery("SELECT l FROM License l WHERE l.licenseId = :id", License.class);
        license.setParameter("id", id);
        if(license.getResultList().isEmpty()){
            return false;
        }
        return true;
    }


}
