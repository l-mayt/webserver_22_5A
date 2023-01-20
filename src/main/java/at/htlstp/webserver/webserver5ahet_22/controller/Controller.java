package at.htlstp.webserver.webserver5ahet_22.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Date;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("ping1")
    public String ping1() {
        return "pong mit POST";
    }

    @PostMapping("welcome2")
    public String welcome2( @RequestBody String id   ) {
        return "post: id" + id;
    }


    @GetMapping("welcome")
    public ResponseEntity welcome(@RequestParam String name) {
        Person p = new Person(name, "xyz", new Date(), "St. Pölten");
        return ResponseEntity.ok(p);
    }

    @GetMapping("welcome1")
    public String welcome1(@RequestParam String name) {
        Person p = new Person(name, "xyz", new Date(), "St. Pölten");
        return p.toString();
    }

    @RequestMapping("index")
    public String index(Model model) {
        return "index";
    }


}
