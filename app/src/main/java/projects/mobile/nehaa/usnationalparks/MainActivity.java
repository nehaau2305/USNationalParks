package projects.mobile.nehaa.usnationalparks;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// set up retrofit for API access and Gson
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        retrofit = new Retrofit.Builder()
                .baseUrl("https://developer.nps.gov/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        parksApi = retrofit.create(ParkApi.class);
    }
}