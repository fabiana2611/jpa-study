package br.study.jpa.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.study.jpa.model.Customer;
import br.study.jpa.model.JobOpportunity;
import br.study.jpa.model.Order;
import br.study.jpa.model.Product;
import br.study.jpa.model.Restaurant;
import br.study.jpa.model.domain.Position;
import br.study.jpa.model.domain.TypeStatus;

public class CreateData {

    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction trx = manager.getTransaction();
        trx.begin();

        // CREATE
        Customer customer = createProduct();

        Order order = createOrder();

        Product product1 = createProduct("Fresh Potatle", "Potatle", 8.97d);
        Product product2 = createProduct("Past", "Pasta", 43.97d);

        Restaurant restaurant = createRestaurant();

        JobOpportunity job = createJob();

        // UPDATE

        order.setCustomer(customer);

        List<Order> listOrder = new ArrayList<Order>();
        listOrder.add(order);

        customer.setOrders(listOrder);
        product1.setOrders(listOrder);

        List<Product> listProductsOrder = new ArrayList<Product>();
        listProductsOrder.add(product1);

        order.setProducts(listProductsOrder);

        List<Product> listProductsRestaurant = new ArrayList<Product>();
        listProductsRestaurant.add(product1);
        listProductsRestaurant.add(product2);

        restaurant.setProducts(listProductsRestaurant);

        restaurant.setOrders(listOrder);

        order.setRestaurant(restaurant);

        job.setRestaurant(restaurant);

        // COMMIT

        manager.persist(customer);
        manager.persist(order);
        manager.persist(product1);
        manager.persist(product2);
        manager.persist(restaurant);
        manager.persist(job);

        trx.commit();
        manager.close();
    }

    private static Customer createProduct() {
        Customer customer = new Customer();
        customer.setName("Tiago Silva");
        customer.setEmail("tiago.silva@email.com");
        customer.setPassword("123");
        return customer;
    }

    private static Order createOrder() {
        Order order = new Order();
        order.setOrderAddress("Street A");
        order.setOrderDate(new Date());
        order.setOrderStatus(TypeStatus.INBOUND);
        return order;
    }

    private static Product createProduct(String description, String name, Double price) {
        Product product = new Product();
        product.setProductDescription(description);
        product.setProductName(name);
        product.setProductPrice(price);
        return product;
    }

    private static Restaurant createRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setAddress("Street B");
        restaurant.setEmail("burguer@email.com");
        restaurant.setName("Burguer King");
        return restaurant;
    }

    private static JobOpportunity createJob() {
        JobOpportunity job = new JobOpportunity();
        job.setDateStartAnnounce(LocalDateTime.now());
        job.setPosition(Position.COOKER);
        return job;
    }
}
