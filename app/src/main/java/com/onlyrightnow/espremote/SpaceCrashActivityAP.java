package com.onlyrightnow.espremote;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;



public class SpaceCrashActivityAP extends AppCompatActivity {

    void make_vibration(Vibrator vibe){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibe.vibrate(VibrationEffect.createOneShot(10, 255));
        } else {
            vibe.vibrate(100);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spacecrash);

        String address = "192.168.4.1";

        final MaterialButton button_up = findViewById(R.id.spacecrash_button_up);
        final MaterialButton button_down = findViewById(R.id.spacecrash_button_down);

        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        button_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_vibration(vibe);
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://" + address + "/H";
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });

        button_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_vibration(vibe);
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://" + address + "/L";
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });
    }
}
