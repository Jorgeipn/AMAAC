package mx.com.ipn.amaac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TerminosYCondiciones extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_y_condiciones);

        preferences = getSharedPreferences("TerminosYCondiciones", MODE_PRIVATE);
        boolean TERMINOS_Y_CONDICIONES= preferences.getBoolean("opcion", false);

    }

    public void TYC_aceptar(View view){
        SharedPreferences.Editor editor= preferences.edit();
        editor.putBoolean("opcion", true);
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void TYC_rechazar(View view){
        finish();
    }




}
