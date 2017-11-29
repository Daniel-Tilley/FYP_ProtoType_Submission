package danieltilley.ie.trainingpal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String user = intent.getStringExtra("UserDetails");
        text = (TextView) findViewById(R.id.message);
        text.setText("Your e-mail: " + user);
    }

    public void UpdateUser(View v){
        Toast.makeText(getApplicationContext(),"Update User!",Toast.LENGTH_LONG).show();
    }

}
