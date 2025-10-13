package org.example;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

// SET UP BOT
// RUNNING THE MAIN METHOD
public class DiscordBot {
    public static void main(String[] args) throws LoginException {
        JDA kittenBot = JDABuilder.createDefault("MTQyNzEzMzk1ODczODU0Mjc1Mw.Gv-9_X.2ETsAOoSSQpdaSg-e-ETEf2CVkTovc2m92vN5k")
                                  .setActivity(Activity.customStatus("Welcome to WiWiWi uwu"))
                                  .build();

        kittenBot.getPresence().setStatus(OnlineStatus.ONLINE);
        kittenBot.setAutoReconnect(true);
        kittenBot.getGatewayIntents();
        kittenBot.getScheduledEventCache();

    }
}