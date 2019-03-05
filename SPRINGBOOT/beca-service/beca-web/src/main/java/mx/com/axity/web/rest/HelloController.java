package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value="beca", description="Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IbecaFacade IbecaFacade;
    //METODO PARA CONSULTAR TODOS LOS REGISTROS EXISTENTES
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        LOG.info("Se invoca /users");
        List<UserTO> users = this.IbecaFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //METODO PARA COSNULTAR UN REGISTRO EN BASE A SU ID
    @RequestMapping(value = "/userid", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserTO> getIdUser(@RequestParam(value="id")int id) {
        LOG.info("Se invoca /userid");
        LOG.info(id);
        UserTO users = this.IbecaFacade.getIdUser(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //METODO PARA ELIMINAR UN REGISTRO EN BASE A SU ID
    @RequestMapping(value = "/userdelete", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserTO> deleteUser(@RequestParam(value="id")long id) {
        LOG.info("Se invoca /userdelete");
        LOG.info(id);
        this.IbecaFacade.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //METODO PARA ELIMINAR UN REGISTRO EN BASE A SU ID
    @RequestMapping(value = "/usersave", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<UserTO> insertUser(@RequestBody UserDO userDO) {
        LOG.info("Se invoca /insertuser");
        LOG.info(userDO);
        this.IbecaFacade.insertUser(userDO);
        return new ResponseEntity<>(HttpStatus.OK);

        /*{
        	"name":"BENIGNO",
	        "lastName":"ALVARADO",
	        "age":23
          }
        * */
    }

}
