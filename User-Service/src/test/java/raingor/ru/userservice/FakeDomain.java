package raingor.ru.userservice;

import raingor.ru.userservice.domain.User;

public class FakeDomain {
    public static User getUser() {
        User fakeUser = new User();
        fakeUser.setId(1L);
        fakeUser.setUsername("fakeUser");
        fakeUser.setEmail("fakeUser@gmail.com");
        return fakeUser;
    }
}
