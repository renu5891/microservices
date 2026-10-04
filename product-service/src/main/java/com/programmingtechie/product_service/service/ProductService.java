package com.programmingtechie.product_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.dto.ProductResponse;
import com.programmingtechie.product_service.model.Product;
import com.programmingtechie.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductService.class);
	private final ProductRepository productRepository;

	public ProductResponse createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();

		Product savedProduct = productRepository.save(product);
		log.info("Product {} is saved", savedProduct.getId());
		return mapToProductResponse(savedProduct);
	}

	public List<ProductResponse> getAllProducts() {
		return productRepository.findAll().stream()
				.map(this::mapToProductResponse)
				.toList();
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
}