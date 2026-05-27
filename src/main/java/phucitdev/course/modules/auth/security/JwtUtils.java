package phucitdev.course.modules.auth.security;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import phucitdev.course.commo.exception.auth.UnauthenticatedException;

import java.util.UUID;

@Component
public class JwtUtils {

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");

        if (bearer != null && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }

    public static CustomUserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof CustomUserDetails)) {
            throw new UnauthenticatedException();
        }

        return (CustomUserDetails) authentication.getPrincipal();
    }

    public static UUID getCurrentUserId() {
        return getCurrentUser().getAccount().getId();
    }
}