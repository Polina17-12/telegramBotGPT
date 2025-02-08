package com.example.demoprojet;

import com.example.demoprojet.bot.JavaTelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfig {

    @Bean
    public BotSession telegramBotsApi(JavaTelegramBot bot ) throws TelegramApiException {

        return new TelegramBotsApi(DefaultBotSession.class).registerBot(bot);
    }
}
