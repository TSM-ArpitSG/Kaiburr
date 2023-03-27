package io.swagger.api;

import io.swagger.model.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-24T08:25:22.119Z[GMT]")
public interface ServerApi {
    /*
    This endpoint returns all servers in the database.
    */
    @GetMapping(value="/servers", produces={"application/json"})
    ResponseEntity<List<Server>> getAllServers();

    /*
    This endpoint returns a single server with the specified id.
    If the server is not found, it returns 404.
    */
    @GetMapping(value="/servers/{id}", produces={"application/json"})
    ResponseEntity<Server> getServerById(@PathVariable("id") Long id);

    /*
    This endpoint creates a new server in the database.
    It takes a Server object as input in JSON format.
    */
    @PostMapping(value="/servers", produces={"application/json"}, consumes={"application/json"})
    ResponseEntity<Void> createServer(@Valid @RequestBody Server server);

    /*
    This endpoint updates an existing server in the database with the specified id.
    It takes a Server object as input in JSON format.
    If the server is not found, it returns 404.
    */
    @PutMapping(value="/servers/{id}", produces={"application/json"}, consumes={"application/json"})
    ResponseEntity<Void> updateServer(@PathVariable("id") Long id, @Valid @RequestBody Server server);

    /*
    This endpoint deletes an existing server from the database with the specified id.
    If the server is not found, it returns 404.
    */
    @DeleteMapping(value="/servers/{id}", produces={"application/json"})
    ResponseEntity<Void> deleteServer(@PathVariable("id") Long id);

    ResponseEntity<List<Server>> findServersByName(@PathVariable("name") Long name);

    ResponseEntity<Void> deleteServer(@PathVariable("serverId") String serverId);

    /*
            This endpoint returns all servers whose name contains the specified string.
            If no servers are found, it returns 404.
            */
    @GetMapping(value="/servers/findByName", produces={"application/json"})
    ResponseEntity<List<Server>> findServersByName(@RequestParam("name") String name);

}
//Code Written By @Arpit Singh - 19BCG10069