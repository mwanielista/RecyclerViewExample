package eu.wanielista.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public RecyclerAdapter(Context c, String n[], String d[], int img[]) {
        context = c;
        data1 = n;
        data2 = d;
        images = img;
        context = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(data1[position]);
        holder.desc.setText(data2[position]);
        holder.image.setImageResource(images[position]);

        holder.conslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("image", images[position]);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, desc;
        ImageView image;
        RelativeLayout conslayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            desc = itemView.findViewById(R.id.description_tv);
            image = itemView.findViewById(R.id.logo);
            conslayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
