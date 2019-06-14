package com.example.hikeapp;

import android.content.Context;

public class DAOFactory {
    /**
     * Retourne un objet Etape interagissant avec la BDD
     * @return DAO
     */
    public static DAO getEtapeDAO(Context context){
        return new EtapeDAO(new DataBaseHelper(context));
    }
}