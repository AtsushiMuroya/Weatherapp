package sorajirocom.android.wetherapi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LogoActivity extends AppCompatActivity {
    Runnable moveToStartActivity;
    Handler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        getSupportActionBar().hide();

        moveToStartActivity = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this, GpsActivity.class);
                startActivity(intent);
                finish();
            }
        };

        h = new Handler();
        h.postDelayed(moveToStartActivity, 3000);



    }
}
