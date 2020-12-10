package model;

import org.json.JSONObject;

public class Articles {
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;
    public Source source;

    public static Articles parseArticleResponse(JSONObject jsonObject){
        Articles item = new Articles();

        item.author = jsonObject.optString("author");
        item.title = jsonObject.optString("title");
        item.description = jsonObject.optString("description");
        item.url = jsonObject.optString("url");
        item.urlToImage = jsonObject.optString("urlToImage");
        item.publishedAt = jsonObject.optString("publishedAt");
        item.content =jsonObject.optString("content");
        item.source = Source.parseSourceResponse(jsonObject.optJSONObject("source"));
        return item;
    }
}
