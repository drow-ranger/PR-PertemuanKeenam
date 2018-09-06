package com.deonico.prkelima;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listbuah = findViewById(R.id.lvBuah);

        final String[] strNamaBuah = {
                "Alpukat",
                "Apel",
                "Ceri",
                "Durian",
                "Jambu Air",
                "Manggis",
                "Strawberry"
        };

        final int[] intGambarBuah = {
                R.drawable.alpukat,
                R.drawable.apel,
                R.drawable.ceri,
                R.drawable.durian,
                R.drawable.jambuair,
                R.drawable.manggis,
                R.drawable.strawberry
        };

        final int[] intSuaraBuah = {
                R.raw.alpukat,
                R.raw.apel,
                R.raw.ceri,
                R.raw.durian,
                R.raw.jambuair,
                R.raw.manggis,
                R.raw.strawberry
        };

        //ArrayAdapter arrayNamaBuah = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, strNamaBuah);

        class CustomListAdapter extends BaseAdapter{

            @Override
            public int getCount() {
                return strNamaBuah.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(final int i, View view, ViewGroup viewGroup) {

                view = getLayoutInflater().inflate(R.layout.list_item, null);
                ImageView imageView = view.findViewById(R.id.iv_gambar_buah);
                final TextView textNamaBuah = view.findViewById(R.id.tv_nama_buah);

                imageView.setImageResource(intGambarBuah[i]);
                textNamaBuah.setText(strNamaBuah[i]);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, strNamaBuah[i], Toast.LENGTH_SHORT).show();

                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),intSuaraBuah[i]);
                        mp.start();
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });
                    }
                });

                return view;
            }
        }

        CustomListAdapter arrayNamaBuah = new CustomListAdapter();

        listbuah.setAdapter(arrayNamaBuah);
    }
}
