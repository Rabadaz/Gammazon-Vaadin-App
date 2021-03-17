package at.scheuchi.Gammazon.Util;

import at.scheuchi.Gammazon.Security.DatabaseUserStorage.CustomUserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {
    public static CustomUserPrincipal getUserPrinciple(){
        var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof CustomUserPrincipal)
            return (CustomUserPrincipal) user;
        return null;
    }
}
