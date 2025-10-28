package org.example;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// SET UP BOT
// RUNNING THE MAIN METHOD
public class DiscordBot extends ListenerAdapter {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        // CONFIG THE TOKEN
        properties.load(new FileInputStream("token.properties"));
        // USING OOP AT PROPERTIES
        String token = properties.getProperty("BOT_TOKEN");
        JDA kittenBot = JDABuilder.createDefault(token)
                .setActivity(Activity.customStatus("Welcome to WiWiWi uwu\n" + " ≽^• ˕ • ྀི≼ "))
                        .addEventListeners(new DiscordBot())
                                .build();


        kittenBot.getPresence().setStatus(OnlineStatus.ONLINE);
        kittenBot.setAutoReconnect(true);
        kittenBot.getGatewayIntents();
        kittenBot.getScheduledEventCache();

    }
}