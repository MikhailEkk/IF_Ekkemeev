package ru.iFellow.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface AppConfig extends Config {

    @Key("page.load.timeout")
    long pageLoadTimeout();

    @Key("base.url")
    String baseUrl();

    @Key("end.point.login")
    String endPointLogin();

    @Key("user.password")
    String password();

    @Key("user.login")
    String login();
}
