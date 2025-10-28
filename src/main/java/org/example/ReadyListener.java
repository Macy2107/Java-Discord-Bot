package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReadyListener extends ListenerAdapter {

    /**
     * Runs the JDA bot with the given token.
     *
     * @param args the command line arguments
     * @throws InterruptedException if the thread is interrupted while waiting for the bot to become ready
     * @throws IOException if there is an IO error while reading the token from the file
     * @throws FunctorException if there is an error while creating the JDA instance
     */
    public static void main(String[] args) throws InterruptedException, IOException, FunctorException {
        Properties properties = new Properties();
        // CONFIG THE TOKEN
        properties.load(new FileInputStream("token.properties"));
        // USING OOP AT PROPERTIES
        String token = properties.getProperty("BOT_TOKEN");
        JDA kittenBot = JDABuilder.createDefault(token)
                .addEventListeners(new ReadyListener())
                .enableIntents(GatewayIntent.DIRECT_MESSAGES)
                .build();

        String spotify = properties.getProperty("MY_SPOTIFY");
        if (spotify.isEmpty()) {
            kittenBot.awaitReady();
            kittenBot.getPresence().setPresence(OnlineStatus.IDLE, Activity.playing("Spotify"));
        }
        // RUN THE API
        // OUTPUT
        kittenBot.awaitStatus(JDA.Status.CONNECTED);
        kittenBot.getGatewayIntents();
        kittenBot.awaitReady();

    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        // ADD NEW FILE
        // IF RIGHT FUNCTIONS BUT DID NOT WORK, TRY IF/ELSE OR TRY/CATCH METHOD
        if (event.getMessage().getContentRaw().startsWith("!wiwiwi")) {
            File catWiwiwi = new File("763289836879229217.jpeg");

            if (catWiwiwi.exists()) {
                FileUpload fileUpload = FileUpload.fromData(catWiwiwi);

                if (event.getAuthor().isBot()) return;
                event.getChannel().sendMessage("Wiwiwi is onReady, say hi to her...")
                        .addFiles(fileUpload)
                        .queue();

            } else if (!catWiwiwi.exists()) {
                System.out.println("Image not Found 404");

            } else {
                System.out.println("Bad respond, try again");
            }

        }

       }
}
