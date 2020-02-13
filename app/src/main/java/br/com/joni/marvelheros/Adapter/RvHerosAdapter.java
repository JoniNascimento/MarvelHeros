package br.com.joni.marvelheros.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.joni.marvelheros.Model.Character;
import br.com.joni.marvelheros.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class RvHerosAdapter extends RecyclerView.Adapter<RvHerosAdapter.HerosVH> {

    private List<Character> listHeros;
    private Context context;
    private static HerosVH.ItemClickListener itemClickListener;

    public RvHerosAdapter(Context ctx, List<Character> list) {
        this.listHeros = list;
        this.context = ctx;

    }

    @NonNull
    @Override
    public HerosVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_heros, viewGroup, false);

        return new HerosVH(item);
    }

    @Override
    public void onBindViewHolder(@NonNull HerosVH herosVH, int i) {
            Character hero = listHeros.get(i);
            String pictureUrl = hero.getThumbnail().getPath() + "/standard_medium." + hero.getThumbnail().getExtension();
            Log.d("imageURL", pictureUrl);
            herosVH.heroName.setText(hero.getName());
            if (pictureUrl != "") {
                Picasso.with(this.context).load(pictureUrl).into(herosVH.heroPicture);
            }
    }

    @Override
    public int getItemCount() {
        return listHeros.size();
    }

    public void setOnItemClickListener(HerosVH.ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }




    public static class HerosVH extends  RecyclerView.ViewHolder implements View.OnClickListener {

        TextView heroName;
        CircleImageView heroPicture;


        public HerosVH(@NonNull View itemView) {
            super(itemView);

            heroName = itemView.findViewById(R.id.tvHeroName);
            heroPicture = itemView.findViewById((R.id.ivHeroPicture));
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null) {
                itemClickListener.onItemClick(getAdapterPosition());
            }
        }

        public interface ItemClickListener {

            void onItemClick(int position);
        }



    }
}
