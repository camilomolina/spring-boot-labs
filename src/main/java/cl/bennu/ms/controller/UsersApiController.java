package cl.bennu.ms.controller;

import cl.bennu.ms.api.UsersApi;
import cl.bennu.ms.objects.InlineResponse200;
import cl.bennu.ms.objects.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
public class UsersApiController implements UsersApi {

    private static List<User> userList = new ArrayList<>();
    private static long index = 1L;
    static {
        User data = new User();
        data.setId(index++);
        data.setName("Camilo");
        data.setLastname("Molina");
        data.setDate(new Date());
        data.setDesc(".");
        userList.add(data);

        data = new User();
        data.setId(index++);
        data.setName("Tania");
        data.setLastname("Molina");
        data.setDate(new Date());
        data.setDesc(".");
        userList.add(data);

        data = new User();
        data.setId(index++);
        data.setName("Otro");
        data.setLastname("Otro");
        data.setDate(new Date());
        data.setDesc(".");
        userList.add(data);

        data = new User();
        data.setId(index++);
        data.setName("Otro 2");
        data.setLastname("Otro 2");
        data.setDate(new Date());
        data.setDesc(".");
        userList.add(data);
    }

    public ResponseEntity<List> getAll() {
        return new ResponseEntity<List>(userList, HttpStatus.OK);
    }

    private User find(Long id) {
        for (User user : userList) {
            if (user.getId().equals(id)) return user;
        }
        return null;
    }

    public ResponseEntity<InlineResponse200> delete(@PathVariable("id") BigDecimal id) {
        User user = find(id.longValue());
        userList.remove(user);
        return new ResponseEntity<>(new InlineResponse200(), HttpStatus.OK);
    }

    public ResponseEntity<User> getById(@PathVariable("id") BigDecimal id) {
        User user = find(id.longValue());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> update(@RequestBody User user) {
        User userTmp = find(user.getId());
        userTmp.setName(user.getName());
        userTmp.setLastname(user.getLastname());
        userTmp.setDesc(user.getDesc());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> save(@RequestBody User user, HttpServletRequest request) {
        user.setId(index++);
        userList.add(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
