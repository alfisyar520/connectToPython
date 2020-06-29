package com.example.connectphyton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.theartofdev.edmodo.cropper.CropImage;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    ImageView iv_makanan;
    Uri mImageUri;
    Button btn_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }

        iv_makanan = findViewById(R.id.post_gambar);
        btn_post = findViewById(R.id.btn_post_analisis);
        textView = findViewById(R.id.ganti);



        iv_makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.activity().setAspectRatio(1, 1).start(MainActivity.this);
            }
        });

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Python py = Python.getInstance();

                PyObject pyf = py.getModule("versi android 2"); //nama file python

                PyObject obj = pyf.callAttr("testing", iv_makanan); //write definition name
                //PyObject obj = pyf.callAttr("test"); //write definition name


                textView.setText(obj.toString());
                Toast.makeText(MainActivity.this, "klik", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            mImageUri =result.getUri();
            iv_makanan.setImageURI(mImageUri);
        }
    }
}
