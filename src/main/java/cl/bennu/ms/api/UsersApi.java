package cl.bennu.ms.api;

import cl.bennu.ms.objects.InlineResponse200;
import cl.bennu.ms.objects.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public interface UsersApi {

    String BASE_URI = "/users";

    @RequestMapping(value = BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity getAll();

    @RequestMapping(value = BASE_URI + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    ResponseEntity<InlineResponse200> delete(@PathVariable("id") BigDecimal id);

    @RequestMapping(value = BASE_URI + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<User> getById(@PathVariable("id") BigDecimal id);

    @RequestMapping(value = BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    ResponseEntity<User> update(@RequestBody User user);

    @RequestMapping(value = BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    ResponseEntity<User> save(@RequestBody User user, HttpServletRequest request);

}