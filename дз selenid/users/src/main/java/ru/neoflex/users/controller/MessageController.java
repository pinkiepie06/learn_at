package ru.neoflex.users.controller;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.users.exceptions.NotFoundExceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class MessageController {
    private int count = 4;
    private List<Map<String, String>> users = new ArrayList<Map<String, String>>(){{
        add(new HashMap<String, String>() {{ put("id", "1"); put("user", "Hero Batman");}});
        add(new HashMap<String, String>() {{ put("id", "2"); put("user", "Woman Supergirl");}});
        add(new HashMap<String, String>() {{ put("id", "3"); put("user", "Donald Duck");}});
    }};
    @GetMapping
    public List<Map<String, String>> list() {
        return users;
    }

    @GetMapping("{id}")
    public  Map<String, String> getOne(@PathVariable String id) {
        return getUser(id);
    }

    private Map<String, String> getUser(@PathVariable String id) {
        return users.stream()
                .filter(messages -> messages.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundExceptions::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> user) {
        user.put("id", String.valueOf(count++));
        users.add(user);
        return user;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> user) {
        Map<String, String> userFromDb = getUser(user.get("id"));
        userFromDb.putAll(user);
        userFromDb.put("id", id);
        return userFromDb;
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable String id) {
        Map<String, String> user = getUser(id);
        users.remove(user);
    }
}
