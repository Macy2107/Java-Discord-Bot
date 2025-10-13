package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReadyListener extends ListenerAdapter {
    public static void main(String[] args) throws InterruptedException{
        JDA kittenBot = JDABuilder.createDefault("MTQyNzEzMzk1ODczODU0Mjc1Mw.Gv-9_X.2ETsAOoSSQpdaSg-e-ETEf2CVkTovc2m92vN5k")
                .addEventListeners(new ReadyListener())
                .build();

        // RUN THE API
        // OUTPUT
        kittenBot.awaitStatus(JDA.Status.CONNECTED);
        kittenBot.getGatewayIntents();
        kittenBot.awaitReady();

    }
       @Override
               public void messageListener(@NotNull MessageReceivedEvent event)
       {

       }
}
