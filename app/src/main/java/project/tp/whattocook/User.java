package project.tp.whattocook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class User extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");

        TextView tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(name + "!");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.user_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), RecipeOfTheDay.class);
                startActivity(intent);
            }
        });
    }
}