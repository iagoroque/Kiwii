package com.uu.kiwii.dto;

public record Scrap(String title, String url, String imgUrl, String name, String rm) {

    public Scrap {
        if (title.length() > 45) {
            int lastSpaceIndex = title.substring(0, 45).lastIndexOf(" ");

            if (lastSpaceIndex != -1) {
                title = title.substring(0, lastSpaceIndex);
            } else {
                title = title.substring(0, 40);
            }
        }
        

        if (name != null && !name.isEmpty()) {
            String[] names = name.split(" ");
            if (names.length > 1) {
                name = names[0] + " " + names[names.length - 1];
            }
        }

        if (imgUrl.isEmpty() || imgUrl.isBlank()) {
            imgUrl = "https://img.freepik.com/premium-vector/kiwi-fruit-seamless-pattern-kiwi-cartoon-hand-drawn-style-repeated-backdrop-whole-fruit-cut-half-food-template-background-textile-wrapping-paper-wallpaper_153905-209.jpg";
        }
    }
}
