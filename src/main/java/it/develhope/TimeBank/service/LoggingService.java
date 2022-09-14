package it.develhope.TimeBank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    // Inserisco i logger
    Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public String doService(int numberOfService){
        try {  // Inserisco try/finally per loggare sempre quando entro e esco da un metodo.
            logger.info("Starting logging service - Number of service: "
                    + numberOfService);
            // [...] - Inserisco la logica
            return "Greetings";
        }finally {
            logger.info("Ending logging service");
        }
    }
}
