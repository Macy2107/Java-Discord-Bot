package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MessageListener extends ListenerAdapter {
    public static void main(String[] args) throws  InterruptedException, IOException {
        Properties properties = new Properties();
        // CONFIG THE TOKEN
        properties.load(new FileInputStream("token.properties"));
        // USING OOP AT PROPERTIES
        String token = properties.getProperty("BOT_TOKEN");
        JDA kittenBot = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new MessageListener()) // THIS PART DETERMINES THE BOT CAN SEND THE MESSAGE BACK
                .build();

        kittenBot.getPresence().setStatus(OnlineStatus.ONLINE);
        kittenBot.awaitReady();
        kittenBot.getGuildById("1256641053197336651");
    }

    // GET MESSAGE
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        // LIBRARY SHOULD BE PUTTED NEXT
        if (event.getAuthor().isBot()) return;

        String messageSent = event.getMessage().getContentRaw();

        if (messageSent.equalsIgnoreCase("hi"))   {
            event.getChannel().sendMessage("https://media.tenor.com/soXZkSzdkmIAAAAM/hello-shy.gif\n"+"hello uwu\n" + "It's wiwiwi\n" + "How are uu ?\n").queue();
        }

        if (messageSent.equalsIgnoreCase("I'm good")) {
            event.getChannel().sendMessage("That's gutt to hear my pookie\n" + "May I know ur name ??\n" + "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgViLr1lGxRzUWXLQDeN9mAhweN442MdNLSA&s").queue();
        }
        if (messageSent.equalsIgnoreCase("I'm not good")) {
            event.getChannel().sendMessage("I know sometimes life is hard, but this lil witch cat can help uu\n" + "https://media.tenor.com/TE0SSx9hndUAAAAM/wizardcat-magicmeow.gif" ).queue();
        }
        if (messageSent.equalsIgnoreCase("huhu"))  {
            event.getChannel().sendMessage("huhuhuhu\n" + "What's wrong with uu uwu ??").queue();
        }

        if (messageSent.equalsIgnoreCase("hehe")) {
            event.getChannel().sendMessage("heheheheehehe").queue();
        }

        if (messageSent.equalsIgnoreCase("wiwiwi")) {
            event.getChannel().sendMessage("wiwiwi\n" + "https://media.tenor.com/G3lM9_qGe9IAAAAe/wiwiwi-cat-kitty.png" ).queue();
        }

        if (messageSent.equalsIgnoreCase("Good morning wiwiwi")) {
            event.getChannel().sendMessage("wiwiwiwi\n" + "gutt morningg\n" + "https://media.tenor.com/KxmtSyfP1tQAAAAM/cat-cute.gif").queue();
        }

        if (messageSent.equalsIgnoreCase("Good night wiwiwi")) {
            event.getChannel().sendMessage("Gutt night uwu\n" + "https://media.tenor.com/m_N0DEoKEhwAAAAM/funny-animals-good-night.gif").queue();
        }

        if (messageSent.equalsIgnoreCase("wyd")) {
            event.getChannel().sendMessage("uwu nothingg, I'm looking at the beautiful face thru this screen\n" + "https://i.pinimg.com/736x/26/6e/3f/266e3f3b18bf682a9ada0900d3ac7f29.jpg").queue();
        }

        if (messageSent.equalsIgnoreCase("Thank you")) {
            event.getChannel().sendMessage("No problem uwu\n" + "https://media.tenor.com/_UaFpyE0SPYAAAAM/praying-cat.gif").queue();
        }

        if (messageSent.toLowerCase().isBlank()) {
            event.getChannel().sendMessage("heh ??").queue();
        }
    }
}



