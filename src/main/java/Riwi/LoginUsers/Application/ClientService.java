package Riwi.LoginUsers.Application;

import Riwi.LoginUsers.Domain.Model.Client;
import Riwi.LoginUsers.Infraestructure.Adapter.Request.ClientRequest;
import Riwi.LoginUsers.Infraestructure.Adapter.Request.ClientUpdateRequest;
import Riwi.LoginUsers.Infraestructure.Adapter.Response.ClientResponse;
import Riwi.LoginUsers.Infraestructure.Persistence.Repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ModelMapper modelMapper;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ModelMapper modelMapper, ClientRepository clientRepository) {
        this.modelMapper = modelMapper;
        this.clientRepository = clientRepository;
    }

    public ClientResponse createClient(ClientRequest request) {
        Client client = modelMapper.map(request, Client.class);
        Client savedClient = clientRepository.save(client);
        return modelMapper.map(savedClient, ClientResponse.class);
    }

    public List<ClientResponse> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientResponse.class))
                .collect(Collectors.toList());
    }

    public ClientResponse updateClient(int id, ClientUpdateRequest request) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        modelMapper.map(request, client);
        Client updatedClient = clientRepository.save(client);
        return modelMapper.map(updatedClient, ClientResponse.class);
    }

    public void deleteClient(int id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found");
        }
        clientRepository.deleteById(id);
    }
}
