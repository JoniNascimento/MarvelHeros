package br.com.joni.marvelheros.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import br.com.joni.marvelheros.R;

public class RvButtonAdapter  extends RecyclerView.Adapter<RvButtonAdapter.HolderButton>  {
    private Context context;
    private List<Button>listButons = new ArrayList<Button>();
    private static RvButtonAdapter.HolderButton.ItemClickListener itemClickListener;

    public RvButtonAdapter(Context ctx, List<Button> list) {
        this.context = ctx;
        this.listButons = list;
    }

    @NonNull
    @Override
    public HolderButton onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_pages, parent, false);
        return new HolderButton(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderButton holderButton, int i) {
        holderButton.btnPage.setText(String.valueOf(i + 1));

    }

    @Override
    public int getItemCount() {
        return listButons.size();
    }

    public void setOnItemClickListener(RvButtonAdapter.HolderButton.ItemClickListener itemClickListener){
        this.itemClickListener = (HolderButton.ItemClickListener) itemClickListener;
    }





    public static class HolderButton extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button btnPage;

    public HolderButton(@NonNull View itemView) {
        super(itemView);
        btnPage = itemView.findViewById(R.id.btnPage);
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
