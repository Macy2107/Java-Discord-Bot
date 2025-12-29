package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class SlashCommand extends ListenerAdapter {

    public static void main(String[] args) throws IOException, InterruptedException {
        Properties properties = new Properties();
        // CONFIG THE TOKEN
        properties.load(new FileInputStream("token.properties"));
        // USING OOP AT PROPERTIES
        String token = properties.getProperty("BOT_TOKEN");
        JDA kittenBot = JDABuilder.createDefault(token)
                .addEventListeners(new SlashCommand())
                .setActivity(Activity.customStatus("When wiwiwi IDLE u able to use the SlashCommands"))
                .build().awaitReady();

        kittenBot.updateCommands().addCommands().queue();
        kittenBot.getPresence().setStatus(OnlineStatus.IDLE);
        kittenBot.getGatewayIntents();

//        MAKE NEW COMMANDS
        kittenBot.retrieveCommands().queue(

                (Collection<Command> commands) -> {
                    System.out.println(commands + "Hello" + Objects.requireNonNull(commands));
                }
        );
    }


    // USING HASHMAP AND CALL THE COMMANDS IN PSF TO PUBLIC IN OVERRIDE METHOD
    private static final Map<String, Consumer<SlashCommandInteractionEvent>> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("hi", event -> event.reply("hello uwu").queue());
        COMMANDS.put("who are you", event -> event.reply("It's wiwiwi").queue());
        COMMANDS.put("where", event -> event.reply("on Discord").queue());
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        String commandName = event.getName();

        Consumer<SlashCommandInteractionEvent> consumer = COMMANDS.get(commandName);

        if (consumer != null) {
            consumer.accept(event);
        } else {
            event.reply("404 command not found :<").queue();
        }

        if (event.getChannel().getName().equalsIgnoreCase("/hi")) {
            event.deferReply().queue();
            event.getHook().sendMessage("hihihii").queue();
        } else if (consumer == null) {
            event.getHook().sendMessage("hmmm").queue();
        } else {
            System.out.print("404 Command Line not found");
        }

    }
}



