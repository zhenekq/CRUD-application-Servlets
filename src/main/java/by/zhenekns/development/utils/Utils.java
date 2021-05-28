package by.zhenekns.development.utils;

import by.zhenekns.development.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Utils {
    public static boolean idIsNumber(HttpServletRequest request) {
        final String id = request.getParameter("id");
        return id != null &&
                (id.length() > 0) &&
                id.matches("[+]?\\d+");
    }

    public static boolean requestIsValid(HttpServletRequest request) {
        final String name = request.getParameter("name");
        final String age = request.getParameter("age");

        return name != null && name.length() > 0 &&
                age != null && age.length() > 0 &&
                age.matches("[+]?\\d+");
    }

    public static User createStubUser(final int id,
                                      final String name,
                                      final int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }

    public static boolean idIsInvalid(final String id, Map<Integer, User> repo) {
        return !(id != null &&
                id.matches("[+]?\\d+") &&
                repo.get(Integer.parseInt(id)) != null);
    }
}
