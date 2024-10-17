package com.github.thepalma.spend_sage.service.auth;

import com.github.thepalma.spend_sage.dto.AuthenticationRequest;
import com.github.thepalma.spend_sage.dto.AuthenticationResponse;
import com.github.thepalma.spend_sage.dto.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
