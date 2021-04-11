package utils;

import commons.Constants;
import data.UserInfo;

import java.util.List;

public class UserInfoUtils {
    private static List<UserInfo> users;

    static {
        if (users == null) {
            users = JsonHelper.getDataAsList(Constants.USER_JSON_FILE, UserInfo.class);
        }
    }

    public static UserInfo getUserInfo(String userKey) {
        return users.stream()
                .filter(x -> x.getKey().equals(userKey))
                .findAny()
                .orElse(null);
    }
}
