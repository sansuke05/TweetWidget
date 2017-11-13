package com.alicelab.tweetwidget;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import java.util.Random;

import twijava.TwiJava;

/**
 * Created by user on 2017/11/12.
 */

public class TwitterCommunication {

    private String[] tweets = {
            "帰宅",
            "帰宅しました",
            "きたく",
            "ただいま"
    };

    private String[] extra_symbols = {
            "〜",
            "ー！",
            "！",
            ""

    };

    private Context context;

    public TwitterCommunication(Context context){
        this.context = context;
    }

    public String tweet(){

        Random r = new Random();
        Resources resources = context.getResources();
        String status = "";
        status += "[application test] ";
        status += tweets[r.nextInt(tweets.length)];
        status += extra_symbols[r.nextInt(extra_symbols.length)];


        TwiJava twitter = new TwiJava.SetAPIToken()
                .setConsumerKey(resources.getString(R.string.consumerkey))
                .setConsumerSecretKey(resources.getString(R.string.consumerkeysecret))
                .setAccessToken(resources.getString(R.string.accessToken))
                .setAccessTokenSecret(resources.getString(R.string.accessTokensecret))
                .buildTokens();

        try {
            twitter.tweet(status);
        } catch (Exception e){
            e.printStackTrace();
        }

        return status;
    }
}
