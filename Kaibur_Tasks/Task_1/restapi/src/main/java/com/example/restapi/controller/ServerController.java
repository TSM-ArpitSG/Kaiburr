package com.example.restapi.controller;

import com.example.restapi.model.Server;
import com.example.restapi.service.ServerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servers")
@CrossOrigin(origins = "http://localhost:3000")
public class ServerController {

    private final ServerService serverService;
    /**
     * Constructor that injects the ServerService instance into the controller.
     * @param serverService The ServerService instance to be injected.
     */
    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    /**
     * Handles GET requests for retrieving all servers.
     * @return A list of all servers.
     */
    @GetMapping
    public List<Server> getAllServers() {
        return serverService.getAllServers();
    }

    /**
     * Handles GET requests for retrieving a server by ID.
     * @param id The ID of the server to retrieve.
     * @return The server with the specified ID, or a 404 Not Found response if the server does not exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Server> getServerById(@PathVariable String id) {
        Optional<Server> server = serverService.getServerById(id);
        if (server.isPresent()) {
            return ResponseEntity.ok(server.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Handles POST requests for creating a new server.
     * @param server The server to create.
     * @return A 201 Created response with the created server in the response body and a Location header pointing to the new resource.
     */
    @PostMapping
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server createdServer = serverService.createServer(server);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdServer.getId()).toUri();
        return ResponseEntity.created(location).body(createdServer);
    }

    /**
     * Handles DELETE requests for deleting a server by ID.
     * @param id The ID of the server to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteServer(@PathVariable String id) {
        serverService.deleteServer(id);
    }

    /**
     * Handles GET requests for searching servers by name.
     * @param name The name to search for.
     * @return A list of servers with names containing the search term.
     */
    @GetMapping("/search")
    public List<Server> getServersByName(@RequestParam("name") String name) {
        return serverService.getServersByName(name);
    }
}
//Code Written By @Arpit Singh - 19BCG10069