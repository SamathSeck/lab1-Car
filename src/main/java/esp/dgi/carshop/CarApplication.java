package esp.dgi.carshop;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class CarApplication {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(CarApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
        logger.info("Car App started Goto http://localhost:8081/glsi_student_name");
    }
}

@RestController
@RequestMapping("/glsi_student_name")
class SbCarController {

    @Value("${fullname:Samath Seck}")
    private String fullname;

    @GetMapping
    String getFullname() {
        return "Work done by " + this.fullname + " !";
    }
}
