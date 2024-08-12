package org.example;

import org.example.DAO.*;
import org.example.Entity.*;
import org.example.Enums.Feature;
import org.example.Enums.Rating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
//       Customer customer = main.createCustomer();
//    //main.customerBackAtInventory();
//      main.clientRentalInventor(customer);

    main.createNewFilm();
    }


    public Customer createCustomer() {
        Transaction tx = null;
        try {
            tx = sessionFactory.getCurrentSession().beginTransaction();
            Store store = storeDAO.getItems(0, 1).getFirst();
            City florida = cityDAO.getCity("Santa F");
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
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public void customerBackAtInventory(){
        Transaction tx = null;
        try {
            tx = sessionFactory.getCurrentSession().beginTransaction();
            Rental rental = rentalDAO.getRental();
            System.out.println(rental.getRentalId());
            rental.setReturnDate(new Date());
            rentalDAO.save(rental);
            tx.commit();
        }catch (Exception e){
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    private void clientRentalInventor(Customer customer) {
        Transaction tx = null;
        try{
            tx = sessionFactory.getCurrentSession().beginTransaction();
            Film normFilm = filmDAO.getNormFilm(44);


            Store store = storeDAO.getItems(0, 1).getFirst();


            Inventory inventory = new Inventory();
            inventory.setStoreId(store);
            inventory.setFilmId(normFilm);
            inventoryDAO.save(inventory);


            Staff staff = store.getManagerStaffId();

            Rental rental = new Rental();
            rental.setCustomerId(customer);
            rental.setStaffId(staff);
            rental.setInventoryId(inventory);
            rental.setRantalDate(new Date());
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setRentalId(rental);
            payment.setPaymentDate(new Date());
            payment.setAmount(BigDecimal.valueOf(2.4));
            payment.setCustomerId(customer);
            payment.setStaffId(staff);
            paymentDAO.save(payment);


            tx.commit();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    private void createNewFilm(){
        Transaction tx = null;
        try{
            tx = sessionFactory.getCurrentSession().beginTransaction();
            Actor actorIam = new Actor();
            actorIam.setFirstName("Alex");
            actorIam.setLastName("Kiselev");
            Actor actorBro = new Actor();
            actorBro.setFirstName("Matvey");
            actorBro.setLastName("Dude");
            Set<Actor> homieActors = new HashSet<>();
            Category horrorCategory = new Category();
            horrorCategory.setName("Horror");
            Category dramaCategory = new Category();
            dramaCategory.setName("Drama");
            Set<Category> myCategory = new HashSet<>();
            Language language = languageDAO.getItems(0,20).getFirst();

            Film myFilm = new Film();
            myFilm.setActors(homieActors);
            myFilm.setCategories(myCategory);
            myFilm.setDescription("My film pro menya");
            myFilm.setRating(Rating.R);
            myFilm.setLanguageId(language);
            myFilm.setOriginalLanguageId(language);
            myFilm.setTitle("My film pro menya");
            myFilm.setRentalRate(BigDecimal.valueOf(5.0));
            myFilm.setReplacementCost(BigDecimal.valueOf(5.0));
            myFilm.setLength((short) 230);
            myFilm.setReleaseYear(Year.of(2024));
            Set<Feature> settt = new HashSet<>();
            settt.add(Feature.BEHIND_THE_SCENES);
            settt.add(Feature.DELETED_SCENES);
            myFilm.setSpecialFeatures(settt);
            myFilm.setRentalDuration((byte) 123);
            filmDAO.save(myFilm);

            FilmText filmText = new FilmText();
            filmText.setFilm(myFilm);
            filmText.setDescription("wow& awesome");
            filmText.setTitle("aboba");
            filmTextDAO.save(filmText);

            Store store = storeDAO.getItems(0, 1).getFirst();
            Customer customer = customerDAO.getItems(0, 1).getFirst();
            Inventory inventory = new Inventory();
            inventory.setStoreId(store);
            inventory.setFilmId(myFilm);
            inventoryDAO.save(inventory);
            Rental rental = new Rental();
            rental.setInventoryId(inventory);
            rental.setReturnDate(new Date());
            rental.setRantalDate(new Date());
            rental.setCustomerId(customer);
            rental.setStaffId(store.getManagerStaffId());
            rentalDAO.save(rental);
            Payment payment = new Payment();
            payment.setRentalId(rental);
            payment.setAmount(BigDecimal.valueOf(5.0));
            payment.setStaffId(store.getManagerStaffId());
            payment.setCustomerId(customer);
            payment.setPaymentDate(new Date());
            paymentDAO.save(payment);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}