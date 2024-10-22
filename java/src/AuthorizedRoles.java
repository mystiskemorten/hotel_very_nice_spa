import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD})
public @interface AuthorizedRoles {
    Roles[] value();

    public enum Roles{
        USER,ADMIN;
    }
}
