package com.example.yosep.webservice;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context ctx;

    public BackgroundTask(Context ctx) {

        this.ctx = ctx;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String insert_url = "http://192.168.1.54/componentes/insert.php";
        String update_url = "http://192.168.1.54/componentes/modify.php";
        String delete_url = "http://192.168.1.54/componentes/delete.php";

        String method = params[0];

        if (method.equals("register")){

            String marca = params[1];
            String descripcion = params[2];
            String precio = params[3];

            try {

                URL url = new URL(insert_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("marca","UTF-8") +"="+URLEncoder.encode(marca,"UTF-8")+"&"+
                                URLEncoder.encode("descripcion","UTF-8") +"="+URLEncoder.encode(descripcion,"UTF-8")+"&"+
                                URLEncoder.encode("precio","UTF-8") +"="+URLEncoder.encode(precio,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();

                return "Se ha registrado con exito";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if (method.equals("update")){

            String marca = params[1];
            String descripcion = params[2];
            String precio = params[3];
            String oldmarca = params[4];

            try {

                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("marca","UTF-8") +"="+URLEncoder.encode(marca,"UTF-8")+"&"+
                        URLEncoder.encode("descripcion","UTF-8") +"="+URLEncoder.encode(descripcion,"UTF-8")+"&"+
                        URLEncoder.encode("precio","UTF-8") +"="+URLEncoder.encode(precio,"UTF-8")+"&"+
                        URLEncoder.encode("oldmarca","UTF-8") +"="+URLEncoder.encode(oldmarca,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();

                return "Se ha modificado con exito";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if (method.equals("delete")){

            String marca = params[1];

            try {

                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("marca","UTF-8") +"="+URLEncoder.encode(marca,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();

                return "Se ha borrado con exito";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result){

        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();

    }
}
