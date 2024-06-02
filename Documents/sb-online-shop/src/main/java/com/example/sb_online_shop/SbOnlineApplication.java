package com.example.sb_online_shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.sb_online_shop.domain.Custemer;
import com.example.sb_online_shop.domain.CustemerRepository;
import com.example.sb_online_shop.domain.Item;
import com.example.sb_online_shop.domain.ItemRepository;
import com.example.sb_online_shop.domain.Order;
import com.example.sb_online_shop.domain.OrderRepository;
import com.example.sb_online_shop.domain.Products;
import com.example.sb_online_shop.domain.ProductsRepository;

@SpringBootApplication
public class SbOnlineApplication {

    private static final Logger logger = LoggerFactory.getLogger(SbOnlineApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SbOnlineApplication.class, args);
        logger.info("Online Shop started at http://localhost:8080/");
    }

    @Bean
    public CommandLineRunner demo(CustemerRepository crepository, OrderRepository orepository, ProductsRepository prepository, ItemRepository irepository) {
        return (args) -> {
            Custemer c1 = new Custemer("Bugs Bunny","bunny@gmail.com", "passer123", "acteur", 59000);
            Custemer c2 = new Custemer("Daffy Duck","Daffy@gmail.com", "passer123", "acteur", 37000);
            Custemer c3 = new Custemer("Porky Pig", "pig@gmail.com", "passer123", "acteur", 28000);
            crepository.saveAll(Arrays.asList(c1, c2, c3));

            Products p1 = new Products(1, "Laptop", "A high-end laptop", "laptop.png", 1500, new Date(), new Date(), null);
            Products p2 = new Products(2, "Phone", "A new smartphone", "phone.png", 800, new Date(), new Date(), null);
            Products p3 = new Products(3, "Tablet", "A powerful tablet", "tablet.png", 600, new Date(), new Date(), null);
            prepository.saveAll(Arrays.asList(p1, p2, p3));

            Order o1 = new Order(1, 100, new Date(), new Date(), c1, new ArrayList<>());
            Order o2 = new Order(2, 300, new Date(), new Date(), c1, new ArrayList<>());
            Order o3 = new Order(3, 200, new Date(), new Date(), c2, new ArrayList<>());
            Order o4 = new Order(4, 140, new Date(), new Date(), c3, new ArrayList<>());
            orepository.saveAll(Arrays.asList(o1, o2, o3, o4));

            Item i1 = new Item(new Date(), 1, o1, 1500, p1, 1, new Date());
            Item i2 = new Item(new Date(), 2, o2, 1600, p1, 2, new Date());
            Item i3 = new Item(new Date(), 3, o3, 800, p2, 1, new Date());
            Item i4 = new Item(new Date(), 4, o4, 600, p3, 1, new Date());
            irepository.saveAll(Arrays.asList(i1, i2, i3, i4));

            logger.info("----- All Orders ------");
            orepository.findAll().forEach(order -> {
                logger.info("Order: " + order.getCustemer().getName() + " - " + order.getTotal() + "$");
            });
            logger.info("----- End of Orders ------");
        };
    }
}
