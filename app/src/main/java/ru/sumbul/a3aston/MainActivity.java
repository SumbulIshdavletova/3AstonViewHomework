package ru.sumbul.a3aston;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextInputEditText requestInput;
    ImageView imageView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.searched_image);
        requestInput = findViewById(R.id.search);
        requestInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String question = String.valueOf(requestInput.getText());
                try {
                    Glide.with(imageView)
                            .load(question)
                            .placeholder(R.drawable.ic_baseline_rotate_right_24)
                            .error(R.drawable.ic_baseline_error_24)
                            .timeout(10_000)
                            .into(imageView);
                } catch (IOException e) {
                    display(e.getMessage());
                }
                return false;
            }
        });
    }

    public void display(String msg) {
        Context context = createContext();
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
