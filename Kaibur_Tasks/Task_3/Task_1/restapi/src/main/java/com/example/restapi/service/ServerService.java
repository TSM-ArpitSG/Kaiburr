package com.example.restapi.service;

import java.util.List;
import java.util.Optional;

import com.example.restapi.model.Server;
import com.example.restapi.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerService {
    /**
     * This is the repository instance for server operations.
     */
    private final ServerRepository serverRepository;

    /**
     * Constructor for ServerService, used for dependency injection.
     * @param serverRepository The repository instance for server operations.
     */
    @Autowired
    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    /**
     * Returns all servers from the repository.
     * @return A list of all servers in the repository.
     */
    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    /**
     * Returns the server with the given ID from the repository.
     * @param id The ID of the server to retrieve.
     * @return An Optional containing the server with the given ID, or an empty Optional if no such server exists.
     */
    public Optional<Server> getServerById(String id) {
        return serverRepository.findById(id);
    }

    /**
     * Creates a new server in the repository.
     * @param server The server to create.
     * @return The created server.
     */
    public Server createServer(Server server) {
        return serverRepository.save(server);
    }

    /**
     * Deletes the server with the given ID from the repository.
     * @param id The ID of the server to delete.
     */
    public void deleteServer(String id) {
        serverRepository.deleteById(id);
    }

    /**
     * Returns all servers in the repository whose name contains the given string.
     * @param name The string to search for in server names.
     * @return A list of all servers in the repository whose name contains the given string.
     */
    public List<Server> getServersByName(String name) {
        return serverRepository.findByNameContaining(name);
    }

}
//Code Written By @Arpit Singh - 19BCG10069