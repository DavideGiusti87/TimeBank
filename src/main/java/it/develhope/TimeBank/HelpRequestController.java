package it.develhope.TimeBank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelpRequestController {

    @GetMapping("/getAllRequests")
    public List<AnonymousRequest> getAllRequests() {
        List<AnonymousRequest> requests = new ArrayList<>();
        requests.add(new AnonymousRequest("Carlo", "Mi serve un passaggio"));
        requests.add(new AnonymousRequest("Mario", "Lavatrice rotta"));
        return requests;
    }

}