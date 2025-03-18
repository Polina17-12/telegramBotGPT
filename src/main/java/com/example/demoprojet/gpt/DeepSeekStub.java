package com.example.demoprojet.gpt;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!deepseek")
public class DeepSeekStub implements IDeepSeek {

    @Override
    public String askNetwork(String question) {
        return "Hi! I only meet robots";
    }
}
