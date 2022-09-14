package mx.com.Axity.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.Axity.commons.to.*;
import mx.com.Axity.services.facade.IInventoryFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("serviceorder/v1")
@Api(value="inventory")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IInventoryFacade IInventoryFacade;
    @Autowired
    private Environment env;

    @GetMapping(value = "/users", produces = "application/json")
    @ApiOperation(value = "Buscar Usuarios",
            notes = "Retorna todos los usuarios",
            response = UserTO.class,
            produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        List<UserTO> users = this.IInventoryFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/ping", produces = "application/json")
    @ApiOperation(value = "Ping",
            notes = "Pong",
            produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @GetMapping(value = "/mice", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<MouseTO>> getMouses() {
        LOG.info("Se invoca GET /mice" + env.getProperty("local.sever.port"));
        List<MouseTO> returnResponse = IInventoryFacade.getAllMice();
        return new ResponseEntity<List<MouseTO>>(returnResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/mouse/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MouseTO> getMouse(@PathVariable("id") long id) {
        LOG.info("Se invoca GET /mouse/" + id);
        MouseTO responseValue = new MouseTO();
        responseValue = IInventoryFacade.getMouseById((int) id);
        return new ResponseEntity<MouseTO>(responseValue, HttpStatus.OK);
    }

    //metodo post de las computadoras
    @PostMapping(value = "/computer", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
           MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResponseTO> createComputer(@RequestBody ComputerTO request) {
        LOG.info("Se invoca POST /computer");
        ResponseTO responseValue = IInventoryFacade.createComputer(request);
        return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.CREATED);
    }


    //Get por id de las ordenes
    @GetMapping(value = "/order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<OrderTO> getOrder(@PathVariable("id") long id) {
        LOG.info("Se invoca GET /order/" + id);
        OrderTO responseValue = new OrderTO();
        responseValue = IInventoryFacade.getOrderById(id);
        return new ResponseEntity<OrderTO>(responseValue, HttpStatus.OK);
    }

}
