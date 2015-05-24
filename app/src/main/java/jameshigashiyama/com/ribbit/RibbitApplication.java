package jameshigashiyama.com.ribbit;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import jameshigashiyama.com.ribbit.utils.ParseConstants;

/**
 * Created by James on 5/8/2015.
 */
public class RibbitApplication extends Application {

    @Override
    public void onCreate() {
        // Enable Local Datastore.
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "KvMrXLtr3iuM9lIHByW3VzUVcJ4CstxB5Rl0RPTB", "bQHKWUahRbV6WSJfeRjsCmi1Tr5v4oeCVOMjGxXd");
        ParseUser.enableRevocableSessionInBackground();

        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });

        ParseInstallation.getCurrentInstallation().saveInBackground();

    }

    public static void updateParseInstallation(ParseUser user) {
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
        installation.saveInBackground();
    }
}
