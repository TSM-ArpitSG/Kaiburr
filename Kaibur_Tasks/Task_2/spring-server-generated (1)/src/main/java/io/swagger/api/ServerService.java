package io.swagger.api;

import io.swagger.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<Server> getAllServers() {
        return serverRepository.getAllServers();
    }

    public Server getServerById(Long id) {
        Optional<Server> optionalServer = serverRepository.getServerById(String.valueOf(id));
        if (optionalServer.isPresent()) {
            return optionalServer.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server not found");
        }
    }

    public Server createServer(Server server) {
        return serverRepository.saveServer(server);
    }

//    public boolean updateServer(Long id, Server server) {
//        Optional<Server> optionalServer = serverRepository.findById(id);
//        if (optionalServer.isPresent()) {
//            Server existingServer = optionalServer.get();
//            existingServer.setName(server.getName());
//            existingServer.setDescription(server.getDescription());
//            existingServer.setIpAddress(server.getIpAddress());
//            return serverRepository.save(existingServer);
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server not found");
//        }
//    }

    public boolean deleteServer(Long id) {
        Optional<Server> optionalServer = serverRepository.getServerById(String.valueOf(id));
        if (optionalServer.isPresent()) {
            serverRepository.deleteServer(String.valueOf(id));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server not found");
        }
        return false;
    }

    public List<Server> findServersByName(String name) {
        return serverRepository.findServersByName(name);
    }
}
