package project.tp.whattocook;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        final EditText etEmail = (EditText) findViewById(R.id.email_signUp);
        final EditText etUsername = (EditText) findViewById(R.id.username_signUp);
        final EditText etPassword = (EditText) findViewById(R.id.pass_signUp);
        final Button signUp = (Button) findViewById(R.id.signup_signup_button);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                Log.i(Home.TAG, response);
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success) {
                                    Intent intent = new Intent(Signup.this, Login.class);
                                    Signup.this.startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
                                    builder.setMessage("Неуспешна регистрация")
                                            .setNegativeButton("Опитай пак", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                };

                RegisterRequest registerRequest = new RegisterRequest(username, email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Signup.this);
                queue.add(registerRequest);

                Action_SignupToHome(view);
                }
        });
    }

    public void Action_SignupToHome(View view) {
        Intent intent = new Intent(getApplication(), Home.class);
        startActivity(intent);
    }
}


