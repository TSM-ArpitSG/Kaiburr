package io.swagger.api;

import io.swagger.model.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-24T08:25:22.119Z[GMT]")
public interface ServerApi {

    @GetMapping(value="/servers", produces={"application/json"})
    ResponseEntity<List<Server>> getAllServers();

    @GetMapping(value="/servers/{id}", produces={"application/json"})
    ResponseEntity<Server> getServerById(@PathVariable("id") Long id);

    @PostMapping(value="/servers", produces={"application/json"}, consumes={"application/json"})
    ResponseEntity<Void> createServer(@Valid @RequestBody Server server);

    @PutMapping(value="/servers/{id}", produces={"application/json"}, consumes={"application/json"})
    ResponseEntity<Void> updateServer(@PathVariable("id") Long id, @Valid @RequestBody Server server);

    @DeleteMapping(value="/servers/{id}", produces={"application/json"})
    ResponseEntity<Void> deleteServer(@PathVariable("id") Long id);

    ResponseEntity<List<Server>> findServersByName(@PathVariable("name") Long name);

    ResponseEntity<Void> deleteServer(@PathVariable("serverId") String serverId);

    @GetMapping(value="/servers/findByName", produces={"application/json"})
    ResponseEntity<List<Server>> findServersByName(@RequestParam("name") String name);
}
