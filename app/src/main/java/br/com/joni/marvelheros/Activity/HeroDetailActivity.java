package br.com.joni.marvelheros.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.joni.marvelheros.Model.Character;
import br.com.joni.marvelheros.R;

public class HeroDetailActivity extends AppCompatActivity {

    private ImageView ivHero;
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvModified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail);


        Character character = (Character) getIntent().getExtras().getSerializable("hero");

        ivHero = (ImageView) findViewById(R.id.ivHero);
        tvName = (TextView) findViewById(R.id.tvName);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvModified = (TextView) findViewById(R.id.tvModified);

        Picasso.get().load(character.getThumbnail().getPath()+"."+character.getThumbnail().getExtension()).into(ivHero);
        tvName.setText(character.getName());
        tvDescription.setText(character.getDescription());
        tvModified.setText(character.getModified());


    }
}
