package com.example.rikym.thiefttracker;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Rikym on 25/03/2017.
 */

public class VolleySingleton {

    //Atributos
    private static VolleySingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleySingleton(Context context)
    {
        VolleySingleton.context = context;
        requestQueue = getRequestQueue();
    }

    /**
     * Retornamos la instancia unica del singleton
     *@param context contexto donde se ejecutaran las peticiones
     *@return Instancia
     */
    public static synchronized VolleySingleton getInstance(Context context)
    {
        if(singleton == null)
        {
            singleton = new VolleySingleton(context.getApplicationContext());
        }
        return singleton;
    }

    /**
     * Obtiene la instancia de la cola de peticiones
     * @return cola de peticiones
     */
    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    /**
     * Añade la peticion a la cola
     * @param req peticion
     * @param <T> Resultado final de tipo T
     */
    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }
}
