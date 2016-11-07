package mx.com.ipn.amaac.tableroDeComunicacion.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma;

/**
 * Created by Jorge on 31/10/2016.
 */

public class DBHelper  extends SQLiteOpenHelper {


    //Nombre de la base de datos
    public static final  String NAME_DATABASE="pictogramas.sqlite";
    private static final int DB_SHEME_VERSION=1;//Version de la DB por si hay una nueva version y haya que actualizar la BD


    //Context context Es una referencia a la Activity
    public DBHelper(Context context) {
        super(context, NAME_DATABASE, null,DB_SHEME_VERSION);
    }
    //este metodo se encarga de inicializar la base de datos, se ejecuta siempre cuando se crea la clase
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_PICTOGRAMA);

    }

    //metodo usado en el caso de que haga falta actualizar la version de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //se elimina la veersion anterior de la tabla
        db.execSQL("DROP TABLE IF EXIST "+TABLE_PICTOGRAMA);
        //se crea la nueva version de la tabla
        onCreate(db);
    }

    //Nombre de la tabla pictograma
    public static final  String TABLE_PICTOGRAMA="pictograma";


    // Nombre de los campos de la tabla usuarios
    public static final  String ID="idPictograma";
    public static final  String TIPO="tipo";
    public static final  String CATEGORIA="categoria";
    public static final  String NOMBRE="nombre";
    public static final  String ID_DRAWABLE="idDrawable";


    //sentencia para crear la tabla pictograma

    public static final String CREATE_TABLE_PICTOGRAMA="CREATE TABLE "+ TABLE_PICTOGRAMA+" ("
            + ID           + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TIPO         + " INTEGER,"
            + CATEGORIA    + " INTEGER,"
            + NOMBRE       + " TEXT NOT NULL,"
            + ID_DRAWABLE  + " INTEGER);";



    /* addPictograma() Agrega un nuevo Pictograma a la  Database*/
    public void addPictograma(Pictograma picto) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIPO,picto.getTipo());
        values.put(CATEGORIA, picto.getCategoria());
        values.put(NOMBRE, picto.getNombre());
        values.put(ID_DRAWABLE,picto.getIdDrawable());

        db.insert(TABLE_PICTOGRAMA, null, values); //Insert query to store the record in the database
        db.close();
    }


    /* getAllPictogramas() Retorna una  lista de todos los pictogramas de la Database*/
    public List<Pictograma> getAllPictogramas() {
        List<Pictograma> usersList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_PICTOGRAMA;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Pictograma pic = new Pictograma(cursor.getInt(1), cursor.getInt(2),cursor.getString(3),cursor.getInt(4));
                usersList.add(pic);
            } while (cursor.moveToNext());
        }
        return usersList;
    }



    /*getUser() will return he user's object if id matches*/
    public Pictograma getUser(int user_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PICTOGRAMA, new String[]{ID,
                        NOMBRE, CATEGORIA,ID_DRAWABLE}, ID + "=?",
                new String[]{String.valueOf(user_id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Pictograma pic = new Pictograma(cursor.getInt(1), cursor.getInt(2),cursor.getString(3),cursor.getInt(4));
        return pic;
    }


    /* getCategoria() Retorna una lista de la categoria en la que pertenecen los pictogramas*/
    public List<Pictograma> getCategoria(int categoria) {
        List<Pictograma> usersList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_PICTOGRAMA + " WHERE " +CATEGORIA+"="+categoria ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Pictograma pic = new Pictograma(cursor.getInt(1), cursor.getInt(2),cursor.getString(3),cursor.getInt(4));
                usersList.add(pic);
            } while (cursor.moveToNext());
        }
        return usersList;
    }



    public int count(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCount= db.rawQuery("select count(*) from "+ TABLE_PICTOGRAMA , null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();

        return count;
    }



    /*getUsersCount() will give the total number of records in the table*/
    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PICTOGRAMA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();


    }

    /*updateUser() will be used to update the existing user record*/
    public int updateUser(Pictograma picto) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOMBRE, picto.getNombre());
        values.put(CATEGORIA, picto.getCategoria());
        values.put(ID_DRAWABLE,picto.getIdDrawable());
        // updating record
        return db.update(TABLE_PICTOGRAMA, values, ID + " = ?", // update query to make changes to the existing record
                new String[]{String.valueOf(picto.getId())});
    }

    /*deleteContact() to delete the record from the table*/
    public void deleteContact(Pictograma user) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_PICTOGRAMA, ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }
    //Para cerrar la conexión de la base de datos
    public void close(){
        this.close();
    }


}
