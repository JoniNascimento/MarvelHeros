package br.com.joni.marvelheros.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

import br.com.joni.marvelheros.Adapter.RvHerosAdapter;
import br.com.joni.marvelheros.Api.HerosServices;
import br.com.joni.marvelheros.Fragment.FragmentList;
import br.com.joni.marvelheros.Model.Character;
import br.com.joni.marvelheros.Model.ReturnData;
import br.com.joni.marvelheros.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvHeros;
    RvHerosAdapter herosAdapter;
    List<Character> listHeros = new ArrayList<>();
    Retrofit retrofit;
    List<FragmentList> fragments = new ArrayList<FragmentList>();
    ImageButton buttonBack, buttonNext;
    EditText edtbusca;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtbusca = (EditText) findViewById(R.id.edtBusca);
        edtbusca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });


        buttonBack = (ImageButton) findViewById(R.id.btnBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(false);

            }
        });

        buttonNext = (ImageButton) findViewById(R.id.btnNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(true);

            }
        });


        retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com:443/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HerosServices herosServices = retrofit.create(HerosServices.class);

        String ts = String.valueOf(System.currentTimeMillis());

        String hash = getHach(ts);

        Call<ReturnData> call = herosServices.getHeros(ts,getString(R.string.public_Key),hash);

        call.enqueue(new Callback<ReturnData>() {
                         @Override
                         public void onResponse(Call<ReturnData> call, Response<ReturnData> response) {
                             if (response.isSuccessful()){

                                 Log.d("response", response.body().toString());
                                 ReturnData data = response.body();

                                 Log.d("response",  data.data.results.get(1).getDescription());
                                 listHeros = data.data.results;


                                 for (int i = 0; i < listHeros.size()/4; i ++) {
                                     FragmentList fragmentList = new FragmentList();
                                     fragmentList.position = i;

                                     int countlist = (i + 1) * 4;
                                     int startCount = ((i+1) * 4) - 4;

                                     if (startCount < 0){
                                         startCount = 0;
                                     }
                                     for (int j = startCount; j < countlist; j++ ){
                                         fragmentList.list.add(listHeros.get(j));
                                     }
                                     fragments.add(fragmentList);
                                 }

                                 FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                 FragmentList fragmentList = fragments.get(0);
                                 transaction.replace(R.id.frameLayoutFragment,fragmentList );
                                 transaction.commit();
                             }
                         }

                         @Override
                         public void onFailure(Call<ReturnData> call, Throwable t) {
                            Log.d("Response", t.getMessage() );
                         }
                     });

    }


    public String getHach(String ts){
        String publicKey = getString(R.string.public_Key);
        String privateKey = getString(R.string.private_key);
        String str = ts+privateKey+publicKey;

        return new String(Hex.encodeHex(DigestUtils.md5(str))); //DigestUtils.md5Hex(str);

    }

    public void changeFragment(boolean next){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentList fragmentList = fragments.get(getCurrentFragment(next));
        transaction.replace(R.id.frameLayoutFragment,fragmentList );
        transaction.commit();
    }



   public int getCurrentFragment(boolean next){
       FragmentManager fm = getSupportFragmentManager();
       if (fm != null) {
           List<Fragment> fragmentsAux = fm.getFragments();
           if (fragments != null) {
               for(int i = fragmentsAux.size() - 1; i >= 0; i--){
                   FragmentList fragmentList = (FragmentList) fragmentsAux.get(i);
                   if(fragmentList != null) {
                       if(fragmentList instanceof FragmentList) {
                           if (next){
                               if ((fragmentList.position + 1) > fragments.size() - 1) {
                                   return fragmentList.position;
                               } else {
                                   return fragmentList.position + 1;
                               }
                           }else{
                               if ((fragmentList.position - 1) < 0) {
                                   return 0;
                               } else {
                                   return fragmentList.position - 1;
                               }
                           }
                       }
                       break;
                   }
               }
           }
       }
       return 0;
   }

}
