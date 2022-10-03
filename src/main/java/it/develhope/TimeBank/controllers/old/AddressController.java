/*package it.develhope.TimeBank.controllers.old;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.model.entities.Address;
import it.develhope.TimeBank.repository.AddressRepository;
import it.develhope.TimeBank.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    private static Logger logger = LoggerFactory.getLogger(AddressController.class);

    @PostMapping("/create")
    @ApiOperation(value = "create", notes = "create an address")
    public ResponseEntity createAddress(@RequestBody Address address){
        try {
            logger.info("Create an address");
            return ResponseEntity.status(HttpStatus.OK).body(addressService.create(address));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{username}")
    @ApiOperation(value = "username", notes = "update a user")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Address address){
        try {
            logger.info("Update address info");
            return ResponseEntity.status(HttpStatus.OK).body(addressService.update(id,address));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get a single address")
    public ResponseEntity getSingleAddress(@PathVariable Long id){
        try {
            logger.info("Getting a single address");
            return ResponseEntity.status(HttpStatus.OK).body(addressService.getById(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get all address")
    public ResponseEntity getAllAddress(){
        try {
            logger.info("Getting all address");
            return ResponseEntity.status(HttpStatus.OK).body(addressService.getAll());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete an address")
    public ResponseEntity deleteBySingleId(@PathVariable Long id){
            try {
                logger.info("delete a single address");
                return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAddressById(id));
            }catch(Exception ex){
                logger.error(ex.toString());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
            }
        }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "deleteAll", notes = "delete all address")
    public ResponseEntity deleteAll(){
        try {
            logger.info("delete all address");
            return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAll());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
*/