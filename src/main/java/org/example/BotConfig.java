package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.util.Properties;

public class BotConfig extends ListenerAdapter {
    public static void main(String[] args) throws Exception, LoginException {
        Properties properties = new Properties();
        // CONFIG THE TOKEN
        properties.load(new FileInputStream("token.properties"));
        // USING OOP AT PROPERTIES
        String token = properties.getProperty("BOT_TOKEN");

        JDA kittenBot = JDABuilder.createDefault(token)
                .addEventListeners(new BotConfig())
                .build();

        kittenBot.getPresence().setStatus(OnlineStatus.ONLINE);

        if (token == null || token.isEmpty()) {
            System.out.println("Error: In token configuration");
            return;
        }
    }
}

