package com.uu.kiwii.dto;

public record Scrap(String title, String url, String imgUrl, String name, String rm) {
    
    public Scrap {
        if (imgUrl.isEmpty() || imgUrl.isBlank()) {
            imgUrl = "https://static.vecteezy.com/ti/vetor-gratis/p3/3641274-colorido-kiwi-sketches-with-cut-kiwi-vector-illustration-isolated-vetor.jpg";
        }
    }
}
