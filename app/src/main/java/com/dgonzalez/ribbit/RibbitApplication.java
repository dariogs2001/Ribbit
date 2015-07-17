package com.dgonzalez.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.PushService;

/**
 * Created by dgonzalez on 4/9/2015.
 */
public class RibbitApplication extends Application {

    @Override
    public void onCreate() {
//        super.onCreate();
        Parse.initialize(this, "lXjcribz2HtBORvcs6q2XuRj2Hq4Z8zblTkNNain", "TrvU0a25PmSAe8fg67beh1fQVcP1MUGWdXbxRVUc");
      /*  PushService.setDefaultPushCallback(this, MainActivity.class);
        PushService.startServiceIfRequired(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        */
        super.onCreate();
    }

    public static void updateParseInstallation(ParseUser user)
    {
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());

        installation.saveInBackground( );
    }
}
