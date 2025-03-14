package com.example.demoprojet.bot;

import com.example.demoprojet.DeepSeekRequester;
import com.example.demoprojet.db.DBInteractor;
import com.example.demoprojet.db.DBInteractorStub;
import com.example.demoprojet.dto.DBUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class JavaTelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final DeepSeekRequester requester;

    private DBInteractor db;

    public JavaTelegramBot(DeepSeekRequester requester, DBInteractor db) {
        super();
        this.requester = requester;
        this.db = db;
    }



    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = requester.askNetwork(update.getMessage().getText().trim());;
            String chatId = update.getMessage().getChatId().toString();

            DBUserInfo userInfo = new DBUserInfo();
            userInfo.setText(message);
            userInfo.setUsernameID(Long.parseLong(chatId));
            db.put(userInfo);
//            System.out.println(db.getById(userInfo.getId()).getDateTime());


            SendMessage sm = new SendMessage();
            sm.enableMarkdown(true);
            sm.setChatId(chatId);
            sm.setText(message);
            //SetButtons.setButtons(sm);
            SetButtons.setInline(sm);
            //sm.setText(message);
            try {
                execute(sm);
            } catch (TelegramApiException e) {

                e.printStackTrace();
            }
        }
        else  if(update.hasCallbackQuery()) {

            String call_data = update.getCallbackQuery().getData();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            String path = "https://stihi.ru/pics/2022/10/03/476.jpg";
            SendMessage sm = new SendMessage();
            sm.setChatId(chat_id);
            sm.setText(path);
            if (call_data.equals("1")) {
                try {
                    execute(sm);
                } catch (TelegramApiException e) {

                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}