package com.enochcode.spring_boot_demo.seed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.enochcode.spring_boot_demo.entity.Product;
import com.enochcode.spring_boot_demo.entity.ProductImage;
import com.enochcode.spring_boot_demo.repository.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		if (productRepository.count() == 0) {
			List<Product> demoProducts = List.of(

					new Product(null, "Apple iPhone 15", 799.0, "Smartphone with a16 chip", "Phone", "Amazon", 5, 4.8,
							List.of(new ProductImage(null, "iphone15", "/products/1.jpg"))),

					new Product(null, "Samsung Galaxy S24", 699.0, "Premium Android smartphone", "Phone", "Amazon", 10,
							4.7, List.of(new ProductImage(null, "samsung", "/products/2.jpg"))),

					new Product(null, "OnePlus 12", 649.0, "Powerful smartphone with Snapdragon processor", "Phone",
							"Flipkart", 15, 4.6, List.of(new ProductImage(null, "oneplus", "/products/3.jpg"))),

					new Product(null, "MacBook Air M3", 1099.0, "Lightweight laptop with Apple M3 chip", "Laptop",
							"Apple", 8, 4.9, List.of(new ProductImage(null, "laptop", "/products/4.jpg"))),

					new Product(null, "Dell Inspiron 15", 749.0, "15-inch laptop for work and study", "Laptop", "Dell",
							12, 4.5, List.of(new ProductImage(null, "laptop", "/products/5.jpg"))),

					new Product(null, "Sony WH-1000XM5", 349.0, "Wireless noise cancelling headphones", "Headphones",
							"Amazon", 20, 4.8, List.of(new ProductImage(null, "Headphone", "/products/6.jpg"))),

					new Product(null, "Apple iPad Air", 599.0, "Powerful tablet for work and entertainment", "Tablet",
							"Apple", 7, 4.7, List.of(new ProductImage(null, "tablet", "/products/7.jpg"))),

					new Product(null, "Logitech MX Master 3S", 99.0, "Wireless ergonomic computer mouse", "Mouse",
							"Amazon", 25, 4.6, List.of(new ProductImage(null, "mouse", "/products/8.jpg"))),

					new Product(null, "Samsung 55 Inch 4K TV", 899.0, "Smart 4K UHD television", "TV", "Flipkart", 6,
							4.4, List.of(new ProductImage(null, "tv", "/products/9.jpg"))));
			
			productRepository.saveAll(demoProducts);
			System.out.println("Seeded demo products");
		} else {
			System.out.println(" Products already Exists skipping seeding")

			;

		}
	}
}
