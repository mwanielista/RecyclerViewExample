package eu.wanielista.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView image;
    TextView name, description;

    String data1, data2;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        image = findViewById(R.id.imagev);
        name = findViewById(R.id.name_tv);
        description = findViewById(R.id.description_tv);

        getData();
        setData();

    }

    private void getData() {
        if(getIntent().hasExtra("image") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            img = getIntent().getIntExtra("image", 1);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT);
        }
    }

    private void setData() {
        name.setText(data1);
        description.setText(data2);
        image.setImageResource(img);
    }
}