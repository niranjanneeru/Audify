package com.codingcrew.audify.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codingcrew.audify.R;

public class SignUpActivity extends AppCompatActivity {

    ImageView back_btn;
    Button next, login;
    TextView title;
    View rect,wave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        back_btn = findViewById(R.id.back_button);
        next = findViewById(R.id.next_button);
        login = findViewById(R.id.login_button);
        title = findViewById(R.id.sign_up_title_text);
        rect = findViewById(R.id.view);
        wave = findViewById(R.id.view2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpDetailsActivity.class);

                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View, String>(back_btn, "back_button_translation");
                pairs[1] = new Pair<View, String>(next, "next_button_translation");
                pairs[2] = new Pair<View, String>(login, "login_button_translation");
                pairs[3] = new Pair<View, String>(title, "title_translation");
                pairs[4] = new Pair<View, String>(rect, "view_1_translation");
                pairs[5] = new Pair<View, String>(wave, "view_2_translation");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

    }
}