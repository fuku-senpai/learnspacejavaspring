package phucitdev.course.modules.auth.service;

import phucitdev.course.modules.auth.dto.*;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
    RefreshTokenResponse refreshToken(RefreshTokenRequest request);
    void logoutOfSystem(LogoutRequest logoutRequest);
}
