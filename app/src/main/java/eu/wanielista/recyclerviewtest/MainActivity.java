package eu.wanielista.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String name[], desc[];
    int img[] = {
            R.drawable.logo1,
            R.drawable.logo2,
            R.drawable.logo3,
            R.drawable.logo4
    };

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


        name = getResources().getStringArray(R.array.array1);
        desc = getResources().getStringArray(R.array.description);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, name, desc, img);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}