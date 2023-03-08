package com.example.notemanuelle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class MenuPrinciale extends Activity {

    Toolbar myToolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_princiale);
        myToolbar1 = findViewById(R.id.myToolbar1);

        myToolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        myToolbar1.inflateMenu(R.menu.main_menu);
        myToolbar1.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.idNewNote:
                        Intent intent = new Intent(MenuPrinciale.this, NumeroNote.class);
                        startActivity(intent);
                    }
                    return true;
            }


        });

    }

}
