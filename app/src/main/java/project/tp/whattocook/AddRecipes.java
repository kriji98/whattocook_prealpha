package project.tp.whattocook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddRecipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button addPhoto = (Button) findViewById(R.id.button_add_recipes_photo);

        addPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // finish the uploading of a picture
            }

        });
    }

}