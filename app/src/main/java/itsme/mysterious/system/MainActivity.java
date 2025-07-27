package itsme.mysterious.system;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ComponentActivity {

    private boolean isSplashDone = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Handle SplashScreen
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        // Keep splash screen visible until condition is false
        splashScreen.setKeepOnScreenCondition(() -> !isSplashDone);

        //Set Layout Settings
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Delay for 10 seconds before proceeding
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            isSplashDone = true;
        }, 10000); // 10000 ms = 10 sec
    }
}