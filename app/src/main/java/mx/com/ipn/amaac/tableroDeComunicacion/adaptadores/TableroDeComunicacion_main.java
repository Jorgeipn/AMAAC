package mx.com.ipn.amaac.tableroDeComunicacion.adaptadores;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mx.com.ipn.amaac.R;
import mx.com.ipn.amaac.tableroDeComunicacion.db.DBHelper;
import mx.com.ipn.amaac.tableroDeComunicacion.model.DataManager;
import mx.com.ipn.amaac.tableroDeComunicacion.model.MethodsManager;
import mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma;

import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.TIPO_PIC_NORMAL;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.TIPO_PIC_SELECCIONADO;
import static mx.com.ipn.amaac.tableroDeComunicacion.utilidades.Utilidades.getBackground;
import static mx.com.ipn.amaac.tableroDeComunicacion.utilidades.Utilidades.getBackground_CardView;

/**
 * Created by Jorge Lopez
 * Angel Fierro
 * on 31/10/2016.
 */
public class TableroDeComunicacion_main extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private RecyclerView recyclerView,recyclerView_frase;
    private PictogramaAdapter adapter;
    MethodsManager methodsManager=new MethodsManager();
    private List<Pictograma> PIC_GUARDADO=new ArrayList<Pictograma>();
    private TextToSpeech textToSpeech;
    private DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicador_main);
        textToSpeech = new TextToSpeech( this, this );

        db=new DBHelper(this);


        // Todas mis vistas de RecyclerView
        recyclerView =       (RecyclerView) findViewById(R.id.pictograma_list_categoria);
        recyclerView_frase = (RecyclerView) findViewById(R.id.pictograma_list_frase);


        // Todas las inicializaciones de adaptadores
        Init_Adapter(recyclerView,db.getAllPictogramas());



        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_play);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String x= methodsManager.Reproducir_Frase(PIC_GUARDADO);
                speak(x);

            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab_delete);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PIC_GUARDADO = methodsManager.DeleteAll(PIC_GUARDADO,getApplicationContext());
                Init_Adapter_Seleccionados(recyclerView_frase,PIC_GUARDADO);

            }
        });

        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab_regresar);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TableroDeComunicacion_main.this, "Metodo para regresar a la actividad principal", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void Init_Adapter(RecyclerView mRecyclerView , List<Pictograma> items){

        assert mRecyclerView != null;
        adapter = new PictogramaAdapter(items);
        setupRecyclerView(mRecyclerView,  adapter,TIPO_PIC_NORMAL);

    }


    public void Init_Adapter_Seleccionados(RecyclerView mRecyclerView , List <Pictograma> picto_seleccionados){

        assert mRecyclerView != null;
        adapter = new PictogramaAdapter(picto_seleccionados);
        setupRecyclerView( mRecyclerView,adapter,TIPO_PIC_SELECCIONADO);


    }



    private void setupRecyclerView(@NonNull RecyclerView recyclerView, PictogramaAdapter adapter, int tipo) {

        recyclerView.setAdapter(adapter);

        if (tipo==0){  recyclerView.setLayoutManager(new GridLayoutManager(this,5));  }
                     else{  recyclerView.setLayoutManager(new GridLayoutManager(this,8));  }

        /*********************************************** Nota*****************************************************/

        // recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //recyclerView.setLayoutManager( new GridLayoutManager(this, 3,GridLayoutManager.VERTICAL, false));
        //recyclerView.setLayoutManager( new GridLayoutManager(this, 3,GridLayoutManager.HORIZONTAL, false));

        /**********************************************Fin Nota*****************************************************/

    }

    /*****************************************************************************************************
     *    En esta parte se implementa y reproduce con voz el nombre del pictograma seleccionado
     *****************************************************************************************************/
    @Override
    public void onInit(int status) {
        if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
        {
            Toast toast=Toast.makeText(TableroDeComunicacion_main.this,"ola",Toast.LENGTH_SHORT);
            toast.show();

        }
    }

    private void speak( String str )
    {
        System.out.println("*++++++++++++++++++++++++++++++++++++*");
        System.out.println("*     Reproducciendo el contenido    *");
        System.out.println("*++++++++++++++++++++++++++++++++++++*");
        System.out.println(str);

        textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
        textToSpeech.setSpeechRate( 0.0f );
        textToSpeech.setPitch( 0.0f );

        System.out.println("*++++++++++++++++++++++++++++++++++++*");
        System.out.println("*++++++++++++++++++++++++++++++++++++*");
    }


    @Override
    protected void onDestroy()
    {
        if ( textToSpeech != null )
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

     /*******************************************************************************************************
     *                                    Fin de TextoSpeech
     *******************************************************************************************************/

    public class PictogramaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<Pictograma> mValues;

        public PictogramaAdapter(List<Pictograma> items) {
            this.mValues = items;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            switch (viewType){

                case TIPO_PIC_NORMAL:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_pictograma_categoria, parent, false);
                    return new CategoriaViewHolder(view);

                case TIPO_PIC_SELECCIONADO:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_pictograma_frase, parent, false);
                    return new FraseViewHolder(view);

            }
            return null;
        }



        @Override
        public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
            Pictograma object= mValues.get(position);
            if (object != null) {
                switch (object.getTipo()) {

                    case TIPO_PIC_NORMAL:
                        ((CategoriaViewHolder) holder).mNombreView.setText(object.getNombre());
                        ((CategoriaViewHolder) holder).mImageView.setImageResource(object.getIdDrawable());
                        ((CategoriaViewHolder) holder).mImageView.setBackgroundResource(getBackground(object.getCategoria()));
                        ((CategoriaViewHolder) holder).cv.setCardBackgroundColor(getBackground_CardView(object.getCategoria()));

                        break;

                    case TIPO_PIC_SELECCIONADO:
                        ((FraseViewHolder) holder).mNombreViewFrase.setText(object.getNombre());
                        ((FraseViewHolder) holder).mImageViewFrase.setImageResource(object.getIdDrawable());
                        ((FraseViewHolder) holder).mImageViewFrase.setBackgroundResource(getBackground(object.getCategoria()));
                        ((FraseViewHolder) holder).cv.setCardBackgroundColor(getBackground_CardView(object.getCategoria()));


                        break;
                }
            }

            /* ************* Esta es la linea para colorear el pictograma de acuerdo a su categoria de pictograma **********************************************************************/

            // holder.mNombreView.setBackgroundResource(Utilidades.getBackground(mValues.get(position).getCategoria())); //Solo colorear el texto
            // holder.mImageView.setBackgroundResource(Utilidades.getBackground(mValues.get(position).getCategoria())); //Colorear

            //holder.mView.setBackgroundResource(Utilidades.getBackground(mValues.get(position).getCategoria())); //Colorear

            /*************************************************************************************************************************************************************************/
        }



        @Override
        public int getItemCount() {
            return mValues.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (mValues != null) {
                final  Pictograma object = mValues.get(position);
                if (object != null) {
                    return object.getTipo();
                }
            }
            return 0;
        }



        public  class CategoriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public  ImageView mImageView;
            private TextView mNombreView;
            private CardView cv;

            public CategoriaViewHolder(View view) {
                super(view);
                view.setOnClickListener(this);

                mImageView = (ImageView) view.findViewById(R.id.iv_card_Categoria);
                mNombreView = (TextView) view.findViewById(R.id.tv_card_nombre_categoria);
                cv=(CardView) itemView.findViewById(R.id.cv_pictograma);


            }

            @Override
            public void onClick(View v) {

                int posicion=getAdapterPosition();
                Pictograma mPictograma= mValues.get(posicion);

                methodsManager.Init_Toast(v,mPictograma);

                Locale locSpanish = new Locale("spa", "MEX");
                textToSpeech.setLanguage(locSpanish);
                speak(mPictograma.getNombre());

                PIC_GUARDADO=methodsManager.Guardar(TIPO_PIC_SELECCIONADO,mPictograma.getCategoria(),mPictograma.getNombre(),mPictograma.getIdDrawable(),PIC_GUARDADO);
                Init_Adapter_Seleccionados(recyclerView_frase,PIC_GUARDADO);

            }
        }
        ////////////////////////////////////////////////////////////////////////////
        public class FraseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            public final View mView;
            public  final ImageView mImageViewFrase;
            public  final TextView mNombreViewFrase;
            public CardView cv;


            public FraseViewHolder(View view) {
                super(view);
                mView = view;
                mImageViewFrase=(ImageView) view.findViewById(R.id.iv_card_Frase);
                mNombreViewFrase=(TextView) view.findViewById(R.id.tv_card_nombre_Frase);
                cv=(CardView) view.findViewById(R.id.cv_pictograma_frase);

                view.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {

                int position = getAdapterPosition();
                PIC_GUARDADO = methodsManager.Delete_Picto_Seleccionado(position,PIC_GUARDADO);
                Init_Adapter_Seleccionados(recyclerView_frase,PIC_GUARDADO);


            }
        }


        ////////////////////////////////////////////////////////////////////
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
    }
}
