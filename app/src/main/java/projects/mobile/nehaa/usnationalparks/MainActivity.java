package projects.mobile.nehaa.usnationalparks;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// set up retrofit for API access and Gson
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// java io for API call
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * MainActivity sets up the main user interface. This will contain the search bar
 * for users to query their desired national park. Clicking the search button or enter
 * will navigate them to another activity in which the API response will be displayed.
 *
 * @author Nehaa Umapathy
 */
public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    ParkApi parksApi;
    String apiKey;
    EditText searchInput;
    Button searchB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // load unique API key from assets/apikeys.properties
        try {
            Properties properties = new Properties();
            InputStream inputStream = getAssets().open("apikeys.properties");
            properties.load(inputStream);
            apiKey = properties.getProperty("NPS_API_KEY", "");
        } catch (IOException e) {
            e.printStackTrace();
            apiKey = "";
        }

        // retrofit to make API calls
        retrofit = new Retrofit.Builder()
                .baseUrl("https://developer.nps.gov/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        parksApi = retrofit.create(ParkApi.class);

        // connect UI components using their IDs from activity_main.xml
        //searchInput = findViewById(R.id.~~);
        //searchB = findViewById(R.id.~~);
    } // onCreate

    private void searchForPark(String query) {

    } // searchForPark
}