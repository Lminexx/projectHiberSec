package org.example;

import org.example.DAO.*;
import org.example.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    private final SessionFactory sessionFactory;

    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmActorDAO filmActorDAO;
    private final FilmCategoryDao filmCategoryDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;


    public Main() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmActor.class)
                .addAnnotatedClass(FilmCategory.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .buildSessionFactory();

        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        filmCategoryDAO = new FilmCategoryDao(sessionFactory);
        filmActorDAO = new FilmActorDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);

    }
    public static void main(String[] args) {
    Main main = new Main();
    Customer customer = main.createCustomer();


    }

    public Customer createCustomer() {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Store store = storeDAO.getItems(0, 1).getFirst();
            City florida = cityDAO.getCity("Florida");
            Address address = new Address();
            address.setAddress("sovetskaya 222, 23");
            address.setDistrict("flor");
            address.setPhone("9618323232");
            address.setCityId(florida);
            addressDAO.save(address);
            Customer customer = new Customer();
            customer.setFirstName("Sanya");
            customer.setLastName("Kiselev");
            customer.setActive(true);
            customer.setEmail("sasha.cd999@gmail.com");
            customer.setCreateDate(new Date());
            customer.setStoreId(store);
            customer.setAddressId(address);
            customerDAO.save(customer);
            tx.commit();
            return customer;
        }
    }
}