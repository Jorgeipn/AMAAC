package mx.com.ipn.amaac.tableroDeComunicacion.model;

import android.content.Context;

import mx.com.ipn.amaac.R;
import mx.com.ipn.amaac.tableroDeComunicacion.db.DBHelper;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.TIPO_PIC_NORMAL;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.CAT_ALIMENTOS;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.CAT_ANIMALES;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.CAT_FAMILIA;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.CAT_LUGARES;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.CAT_PROFESIONES;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.CAT_VERBOS;

/**
 * Created by Angel on 06/11/2016.
 */

public class DataManager {

    public void Init_Pictogramas(Context contexto){
        DBHelper dbHandler=new DBHelper(contexto);

        System.out.println("*******************************************************************************");
        System.out.println("Entre al metodo Init_pictogramas");

        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Comer",R.drawable.ic_pic_verbos_comer));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Comprar", R.drawable.ic_pic_verbos_comprar));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Escribir",R.drawable.ic_pic_verbos_escribir));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Estudiar",R.drawable.ic_pic_verbos_estudiar));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Jugar",R.drawable.ic_pic_verbos_jugar));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Leer",R.drawable.ic_pic_verbos_leer));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Nadar",R.drawable.ic_pic_verbos_nadar));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Saltar",R.drawable.ic_pic_verbos_saltar));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_VERBOS,"Viajar",R.drawable.ic_pic_verbos_viajar));


        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Coca",R.drawable.ic_pic_alimentos_coke));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Dona",R.drawable.ic_pic_alimentos_dona));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Hamburguesa",R.drawable.ic_pic_alimentos_hamburger));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Hot dog",R.drawable.ic_pic_alimentos_hotdog));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Huevo",R.drawable.ic_pic_alimentos_huevo));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Langosta",R.drawable.ic_pic_alimentos_langosta));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Leche",R.drawable.ic_pic_alimentos_leche));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Paleta de hielo",R.drawable.ic_pic_alimentos_paletadehielo));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Palomitas",R.drawable.ic_pic_alimentos_palomitas));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ALIMENTOS,"Sushi",R.drawable.ic_pic_alimentos_sushi));


        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_FAMILIA,"Hermana",R.drawable.ic_pic_familia_hermana));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_FAMILIA,"Hermano",R.drawable.ic_pic_familia_hermano));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_FAMILIA,"Prima",R.drawable.ic_pic_familia_prima));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_FAMILIA,"Primo",R.drawable.ic_pic_familia_primo));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_FAMILIA,"Vaca",R.drawable.ic_pic_animales_vaca));


        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Astronauta",R.drawable.ic_pic_profesiones_astronauta));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Capitán",R.drawable.ic_pic_profesiones_capitan));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Detective",R.drawable.ic_pic_profesiones_detective));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Doctor",R.drawable.ic_pic_profesiones_doctor));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Enfermera",R.drawable.ic_pic_profesiones_enfermera));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Granjero",R.drawable.ic_pic_profesiones_granjero));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Ingeniero",R.drawable.ic_pic_profesiones_ingeniero));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Maestra",R.drawable.ic_pic_profesiones_maestra));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Mesera",R.drawable.ic_pic_profesiones_mesera));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Piloto",R.drawable.ic_pic_profesiones_piloto));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_PROFESIONES,"Soldado",R.drawable.ic_pic_profesiones_soldado));


        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Aeropuerto",R.drawable.ic_pic_lugares_aeropuerto));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Banco",R.drawable.ic_pic_lugares_banco));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Casa",R.drawable.ic_pic_lugares_casa));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Circo",R.drawable.ic_pic_lugares_circo));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Ciudad",R.drawable.ic_pic_lugares_ciudad));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Clínica",R.drawable.ic_pic_lugares_clinica));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Disneylandia",R.drawable.ic_pic_lugares_disney_landia));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Estación de policía",R.drawable.ic_pic_lugares_estacion_policia));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Fábrica",R.drawable.ic_pic_lugares_fabrica));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Farmacia",R.drawable.ic_pic_lugares_farmacia));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Gasolinera",R.drawable.ic_pic_lugares_gasolineria));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Hospital",R.drawable.ic_pic_lugares_hospital));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Hotel",R.drawable.ic_pic_lugares_hotel));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Iglesia",R.drawable.ic_pic_lugares_iglesia));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Montaña",R.drawable.ic_pic_lugares_montanas));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Museo",R.drawable.ic_pic_lugares_museo));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Parque",R.drawable.ic_pic_lugares_parque));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Pizzería",R.drawable.ic_pic_lugares_pizzeria));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Tienda",R.drawable.ic_pic_lugares_tienda));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL,CAT_LUGARES,"Veterinaria",R.drawable.ic_pic_lugares_veterinaria));


        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Águila",R.drawable.ic_pic_animales_aguila));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Borrego cimarrón",R.drawable.ic_pic_animales_borrego_cimarron));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Buho",R.drawable.ic_pic_animales_buho));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Camaleón",R.drawable.ic_pic_animales_camaleon));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Conejo",R.drawable.ic_pic_animales_conejo));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Jirafa",R.drawable.ic_pic_animales_jirafa));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Libélula",R.drawable.ic_pic_animales_libelula));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Loro",R.drawable.ic_pic_animales_loro));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Mapache",R.drawable.ic_pic_animales_mapache));
        dbHandler.addPictograma(new Pictograma(TIPO_PIC_NORMAL, CAT_ANIMALES,"Vaca",R.drawable.ic_pic_animales_vaca));

        System.out.println("Se cargaron todos los Pictogramas en la base de datos");
        System.out.println("*******************************************************************************");



    }
}
