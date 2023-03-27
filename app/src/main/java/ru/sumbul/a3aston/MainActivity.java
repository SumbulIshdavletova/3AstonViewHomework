package ru.sumbul.a3aston;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextInputEditText requestInput;
    ImageView imageView;
    Bitmap bitmap;
    CharSequence text = "Picture loading error!";
    int duration = Toast.LENGTH_SHORT;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.searched_image);
        requestInput = findViewById(R.id.search);



        requestInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String question = String.valueOf(requestInput.getText());

                new GetImageFromUrl(imageView).execute(question);

                return false;
            }
        });
    }
//    public void displayExceptionMessage(String msg)
//    {
//
//    }

    public class GetImageFromUrl extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;



        public GetImageFromUrl(ImageView img) {
            this.imageView = img;
        }

        @Override
        protected Bitmap doInBackground(String... url) {
            String stringUrl = url[0];
            bitmap = null;
            InputStream inputStream;
            try {
                inputStream = new java.net.URL(stringUrl).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
               // displayExceptionMessage(e.getMessage());
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }
}


