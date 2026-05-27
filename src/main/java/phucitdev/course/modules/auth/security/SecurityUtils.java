package phucitdev.course.modules.auth.security;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static phucitdev.course.modules.auth.entity.Account getCurrentAccount() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if (principal instanceof CustomUserDetails userDetails) {
            return userDetails.getAccount();
        }

        throw new RuntimeException("Account not authenticated");
    }
}