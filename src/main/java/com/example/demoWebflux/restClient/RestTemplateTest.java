//package com.example.demoWebflux.restClient;
//
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @author bo.yang
// */
//public class RestTemplateTest {
//    public static void main(String[] args){
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = null;
//        try {
//
//             responseEntity = restTemplate
//                .postForEntity("http://127.0.0.1:12312/test/recive2", "12345", String.class);
//        } catch (Exception e) {
//            System.out.println("failed  ...............");
//            e.printStackTrace();
//        }
//        if (responseEntity.getStatusCode() == HttpStatus.OK){
//            System.out.println("ok .......");
//        } else {
//           System.out.println("failed  ...............");
//        }
//    }
//}
