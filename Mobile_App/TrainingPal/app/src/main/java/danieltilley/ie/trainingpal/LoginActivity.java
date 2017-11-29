package danieltilley.ie.trainingpal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import danieltilley.ie.trainingpal.dao.api.UserDAO;
import danieltilley.ie.trainingpal.interfaces.IAPIUserCallback;
import danieltilley.ie.trainingpal.model.User;

public class LoginActivity extends Activity {

    private EditText usernameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
    }

    public void LoginUser(View v){

        String username = usernameText.getText().toString();

        UserDAO userDAO = new UserDAO(getApplicationContext());
        userDAO.getUser(username, new IAPIUserCallback(){

            @Override
            public void onSuccess(User user) {
                if(user.getPassword().equals(passwordText.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_LONG).show();

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("UserDetails", user.getE_mail());
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login Un-Successful!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),"There was an error logging in, please try again!",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void CreateUser(View v){
        Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(i);
    }
}
