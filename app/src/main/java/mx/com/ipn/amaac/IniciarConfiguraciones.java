package mx.com.ipn.amaac;


import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import mx.com.ipn.amaac.tableroDeComunicacion.model.DataManager;


public class IniciarConfiguraciones extends AppCompatActivity {
    TextView loadText;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_configuraciones);

        loadText = (TextView) findViewById(R.id.loadText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        progressBar.setMax(100);
        progressBar.setBackgroundColor(Color.TRANSPARENT);
        //progressBar.getProgressDrawable().setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN);
        progressBar.setProgress(0);

        AsyncTaskCargaDatos ATCargaDatos = new AsyncTaskCargaDatos(this);


        ATCargaDatos.execute();

        //Cargamos los pictogramas  a la base de datos
        DataManager dataManager = new DataManager();
        dataManager.Init_Pictogramas(this);


    }


    public class AsyncTaskCargaDatos extends AsyncTask<Void, Integer, Void> {

        Context mContext;

        AsyncTaskCargaDatos(Context context) {
            mContext = context;
        }

        @Override
        protected Void doInBackground(Void... params) {

            publishProgress(0);

            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(400);
                    publishProgress(i + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... value) {
            loadText.setText(value[0] + " %");
            progressBar.setProgress(value[0]);

        }

         @Override
         protected void onPostExecute(Void result) {

             mContext.startActivity(new Intent(mContext, MainActivity.class));
             finish();
         }

    }// fin asynctask


 }//fon cla