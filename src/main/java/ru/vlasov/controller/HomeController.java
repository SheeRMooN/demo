//package ru.vlasov.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.vlasov.service.RecordService;
//import ru.vlasov.service.UserService;
//
//@RestController
//@RequestMapping("/")
//public class HomeController {
//    @Autowired
//    RecordService recordService ;
//    @Autowired
//    UserService userService;
//
//    @GetMapping
//    public ResponseEntity outAll(){
//        return ResponseEntity.ok(userService.getAllUser());
//    }
//}
