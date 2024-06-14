package com.algafood.oauth2.core.security.authorizationserver;

import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

public class JdbcOAuth2AuthorizationQueryService implements OAuth2AuthorizationQueryService {

    private final JdbcOperations jdbcOperations;
    private final RowMapper<RegisteredClient> registeredClientMapper;
    private final RowMapper<OAuth2Authorization> oauth2AuthorizationRowMapper;

    private final String LIST_AUTHORIZED_CLIENTS = "select rc.* from oauth2_authorization_consent c " +
            "inner join oauth2_registered_client rc on rc.id = c.registered_client_id " +
            "where c.principal_name = ? ";

    private final String LIST_AUTHORIZATIONS_QUERY = "select * from oauth2_authorization a " +
            "inner join oauth2_registered_client c on c.id = a.registered_client_id " +
            "where a.principal_name = ? " +
            "and c.client_id = ? ";

    public JdbcOAuth2AuthorizationQueryService(
            JdbcOperations jdbcOperations,
            RegisteredClientRepository repository) {

        this.jdbcOperations = jdbcOperations;
        this.registeredClientMapper = new JdbcRegisteredClientRepository.RegisteredClientRowMapper();
        this.oauth2AuthorizationRowMapper = new JdbcOAuth2AuthorizationService.OAuth2AuthorizationRowMapper(repository);
    }

    @Override
    public List<RegisteredClient> listClientsWithConsent(String principalName) {
        
        return this.jdbcOperations.query(
                LIST_AUTHORIZED_CLIENTS,
                registeredClientMapper,
                principalName);
    }

    @Override
    public List<OAuth2Authorization> listAuthorizations(String principalName, String clientId) {
        return this.jdbcOperations.query(
                LIST_AUTHORIZATIONS_QUERY,
                oauth2AuthorizationRowMapper,
                principalName,
                clientId);
    }

}
