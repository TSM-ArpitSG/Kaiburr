// This class is the implementation of the ServerApi interface and serves as the entry point for the API requests.

package io.swagger.api;

import io.swagger.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServerApiController implements ServerApi {

    private final ServerService serverService;

    // Constructor injection of ServerService
    @Autowired
    public ServerApiController(ServerService serverService) {
        this.serverService = serverService;
    }

    // Endpoint for getting all servers
    @Override
    public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = serverService.getAllServers();
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    // Endpoint for getting a server by ID
    @Override
    public ResponseEntity<Server> getServerById(@PathVariable("serverId") Long serverId) {
        Server server = serverService.getServerById(serverId);
        if (server == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(server, HttpStatus.OK);
        }
    }

    // Endpoint for creating a server
    @Override
    public ResponseEntity<Void> createServer(@RequestBody Server server) {
        serverService.createServer(server);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint for updating a server
    // Not implemented in this version
    @Override
    public ResponseEntity<Void> updateServer(Long id, Server server) {
        return null;
    }

    // Endpoint for deleting a server by ID
    @Override
    public ResponseEntity<Void> deleteServer(@PathVariable("serverId") Long serverId) {
        if (serverService.deleteServer(serverId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint for finding servers by name
    @Override
    public ResponseEntity<List<Server>> findServersByName(@PathVariable("name") Long name) {
        List<Server> servers = serverService.findServersByName(String.valueOf(name));
        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(servers, HttpStatus.OK);
        }
    }

    // Endpoint for deleting a server by ID as a string
    @Override
    public ResponseEntity<Void> deleteServer(@PathVariable("serverId") String serverId) {
        if (serverService.deleteServer(Long.valueOf(serverId))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint for finding servers by name as a query parameter
    @Override
    public ResponseEntity<List<Server>> findServersByName(@PathVariable("name") String name) {
        List<Server> servers = serverService.findServersByName(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(servers, HttpStatus.OK);
        }
    }
}
//Code Written By @Arpit Singh - 19BCG10069