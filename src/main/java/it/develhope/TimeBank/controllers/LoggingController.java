package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    // Inserisco i logger
    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/debug")
    public void getDebug(){
        logger.debug("This is a DEBUG logging");
    }

    // Mappo i service
    @GetMapping("/service")
    public String service(){
        logger.info("The service is working in controller");
        return loggingService.doService(5);
    }

    @GetMapping("/info")
    public void getInfo(){
        logger.info("This is a INFO logging");
    }

    @GetMapping("/warning")
    public void getWarning(){
        logger.warn("This is a WARNING logging");
    }

    @GetMapping("/errors")
    public void getErrors(){
        Error error = new Error("This is the error");
        logger.error("This is the ERROR logging", error);
    }
}