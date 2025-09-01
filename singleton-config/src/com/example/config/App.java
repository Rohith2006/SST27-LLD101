package com.example.config;

import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        String path = args.length > 0 ? args[0] : "app.properties";
    AppSettings.getInstance().loadFromFile(Paths.get(path)); // singleton, thread-safe load
        System.out.println("app.name=" + AppSettings.getInstance().get("app.name"));
        System.out.println("instance=" + System.identityHashCode(AppSettings.getInstance()));
        AppSettings.getInstance().loadFromFile(Paths.get(path)); // singleton, thread-safe load
        System.out.println("instance=" + System.identityHashCode(AppSettings.getInstance()));
        
    }
}
