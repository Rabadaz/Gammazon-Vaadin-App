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
    public static boolean isLoggedIn(){
        var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user instanceof CustomUserPrincipal;
    }
    public static boolean hasPermission(String permission){
        var principle = getUserPrinciple();
        if(principle == null)
            return false;
        return principle.getAuthorities().stream().map(a -> a.getAuthority().equals(permission)).count() != 0;

    }

}
