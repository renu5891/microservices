// package com.programming.techie.apigateway;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// @SpringBootApplication
// @EnableDiscoveryClient
// public class ApiGatewayApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(ApiGatewayApplication.class, args);
//     }

// }

// // ...existing code...


// // import org.springframework.boot.SpringApplication;
// // import org.springframework.boot.autoconfigure.SpringBootApplication;
// // import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// // @SpringBootApplication
// // @EnableDiscoveryClient
// // public class ApiGatewayApplication {

// //     public static void main(String[] args) {
// //         SpringApplication.run(ApiGatewayApplication.class, args);
// //     }
// // }
// // // ...existing code...

package com.programming.techie.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}