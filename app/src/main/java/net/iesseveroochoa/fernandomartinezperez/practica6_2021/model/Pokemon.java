package net.iesseveroochoa.fernandomartinezperez.practica6_2021.model;

import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Entity(tableName = Pokemon.TABLE_NAME,
        indices = {@Index(value = {Pokemon.NOMBRE},unique = true)})
public class Pokemon {
    public static final String TABLE_NAME="pokemon";
    public static final String ID= BaseColumns._ID;
    public static final String NOMBRE="nombre";
    public static final String URL="url";
    public static final String FECHA_COMPRA="fechacompra";

    public static final String
            urlIMAGEN="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name=ID)
    private int id;
    @ColumnInfo(name = NOMBRE)
    @NonNull
//@SerializedName("name")//retrofit
    private String nombre;
    @ColumnInfo(name = URL)
    @NonNull
    private String url;
    @ColumnInfo(name = FECHA_COMPRA)
    @NonNull
    private Date fechaCompra;

    public Pokemon(@NonNull String nombre, @NonNull String url, Date fechaCompra) {
        this.nombre = nombre;
        this.url = url;
        this.fechaCompra = fechaCompra;
    }

    public String getFechaCompraFormatoLocal(){
        if(fechaCompra!=null) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                    Locale.getDefault());
            return df.format(fechaCompra);
        }else{
            return "";
        }
    }

    public String getUrlImagen(){
        String url = getUrl();
        String[] pokemonIndex = url.split("/");
        return (urlIMAGEN+pokemonIndex[pokemonIndex.length-1] +".png");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    public void setUrl(@NonNull String url) {
        this.url = url;
    }

    @NonNull
    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(@NonNull Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
