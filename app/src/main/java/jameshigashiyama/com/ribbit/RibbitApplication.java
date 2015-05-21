package jameshigashiyama.com.ribbit;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by James on 5/8/2015.
 */
public class RibbitApplication extends Application {

    @Override
    public void onCreate() {
        // Enable Local Datastore.
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "GML1Rc8vvwha8meFq5ubQHiGpJINArSnhgG6v3V4", "STxEciwyCOAYyiZcAJSH7nOIRpclRx1PJI3jMIeV");


    }
}
