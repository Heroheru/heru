/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa;
import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Dell
 */
public class HibernateUtil {



    private static final SessionFactory sessionFactory;
 

  static {
    try {
        File configFile;
        configFile = new File("hibernate.cfg.xml");
            if (!configFile.exists()) {
                System.err.println("File hibernate.cfg.xml tidak ditemukan!");
            }

        // Membaca konfigurasi Hibernate dari hibernate.cfg.xml
        sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")  // Memastikan file konfigurasi dibaca
        .addAnnotatedClass(ModelMahasiswa.class)
        .setProperty("hibernate.show_sql", "true")
        .setProperty("hibernate.hbm2ddl.auto", "update")
        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
        .buildSessionFactory();
    } catch (HibernateException ex) { // Menampilkan stack trace lengkap
        ex.printStackTrace();  // Menampilkan stack trace lengkap
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
