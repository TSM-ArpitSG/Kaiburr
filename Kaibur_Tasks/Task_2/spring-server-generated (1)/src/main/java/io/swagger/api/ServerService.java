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

    /**
     * Retrieve all servers from the repository.
     *
     * @return List of all Server objects
     */
    public List<Server> getAllServers() {
        return serverRepository.getAllServers();
    }

    /**
     * Retrieve a server by its ID from the repository.
     *
     * @param id The ID of the Server to retrieve
     * @return The Server object corresponding to the given ID
     * @throws ResponseStatusException if no server with the given ID is found
     */
    public Server getServerById(Long id) {
        Optional<Server> optionalServer = serverRepository.getServerById(String.valueOf(id));
        if (optionalServer.isPresent()) {
            return optionalServer.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server not found");
        }
    }

    /**
     * Create a new server in the repository.
     *
     * @param server The Server object to create
     * @return The created Server object
     */
    public Server createServer(Server server) {
        return serverRepository.saveServer(server);
    }

// This method has been commented out as it is not implemented


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

    /**
     * Delete a server by its ID from the repository.
     *
     * @param id The ID of the Server to delete
     * @return true if the Server is successfully deleted, false otherwise
     * @throws ResponseStatusException if no server with the given ID is found
     */
    public boolean deleteServer(Long id) {
        Optional<Server> optionalServer = serverRepository.getServerById(String.valueOf(id));
        if (optionalServer.isPresent()) {
            serverRepository.deleteServer(String.valueOf(id));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server not found");
        }
        return false;
    }

    /**
     * Retrieve all servers from the repository with a given name.
     *
     * @param name The name to search for
     * @return List of all Server objects with the given name
     */
    public List<Server> findServersByName(String name) {
        return serverRepository.findServersByName(name);
    }
}
//Code Written By @Arpit Singh - 19BCG10069