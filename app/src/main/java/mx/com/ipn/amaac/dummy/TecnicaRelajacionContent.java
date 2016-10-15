package mx.com.ipn.amaac.dummy;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import mx.com.ipn.amaac.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TecnicaRelajacionContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<TecnicaRelajacion> ITEMS = new ArrayList<TecnicaRelajacion>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, TecnicaRelajacion> ITEM_MAP = new HashMap<String, TecnicaRelajacion>();



    static {
        // Add some sample items.

        agregarItem(new TecnicaRelajacion("1","10 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_tecnica_youtube));
        agregarItem(new TecnicaRelajacion("2","10 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_tecnica_notepad_18));
        agregarItem(new TecnicaRelajacion("3","10 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_tecnica_youtube));
        agregarItem(new TecnicaRelajacion("4","10 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_tecnica_notepad_18));
        agregarItem(new TecnicaRelajacion("5","10 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_tecnica_youtube));
        agregarItem(new TecnicaRelajacion("6","10 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_tecnica_notepad_18));

    }

    @NonNull
    private static String generarId() {
        return UUID.randomUUID().toString();
    }


    private static void agregarItem(TecnicaRelajacion item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }




    /**
     * A dummy item representing a piece of content.
     */
    public static class TecnicaRelajacion {
        public final String id;
        public final String titulo;
        public final String descripcion;
        public final String fecha;
        public final int idImagen;

        public TecnicaRelajacion(String id, String titulo, String descripcion,String fecha,int idImagen) {
            this.id = id;
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.fecha=fecha;
            this.idImagen=idImagen;
        }

        @Override
        public String toString() {
            return titulo;
        }
    }
}
