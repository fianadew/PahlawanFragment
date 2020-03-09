package com.example.pahlawanfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HeroesDetail extends AppCompatActivity {

    //private final ArrayList<Heroes> listHero;
    Button btnShare;
    ImageView ivDetail;
    TextView tvDetailTitle, tvDetailDesc;

   /* public HeroesDetail(ArrayList<Heroes> listHero, Context context) {
        this.listHero = listHero;
        this.context = context;
    }
    public ArrayList<Heroes> getListHero() {
        return listHero;
    }
    private Context context;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivDetail = findViewById(R.id.detail_hero_gambar);
        tvDetailTitle = findViewById(R.id.detail_hero_title);
        tvDetailDesc = findViewById(R.id.detail_hero);
        btnShare = findViewById(R.id.btn_share);

        getIncomingIntent();

    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int getImg = bundle.getInt("img_url");
            String getTitle = bundle.getString("title");
            String getDetail = bundle.getString("detail");

            tvDetailTitle.setText(getTitle);
            tvDetailDesc.setText(getDetail);
            ivDetail.setImageResource(getImg);

            /*btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    final int position;
                    String heroName = "Pahlawan " + getListHero();
                    intent.putExtra(Intent.EXTRA_TEXT, heroName);
                    context.startActivity(Intent.createChooser(intent, "Share Using"));
                }
            });*/
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
