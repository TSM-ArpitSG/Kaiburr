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

    @Autowired
    public ServerApiController(ServerService serverService) {
        this.serverService = serverService;
    }

    @Override
    public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = serverService.getAllServers();
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Server> getServerById(@PathVariable("serverId") Long serverId) {
        Server server = serverService.getServerById(serverId);
        if (server == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(server, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Void> createServer(@RequestBody Server server) {
        serverService.createServer(server);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateServer(Long id, Server server) {
        return null;
    }

//    @Override
//    public ResponseEntity<Void> updateServer(@PathVariable("serverId") Long serverId, @RequestBody Server server) {
//        if (serverService.updateServer(serverId, server)) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @Override
    public ResponseEntity<Void> deleteServer(@PathVariable("serverId") Long serverId) {
        if (serverService.deleteServer(serverId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Server>> findServersByName(@PathVariable("name") Long name) {
        List<Server> servers = serverService.findServersByName(String.valueOf(name));
        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(servers, HttpStatus.OK);
        }
    }



//    @Override
//    public ResponseEntity<Void> updateServer(@PathVariable("serverId") Long serverId, @RequestBody Server server) {
//        if (serverService.updateServer(serverId, server)) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @Override
    public ResponseEntity<Void> deleteServer(@PathVariable("serverId") String serverId) {
        if (serverService.deleteServer(Long.valueOf(serverId))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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
